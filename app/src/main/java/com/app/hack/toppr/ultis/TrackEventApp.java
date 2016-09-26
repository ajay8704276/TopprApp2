package com.app.hack.toppr.ultis;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */

public class TrackEventApp extends Application {

    private static TrackEventApp mTrackEventApp = null;

    /**
     * Common initialisation for Universal image loader provided by google
     */
    private void initializeUniversalImageLoader() {

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialise image loader
        initializeUniversalImageLoader();

    }

    /**
     *
     * @return singleton instance of App
     */
    public static  TrackEventApp getSingleInstance() {
        if(mTrackEventApp == null){
            mTrackEventApp = new TrackEventApp();
        }
        return mTrackEventApp;
    }

}
