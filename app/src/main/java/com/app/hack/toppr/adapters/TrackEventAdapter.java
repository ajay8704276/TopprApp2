package com.app.hack.toppr.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.hack.toppr.R;
import com.app.hack.toppr.activity.TopprBaseActivity;
import com.app.hack.toppr.fragments.EventDetailFragment;
import com.app.hack.toppr.model.Websites;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */

public class TrackEventAdapter extends RecyclerView.Adapter<TrackEventAdapter.TrackEventViewHolder> {

    private Context mContext;
    private List<Websites.Website> mWebsite;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    private TopprBaseActivity mTopprBaseActivity;



    public static final String TITLE = "title";
    public static final String IMAGE_URL = "image_url";
    public static final String EXPERIENCE = "experience";
    public static final String CTC = "ctc";
    public static final String DESCRIPTION ="description";


    private  static int totalHackathonCount = 0;
    private static int totalHiringCount = 0;
    private static int totalBotCount = 0;
    private static int totalCompetitive= 0;


    public static final String HIRING = "HIRING";
    public static final String HACKATHON = "HACKATHON";
    public static final String BOT = "BOT";
    public static final String COMPETITIVE = "COMPETITIVE";



    @Override
    public TrackEventAdapter.TrackEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_track_card_view, parent, false);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)

                .build();

        return new TrackEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackEventAdapter.TrackEventViewHolder holder, final int position) {

        imageLoader.displayImage(mWebsite.get(position).getImage(),holder.trackEventImageView,options);
        holder.trackEventDescription.setText(mWebsite.get(position).getName().toUpperCase());
        holder.trackEventDetailAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startDetailDescriptionActivity
                Bundle data = new Bundle();
                data.putString(TITLE,mWebsite.get(position).getName());
                data.putString(IMAGE_URL , mWebsite.get(position).getImage());
                data.putString(EXPERIENCE,mWebsite.get(position).getExperience());
                data.putString(CTC,"CTC : 12L INR - 36L INR");
                data.putString(DESCRIPTION,mWebsite.get(position).getDescription());
                data.putInt(HACKATHON,totalHackathonCount);
                data.putInt(BOT,totalBotCount);
                data.putInt(COMPETITIVE,totalCompetitive);
                data.putInt(HIRING,totalHiringCount);

                mTopprBaseActivity = (TopprBaseActivity) mContext;
                Fragment fragment = new EventDetailFragment();
                fragment.setArguments(data);
                FragmentManager fragmentManager = mTopprBaseActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        holder.trackEventCategory.setText(mWebsite.get(position).getCategory());
        holder.trackEventFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // do saving of preference using file or shared preference
            }
        });

    }

    @Override
    public int getItemCount() {
        return mWebsite.size();
    }


    public class TrackEventViewHolder extends RecyclerView.ViewHolder{

        private ImageView trackEventImageView ;
        private TextView trackEventDescription;
        private ImageView trackEventDetailAction;
        private TextView trackEventCategory;
        private ImageView trackEventFavorite;


        public TrackEventViewHolder(View itemView) {
            super(itemView);

            trackEventImageView = (ImageView) itemView.findViewById(R.id.track_event_iv);
            trackEventDescription = (TextView) itemView.findViewById(R.id.track_event_hack_description);
            trackEventDetailAction = (ImageView) itemView.findViewById(R.id.track_event_detail_action);
            trackEventCategory = (TextView) itemView.findViewById(R.id.track_event_hack_category);
            trackEventFavorite = (ImageView) itemView.findViewById(R.id.track_event_favorite);
        }
    }

    public TrackEventAdapter(List<Websites.Website> mWebsites, Context mContext){

        this.mWebsite = mWebsites;
        this.mContext = mContext;

        getTotalCategoryCountEachItem(mWebsites);

    }

    private void getTotalCategoryCountEachItem(List<Websites.Website> mWebsites) {
        int length = mWebsites.size();
        for(int i= 0 ;i<length;i++){

            if(mWebsites.get(i).getCategory().equalsIgnoreCase(BOT)){
                totalBotCount++;
            }

            if (mWebsites.get(i).getCategory().equalsIgnoreCase(COMPETITIVE)){
                totalCompetitive++;
            }

            if (mWebsites.get(i).getCategory().equalsIgnoreCase(HIRING)){
                totalHiringCount++;

            }

            if (mWebsites.get(i).getCategory().equalsIgnoreCase(HACKATHON)){
                totalHackathonCount++;
            }

        }
    }
}
