package com.nojkan.chrono2.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import android.view.LayoutInflater;
import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Serie;
import com.nojkan.chrono2.model.Workout;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutAdapter extends ExpandableRecyclerViewAdapter<WorkoutViewHolder, SerieViewHolder> {


    private static final String TAG = "WorkoutAdapter";

    public WorkoutAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public WorkoutViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public SerieViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serie, parent, false);
        return new SerieViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SerieViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex) {
        Log.v(TAG,"onBindCildViewHolder");
       Log.v(TAG, "group" + group.getItems().toString());
       //this.getGroups().get(childIndex).getItems();
        Log.v(TAG,"flatposition : "+ flatPosition);
        Log.v(TAG,"clildindex : "+ childIndex);
        Serie serie = ((Workout) group).getItems().get(childIndex);
        Log.v(TAG,"serieId "+serie.getId());
        holder.setSerieName(""+(serie.getId()));
    }

    @Override
    public void onBindGroupViewHolder(WorkoutViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setWorkoutTitle(group);
        //holder.serWorkoutImage(group);
    }
}