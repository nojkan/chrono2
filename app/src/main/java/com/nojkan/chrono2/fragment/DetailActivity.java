/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nojkan.chrono2.fragment;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.adapter.WorkoutAdapter;
import com.nojkan.chrono2.model.Niveau;
import com.nojkan.chrono2.model.NiveauxController;
import com.nojkan.chrono2.model.Workout;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_NIVEAU = "niveau";

    private static NiveauxController niveauxController;
    private int mPosition;

    private String mNiveau = "0";

    public WorkoutAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_workout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mPosition = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Log.v(TAG,"position Niveau: "+ mPosition);


        niveauxController = NiveauxController.getInstance(null);
        niveauxController.getIdNiveauxList();
        Niveau myNiveau = niveauxController.getNiveau(mPosition);
        Log.v(TAG,"Niveau in detail activity" + myNiveau.toString());
       /* String sNiveau = getIntent().getStringExtra(EXTRA_NIVEAU);
        Niveau myNiveau = NiveauxController.getInstance(this).getNiveau();*/
        collapsingToolbar.setTitle("Niveau : " + myNiveau.getIdNiveau());
        mNiveau = myNiveau.getIdNiveau();
        Log.v(TAG,"mNiveau : "+ mNiveau);

        // Set title of Detail page

        /*ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_workout);
        setupViewPager(viewPager);
*/


       List<Workout> workouts = myNiveau.getExoArrayList();

       /* RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_workout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
*/

        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
       RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        //instantiate your adapter with the list of workouts
       adapter = new WorkoutAdapter(workouts);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
/*
   private void setupViewPager(ViewPager viewPager) {
        DetailActivity.Adapter adapter = new Adapter(getSupportFragmentManager());
        WorkoutContentFragment wf = new WorkoutContentFragment();
        adapter.addFragment(wf, "ListWorkout");
        Bundle args = new Bundle();
        args.putString("niveau", mNiveau);
        args.putInt("idNiveauList", mPosition);
        wf.setArguments(args);
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

*/



}


