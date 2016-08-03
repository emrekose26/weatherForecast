package com.emrekose.weatherapp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by emrekose on 3.08.2016.
 */

public class Font {

    public static final String OPEN_SANS_COND_BOLD_PATH = "fonts/OpenSansCondBold.ttf";
    public static final String OPEN_SANS_COND_LIGHT_PATH = "fonts/OpenSansCondLight.ttf";
    public static final String OPEN_SANS_COND_LIGHT_ITALIC_PATH = "fonts/OpenSansCondLightItalic.ttf";

    /**
     * @param context of application context on typeface
     * @param textView of which change font
     * @param fontPath in assets/fonts file name
     */
    public static void change(Context context, TextView textView, String fontPath){
        Typeface font = Typeface.createFromAsset(context.getAssets(),fontPath);
        textView.setTypeface(font);
    }
}
