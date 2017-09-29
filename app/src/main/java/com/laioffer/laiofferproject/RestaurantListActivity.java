package com.laioffer.laiofferproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class RestaurantListActivity extends AppCompatActivity implements RestaurantListFragment.OnItemSelectListener {


    RestaurantListFragment listFragment;
    RestaurantGridFragment gridFragment;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Log.e("Life cycle test", "We are at onCreate()");

        if (findViewById(R.id.fragment_container) != null) {
            Intent intent = getIntent();
            if (intent.getExtras() != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_list_container, new BackendListFragment()).commit();
            } else {
                listFragment =  new RestaurantListFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_list_container, listFragment).commit();
            }
        }

    }








    /**
     * A dummy function to get fake restaurant names.
     *
     * @return an array of fake restaurant names.
     */
    // Show different fragments based on screen size.
    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void onItemSelected(int position){
        gridFragment.onItemSelected(position);
    }

}






