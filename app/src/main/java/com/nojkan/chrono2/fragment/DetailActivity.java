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
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.adapter.WorkoutAdapter;
import com.nojkan.chrono2.model.Niveau;
import com.nojkan.chrono2.model.NiveauxController;
import com.nojkan.chrono2.model.Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private CountDownTimer countDownTimer = null;
    private TextView countdownView = null;
    private int repos;
    private FloatingActionButton fab_play = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //setSupportActionBar((Toolbar) findViewById(R.id.detail_toolbar));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
       AppBarLayout appBarLayout =
                (AppBarLayout) findViewById(R.id.detail_appbar);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_workout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mPosition = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Log.v(TAG,"position Niveau: "+ mPosition);


        niveauxController = NiveauxController.getInstance(null);
        niveauxController.getIdNiveauxList();
        Niveau myNiveau = niveauxController.getNiveau(mPosition);
        Log.v(TAG,"Niveau in detail activity" + myNiveau.toString());

        countdownView = ((TextView) appBarLayout.findViewById(R.id.countdown));

        repos = Integer.parseInt(myNiveau.getExoArrayList().get(0).getReposBetweenSerie());

        fab_play = (FloatingActionButton) findViewById(R.id.fab_workout);
        countdownView = ((TextView) appBarLayout.findViewById(R.id.countdown));
        countdownView.setText("--");



        fab_play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //start timer
                startTimer(repos, countdownView);
                //change fab icon
                fab_play.setImageResource(R.drawable.ic_pause_white_24px);

            }



        });

       //Titre toolbar
        final TextView detailTitle = ((TextView) appBarLayout.findViewById(R.id.detail_title));
       detailTitle.setText("Niveau " + myNiveau.getIdNiveau());


        mNiveau = myNiveau.getIdNiveau();
        Log.v(TAG,"mNiveau : "+ mNiveau);
        myNiveau.getExoArrayList().get(0).getReposAfterExo();

        // Set title of Detail page



       List<Workout> workouts = myNiveau.getExoArrayList();


        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
       RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        //instantiate your adapter with the list of workouts
       adapter = new WorkoutAdapter(this.getApplicationContext(), workouts);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

   /*     RelativeLayout clear = (RelativeLayout) findViewById(R.id.item_workout);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clearChoices();
            }
        });
*/


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


    protected void startTimer(int repos, final TextView countdownView){

        new CountDownTimer( (repos)*100, 1000) {

            public void onTick(long millisUntilFinished) {
                countdownView.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                countdownView.setText("Go!");
                fab_play.setImageResource(R.drawable.ic_play_circle_filled_black_24px);

            }
        }.start();
    }



}


