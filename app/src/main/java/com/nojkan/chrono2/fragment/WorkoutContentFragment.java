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

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.adapter.WorkoutAdapter;
import com.nojkan.chrono2.model.Niveau;
import com.nojkan.chrono2.model.NiveauxController;
import com.nojkan.chrono2.model.Workout;

import java.util.List;

/**
 * Provides UI for the view with List.
 */
public class WorkoutContentFragment extends Fragment {

    private static NiveauxController niveauxController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view_workout, container, false);

        //ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        //recyclerView.setAdapter(adapter);


        Bundle args = getArguments();
        int idListNiveau = args.getInt("idNiveauList", 0);

        niveauxController = NiveauxController.getInstance(null);
        niveauxController.getIdNiveauxList();
        Niveau myNiveau = niveauxController.getNiveau(idListNiveau);

        List<Workout> workouts = myNiveau.getExoArrayList();

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        //instantiate your adapter with the list of workouts
        final WorkoutAdapter adapter = new WorkoutAdapter(workouts);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);



        return recyclerView;
    }

  /*  public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public TextView name;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_workout, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar_workout);
            name = (TextView) itemView.findViewById(R.id.list_title_workout);


        }
    }*/

    /**
     * Adapter to display recycler view.
     */
    /*public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        private final String[] mWorkout;
        private final String[] mPlaceDesc;
        private final Drawable[] mWorkoutAvators;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mWorkout = resources.getStringArray(R.array.places);
            mPlaceDesc = resources.getStringArray(R.array.place_desc);
            TypedArray a = resources.obtainTypedArray(R.array.place_avator);
            mWorkoutAvators = new Drawable[a.length()];
            for (int i = 0; i < mWorkoutAvators.length; i++) {
                mWorkoutAvators[i] = a.getDrawable(i);
            }
            a.recycle();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.avator.setImageDrawable(mWorkoutAvators[position % mWorkoutAvators.length]);
            holder.name.setText(mWorkout[position % mWorkout.length]);

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }*/

}
