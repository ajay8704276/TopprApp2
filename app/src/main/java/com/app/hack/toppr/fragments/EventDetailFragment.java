package com.app.hack.toppr.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hack.toppr.R;
import com.app.hack.toppr.activity.WebViewActivity;
import com.app.hack.toppr.adapters.TrackEventAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */

public class EventDetailFragment extends Fragment{

    private String title;
    private String imageUrl;
    private String experience;
    private String ctc;
    private String description;

    private TextView titleTV;
    private ImageView hackIV;
    private TextView experienceTV;
    private TextView ctcTV;
    private TextView descriptionTV;

    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    private TextView linkTV;
    private TextView shareTV;
    private ImageView closeIV;
    private TextView baclTV;
    private TextView statisticsTV;

    private static int totalHackathonCount = 0;
    private static int totalHiringCount = 0;
    private static int totalBotCount = 0;
    private static int totalCompetitive= 0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.event_track_detail_fragment,container,false);

        if(getArguments() != null){
            Bundle data = getArguments();
            title = data.getString(TrackEventAdapter.TITLE);
            imageUrl = data.getString(TrackEventAdapter.IMAGE_URL);
            experience = data.getString(TrackEventAdapter.EXPERIENCE);
            ctc = data.getString(TrackEventAdapter.CTC);
            description = data.getString(TrackEventAdapter.DESCRIPTION);
            totalBotCount = data.getInt(TrackEventAdapter.BOT);
            totalCompetitive = data.getInt(TrackEventAdapter.COMPETITIVE);
            totalHackathonCount = data.getInt(TrackEventAdapter.HACKATHON);
            totalHiringCount = data.getInt(TrackEventAdapter.HIRING);

        }

        /**
         * initialise views before using
         */
        initViews(view);
        return view;

    }

    private void initViews(View view) {


        titleTV = (TextView) view.findViewById(R.id.event_track_detail_title);
        hackIV = (ImageView) view.findViewById(R.id.event_track_detail_imageview);
        experienceTV = (TextView) view.findViewById(R.id.event_track_detail_experience);
        ctcTV = (TextView) view.findViewById(R.id.event_track_detail_ctc);
        descriptionTV = (TextView) view.findViewById(R.id.event_track_detail_description);

        linkTV = (TextView) view.findViewById(R.id.track_event_detail_link);
        linkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity().getApplicationContext(),"Detail link clicked",Toast.LENGTH_LONG).show();
                // open the webview using link

                Intent webViewIntent = new Intent(getActivity(), WebViewActivity.class);
                startActivity(webViewIntent);

            }
        });



        shareTV = (TextView) view.findViewById(R.id.track_event_detail_share);
        shareTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity().getApplicationContext(),"share button clicked",Toast.LENGTH_LONG).show();
                //share detail of hack
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TITLE,title );
                sharingIntent.putExtra(Intent.EXTRA_TEXT,description);
                startActivity(Intent.createChooser(sharingIntent,"Share using"));

            }
        });

        baclTV = (TextView) view.findViewById(R.id.track_event_detail_back);
        baclTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity().getApplicationContext(),"back buttton clicked",Toast.LENGTH_LONG).show();
                // go back to previous fragment

                FragmentManager  fm = getActivity().getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0){
                    fm.popBackStack();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Nothing to POP",Toast.LENGTH_LONG).show();
                }


            }
        });

        statisticsTV = (TextView) view.findViewById(R.id.track_event_detail_statistics);
        statisticsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getActivity().getApplicationContext(),"statisitcs buttton clicked",Toast.LENGTH_LONG).show();

                // go statistics page


                Bundle statisticsDataBundle = new Bundle();
                statisticsDataBundle.putInt(TrackEventAdapter.BOT,totalBotCount);
                statisticsDataBundle.putInt(TrackEventAdapter.HACKATHON,totalHackathonCount);
                statisticsDataBundle.putInt(TrackEventAdapter.HIRING,totalHiringCount);
                statisticsDataBundle.putInt(TrackEventAdapter.COMPETITIVE,totalCompetitive);

                Fragment statisticsFrag = new StatisticsFragment();
                statisticsFrag.setArguments(statisticsDataBundle);
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.main_container ,statisticsFrag).addToBackStack("ABC").commit();
            }
        });
        closeIV = (ImageView) view.findViewById(R.id.track_event_detail_close);
        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getActivity().getApplicationContext(),"close buttton clicked",Toast.LENGTH_LONG).show();

                // close the current fragment move to previous fragment
                FragmentManager  fm = getActivity().getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0){
                        fm.popBackStack();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Nothing to POP",Toast.LENGTH_LONG).show();
                }

            }
        });



        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)

                .build();

        // set the data to the views;
        titleTV.setText(title);
        imageLoader.displayImage(imageUrl,hackIV,options);
        experienceTV.setText(experience);
        ctcTV.setText(ctc);
        descriptionTV.setText(description);

    }

}
