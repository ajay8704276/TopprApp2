package com.app.hack.toppr.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.hack.toppr.R;
import com.app.hack.toppr.adapters.TrackEventAdapter;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */

public class StatisticsFragment extends Fragment {


    private static int totalHackathonCount = 0;
    private static int totalHiringCount = 0;
    private static int totalBotCount = 0;
    private static int totalCompetitive= 0;
    private Button mBackButton;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_statistics_fragment,container,false);

        if(getArguments()!=null){
            Bundle statisticsData = getArguments();
            totalBotCount = statisticsData.getInt(TrackEventAdapter.BOT);
            totalHiringCount = statisticsData.getInt(TrackEventAdapter.HIRING);
            totalHackathonCount = statisticsData.getInt(TrackEventAdapter.HACKATHON);
            totalCompetitive = statisticsData.getInt(TrackEventAdapter.COMPETITIVE);
        }

        drawPieChart(view);


        mBackButton = (Button) view.findViewById(R.id.event_statistic_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0){
                    fm.popBackStack();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Nothing to POP",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private void drawPieChart(View view) {

        // we're going to display pie chart for smartphones martket shares
        float[] categoriesValues = { totalBotCount,totalCompetitive,totalHackathonCount,totalHiringCount };
        String[] categoriesTypes = { "BOT", "COMPETITIVE", "HACKATHON", "HIRING" };

        int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN,};

        CategorySeries distriutionSeries = new CategorySeries(" Event Demographics");
        for(int i=0 ;i<categoriesValues.length;i++){
            distriutionSeries.add(categoriesTypes[i],categoriesValues[i]);


        }

        DefaultRenderer defaultRenderer = new DefaultRenderer();
        for (int i=0; i<categoriesValues.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
                    seriesRenderer.setColor(colors[i]);
                    seriesRenderer.setDisplayChartValues(true);
                    //Adding colors to the chart<br />
                    defaultRenderer.setBackgroundColor(Color.BLACK);
                    defaultRenderer.setLabelsTextSize(20f);
                    defaultRenderer.setLegendTextSize(20f);
                    defaultRenderer.setApplyBackgroundColor(true);
                    // Adding a renderer for a slice<br />
                    defaultRenderer.addSeriesRenderer(seriesRenderer);
        }

        defaultRenderer.setChartTitle("Event Demographic");
                defaultRenderer.setChartTitleTextSize(20);
                defaultRenderer.setZoomButtonsVisible(false);


        LinearLayout chartContainer = (LinearLayout) view.findViewById(R.id.chart_container);
                chartContainer.removeAllViews();
                // drawing pie chart<br />
                View mChart = ChartFactory.getPieChartView(getContext(), distriutionSeries, defaultRenderer);
                // adding the view to the linearlayout<br />
                chartContainer.addView(mChart);
    }
}
