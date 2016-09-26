package com.app.hack.toppr.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.hack.toppr.R;
import com.app.hack.toppr.adapters.TrackEventAdapter;
import com.app.hack.toppr.model.Websites;
import com.app.hack.toppr.services.ApiClient;
import com.app.hack.toppr.services.EventTrackApiInterface;
import com.app.hack.toppr.ultis.TrackEventGenericDialogBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */

public class HomeFragment extends Fragment {

   // private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private ProgressDialog mDialogHelper;
    public static final String TYPE = "json";
    public static final String QUERY = "list_events";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.event_home_page_fragment,container,false);

        initializeView(view);
        return view;
    }


    private void initializeView(View view) {
       // mSearchView = (SearchView) view.findViewById(R.id.track_event_searchview);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.track_event_homepage_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.hasFixedSize();

        //create service
        trackEventServiceCall();
    }

    private void trackEventServiceCall() {


        //show dialog
        mDialogHelper = TrackEventGenericDialogBuilder.builddefaultDialog(getContext(),"Please wait while loadin.. ",false,true);
        mDialogHelper.show();

        EventTrackApiInterface mEventTrackApiInterface = ApiClient.getRetrofitInstance().create(EventTrackApiInterface.class);
        Call<Websites> eventTrackApiCall = mEventTrackApiInterface.getEventTrackDetails(TYPE,QUERY);
        eventTrackApiCall.enqueue(new Callback<Websites>() {
            @Override
            public void onResponse(Call<Websites> call, Response<Websites> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        mDialogHelper.dismiss();
                        List<Websites.Website> mWebsites = response.body().getWebsites();
                        TrackEventAdapter mTrackEventAdapter = new TrackEventAdapter(mWebsites,getContext());
                        mRecyclerView.setAdapter(mTrackEventAdapter);
                    }
                }else {
                    Toast.makeText(getContext(),"Error "+response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Websites> call, Throwable t) {

            }
        });

    }
}
