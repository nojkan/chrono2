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

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutAdapter extends ExpandableRecyclerViewAdapter<WorkoutViewHolder, SerieViewHolder> {

    private Context mContext;
    private static final String TAG = "WorkoutAdapter";


    public WorkoutAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(groups);
        mContext = context;


    }

    @Override
    public WorkoutViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view, mContext);
    }

    @Override
    public SerieViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serie, parent, false);

        return new SerieViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SerieViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex) {


        Serie serie = ((Workout) group).getItems().get(childIndex);
        //Log.v(TAG,"serieId "+serie.getId());
        holder.setSerieName(""+(serie.getId()));
        holder.setSerieActive(true, 0);


    }

    @Override
    public void onBindGroupViewHolder(WorkoutViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setWorkoutTitle(group);
        holder.setBackgroundImage(group);


    }
}