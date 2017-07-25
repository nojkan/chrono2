package com.nojkan.chrono2.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import android.view.LayoutInflater;
import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Serie;
import com.nojkan.chrono2.model.Workout;

import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;
import java.util.logging.Logger;


/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutAdapter extends CheckableChildRecyclerViewAdapter<WorkoutViewHolder, SerieViewHolder> {

    private Context mContext;
    private static final String TAG = "WorkoutAdapter";


    public WorkoutAdapter(Context context, List<? extends CheckedExpandableGroup> groups) {
        super(groups);
        mContext = context;


    }


    //Goup

   @Override
    public WorkoutViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view, mContext);
    }


    @Override
    public void onBindGroupViewHolder(WorkoutViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setWorkoutTitle(group);
        holder.setBackgroundImage(group);


    }

    //Child

    @Override
    public SerieViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_serie, parent, false);
        return new SerieViewHolder(view);
    }

   /* @Override
    public SerieViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serie, parent, false);

        return new SerieViewHolder(view);
    }*/

    @Override
    public void onBindCheckChildViewHolder(SerieViewHolder holder, int flatPosition, CheckedExpandableGroup group,
                                      int childIndex) {


        final Serie serie = (Serie) group.getItems().get(childIndex);
        //Log.v(TAG,"serieId "+serie.getId());
        holder.setSerieName(""+(serie.getId()));
        holder.setSerieActive(true, 0);


    }


}