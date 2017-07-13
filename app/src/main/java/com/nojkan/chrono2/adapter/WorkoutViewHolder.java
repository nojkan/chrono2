package com.nojkan.chrono2.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutViewHolder extends GroupViewHolder {

        private TextView genreTitle;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            genreTitle = (TextView) itemView.findViewById(R.id.list_title);
        }

        public void setWorkoutTitle(ExpandableGroup group) {
            genreTitle.setText(group.getTitle());
        }
}

