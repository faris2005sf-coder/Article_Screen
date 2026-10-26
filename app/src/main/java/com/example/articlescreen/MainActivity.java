package com.example.articlescreen;

import android.os.Bundle;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        boolean dark = (getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES;

        changeColors(findViewById(android.R.id.content), dark);
    }

    void changeColors(View v, boolean dark) {
        if (v instanceof ScrollView)
            v.setBackgroundColor(dark ? 0xFF1E1006 : 0xFFFFF5EC);

        if (v instanceof TextView)
            ((TextView) v).setTextColor(
                    dark ? 0xFFFFE7D9 : 0xFF21150F);

        if (v instanceof ViewGroup)
            for (int i = 0; i < ((ViewGroup) v).getChildCount(); i++)
                changeColors(((ViewGroup) v).getChildAt(i), dark);
    }
}