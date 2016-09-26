package com.app.hack.toppr.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.app.hack.toppr.ultis.Constant;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */

public class WebViewActivity extends AppCompatActivity {


    private WebView mWebview ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final AppCompatActivity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebview .loadUrl(Constant.HACKER_EARTH_CHALLENGE_URL);
        setContentView(mWebview );

    }
}
