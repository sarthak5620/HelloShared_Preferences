package com.example.android.hellosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.android.hellosharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;
    SharedPreferences preferences;

    public static final String COUNT_KEY = "Count";
    public static final String COLOR_KEY = "Color";

    // Count value of text view
    private int Count;
    //Background color of text view
    private int BackgroundColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        preferences = getPreferences(MODE_PRIVATE);
        /*
         * If preferences are not null,assign default values to access the default color and count value
         */
        if (preferences != null) {
            Count = preferences.getInt(COUNT_KEY, 0);
            b.CountValue.setText(String.valueOf(Count));
            BackgroundColor = preferences.getInt(COLOR_KEY, getResources().getColor(R.color.gray));
            b.CountValue.setBackgroundColor(BackgroundColor);
        }
    }

    /**
     * over ride on pause method to get the default values when an activity is paused that is user changes the app he/she is using or is about to close the app
     */
    @Override
    protected void onPause() {
        super.onPause();

        preferences.edit()
                .putInt(COUNT_KEY, Count)
                .putInt(COLOR_KEY, BackgroundColor)
                .apply();
    }

    /**
     *
     * @param view Increase count of the text view
     */
    public void increaseCount(View view) {
        Count++;
        b.CountValue.setText(String.valueOf(Count));
    }

    /**
     *
     * @param view Reset all views to default values once the reset button is pressed
     */
    public void resetValues(View view) {
        Count = 0;
        b.CountValue.setText(String.valueOf(Count));
        BackgroundColor = getResources().getColor(R.color.gray);
        b.CountValue.setBackgroundColor(BackgroundColor);
        preferences.edit().clear().apply();
    }
    //Change the background color of textView to blue
    public void changeBgColorBlue(View view) {
        BackgroundColor = getResources().getColor(R.color.blue);
        b.CountValue.setBackgroundColor(BackgroundColor);
    }
    //Change the background color of textView to black
    public void changeBgColorBlack(View view) {
        BackgroundColor = getResources().getColor(R.color.black);
        b.CountValue.setBackgroundColor(BackgroundColor);
    }
    //Change the background color of textView to green
    public void changeBgColorGreen(View view) {
        BackgroundColor = getResources().getColor(R.color.green);
        b.CountValue.setBackgroundColor(BackgroundColor);
    }
    //Change the background color of textView to red
    public void changeBgColorRed(View view) {
        BackgroundColor = getResources().getColor(R.color.red);
        b.CountValue.setBackgroundColor(BackgroundColor);
    }
}