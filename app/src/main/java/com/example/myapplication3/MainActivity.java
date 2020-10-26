package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private Spinner mCountriesSpinner;
    private Spinner mCountriesSpinner_1;
    private Spinner mCountriesSpinner_2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        //  findViewById(R.id.button3).setOnClickListener(this);
        //   findViewById(R.id.button4).setOnClickListener(this);


        Spinner spinner = findViewById(R.id.spinner);


        // Настраиваем адаптер
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.Language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Вызываем адаптер
        spinner.setAdapter(adapter);

        mCountriesSpinner = findViewById(R.id.spinner);


        Spinner spinner_1 = findViewById(R.id.spinner_1);
        ArrayAdapter<?> adapter_1 =
                ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mCountriesSpinner_1 = findViewById(R.id.spinner_1);

        spinner_1.setAdapter(adapter_1);

        // mCountriesSpinner_1 = findViewById(R.id.spinner_1);

        Spinner spinner_2 = findViewById(R.id.spinner_2);
        ArrayAdapter<?> adapter_2 =
                ArrayAdapter.createFromResource(this, R.array.access, android.R.layout.simple_spinner_item);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCountriesSpinner_2 = findViewById(R.id.spinner_2);

        spinner_2.setAdapter(adapter_2);


    }

    private String localeId;

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {

   
            case R.id.button2:

                String item_2 = mCountriesSpinner_2.getSelectedItem().toString();

                //String item_2 = mCountriesSpinner_1.getSelectedItem().toString();
                Toast.makeText(MainActivity.this
                        , mCountriesSpinner_2.getSelectedItem().toString()
                                + " "

                        , Toast.LENGTH_LONG)
                        .show();

                switch (item_2) {

                    //v.getId()
                    case "Мелкие":
                        Utils.changeToTheme(this, Utils.THEME_Margin1);
                        break;
                    case "Средние":
                        Utils.changeToTheme(this, Utils.THEME_Margin2);
                        break;
                    case "Большие":
                        Utils.changeToTheme(this, Utils.THEME_Margin3);
                        break;
                }

                break;


            case R.id.button:

                Toast.makeText(MainActivity.this
                        , mCountriesSpinner.getSelectedItem().toString()
                                + " "

                        , Toast.LENGTH_LONG)
                        .show();

                String item = mCountriesSpinner.getSelectedItem().toString();
                // String localeId;

                switch (item) {
                    case "English":
                        localeId = "en";
                        break;
                    case "Russian":
                        localeId = "ru";
                        break;
                    case "German":
                        localeId = "de";
                        break;
                }
                Locale locale = new Locale(localeId);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();

                break;

            case R.id.button_2:

                String item_1 = mCountriesSpinner_1.getSelectedItem().toString();

                //String item_1 = mCountriesSpinner_1.getSelectedItem().toString();
                Toast.makeText(MainActivity.this
                        , mCountriesSpinner_1.getSelectedItem().toString()
                                + " "

                        , Toast.LENGTH_LONG)
                        .show();

                switch (item_1) {

                    //v.getId()
                    case "black":
                        Utils.changeToTheme(this, Utils.THEME_Blue);
                        break;
                    case "green":
                        Utils.changeToTheme(this, Utils.THEME_Green);
                        break;
                    case "blue":
                        Utils.changeToTheme(this, Utils.THEME_Black);
                        break;
                }

                break;


        }


    }

    public static class Utils {
        private static int sTheme;

        public final static int THEME_Blue = 0;
        public final static int THEME_Green = 1;
        public final static int THEME_Black = 2;

        public final static int THEME_Margin1 = 3;
        public final static int THEME_Margin2 = 4;
        public final static int THEME_Margin3 = 5;

        /**
         * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
         */
        public static void changeToTheme(Activity activity, int theme) {
            sTheme = theme;
            activity.finish();

            // activity.startActivity(new Intent(activity, MainActivity.getClass()));


            Intent intent = new Intent();
            intent.setClass(activity, activity.getClass());
            activity.startActivity(intent);
            // activity.finish();
            activity.recreate();
        }

        /**
         * Set the theme of the activity, according to the configuration.
         * Margin1
         */
        public static void onActivityCreateSetTheme(Activity activity) {
            switch (sTheme) {
                default:
                case THEME_Blue:
                    activity.setTheme(R.style.AppThemeBlue);
                    break;
                case THEME_Green:
                    activity.setTheme(R.style.AppThemeGreen);
                    break;
                case THEME_Black:
                    activity.setTheme(R.style.AppThemeBlack);
                    break;

                case THEME_Margin1:
                    activity.setTheme(R.style.Margin1);
                    break;

                case THEME_Margin2:
                    activity.setTheme(R.style.Margin2);
                    break;

                case THEME_Margin3:
                    activity.setTheme(R.style.Margin3);
                    break;
            }
        }
    }


}