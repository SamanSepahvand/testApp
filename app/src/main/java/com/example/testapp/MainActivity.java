package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.testapp.fragment.MyPagerAdapter;

import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    BubbleTabBar bubbleTabBar;


    MyPagerAdapter adapterViewPager;

    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view=findViewById(R.id.view);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);


        bubbleTabBar = findViewById(R.id.bubbleTabBar);
        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {



                String strID = new Integer(i).toString();
                Log.d(TAG, strID);


                Log.e(TAG, "onBubbleClick: " + i);

                switch (i) {

                    case R.id.item_file:
                        vpPager.setCurrentItem(0);
                        changeColorView(0);

                        break;
                    case R.id.item_contact:
                        vpPager.setCurrentItem(1);
                        changeColorView(1);


                        break;
                    case R.id.item_home:
                        vpPager.setCurrentItem(2);
                        changeColorView(2);

                        break;

                }




            }
        });


        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {

                switch (position) {

                    case 0:

                        bubbleTabBar.setSelectedWithId(R.id.item_file,false);
                        break;
                    case 1:

                        bubbleTabBar.setSelectedWithId(R.id.item_contact,false);
                        break;

                    case 2:
                        bubbleTabBar.setSelectedWithId(R.id.item_home,false);
                        break;



                }
                changeColorView(position);
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void changeColorView(int tab){

        switch (tab){

            case 0:

              view.setBackgroundResource(R.color.gray2);

                break;

            case 1:
                view.setBackgroundResource(R.color.cherryLight);

                break;
            case 2:

                view.setBackgroundResource(R.color.newYellowDark);

                break;




        }


    }


}