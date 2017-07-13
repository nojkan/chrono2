package com.nojkan.chrono2.adapter;

import android.view.View;
import android.view.ViewGroup;


import android.view.LayoutInflater;
import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Serie;
import com.nojkan.chrono2.model.Workout;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutAdapter extends ExpandableRecyclerViewAdapter<WorkoutViewHolder, SerieViewHolder> {

    public WorkoutAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public WorkoutViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
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
        final Serie serie = ((Workout) group).getItems().get(childIndex);
        holder.setSerieName(serie.getId());
    }

    @Override
    public void onBindGroupViewHolder(WorkoutViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setWorkoutTitle(group);
    }
}