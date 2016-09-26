package com.app.hack.toppr.ultis;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.app.hack.toppr.R;

/**
 * Created by Ajay Kumar on 8/5/2016.
 */

public class TrackEventFontTextView extends TextView {

    public TrackEventFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public TrackEventFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public TrackEventFontTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TrackEventFontTextView);
            String fontName = a.getString(R.styleable.TrackEventFontTextView_fontName);
            if (fontName!=null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+fontName);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }

}
