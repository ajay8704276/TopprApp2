package com.app.hack.toppr.ultis;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.app.hack.toppr.R;


/**
 * Created by Ajay Kumar on 7/17/2016.
 */

public class TrackEventGenericDialogBuilder extends ProgressDialog {

    public static ProgressDialog dialog;

    public TrackEventGenericDialogBuilder(Context mContext) {
        super(mContext);

    }

    public TrackEventGenericDialogBuilder(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
    }


    public static ProgressDialog buildDialog(Context mContext, String msg, boolean isCancelable) {

        dialog = new TrackEventGenericDialogBuilder(mContext);
        dialog.setCancelable(isCancelable);
        dialog.setMessage(msg);
        return dialog;
    }

    public static ProgressDialog buildDialog(Context mContext, String msg, boolean isCancelable, boolean isDeterminate) {

        dialog = new TrackEventGenericDialogBuilder(mContext, android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
        dialog.setMessage(msg);
        dialog.setCancelable(isCancelable);
        dialog.setIndeterminate(isDeterminate);

        return dialog;
    }

    public static ProgressDialog builddefaultDialog(Context mContext, String msg, boolean isCancelable, boolean isDeterminate) {

        dialog = new ProgressDialog(mContext);
        dialog.setMessage(msg);
        dialog.setCancelable(isCancelable);
        dialog.setIndeterminate(isDeterminate);
        return dialog;
    }
}

