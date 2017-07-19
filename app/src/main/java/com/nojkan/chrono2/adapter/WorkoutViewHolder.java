package com.nojkan.chrono2.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Workout;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

/**
 * Created by nojkan on 11/07/2017.
 */



public class WorkoutViewHolder extends GroupViewHolder {

        private TextView workoutTitle;
        private ImageView workoutAvatar;
        private Context mContext;

        /*public WorkoutViewHolder(View itemView) {

            super(itemView);
            workoutTitle = (TextView) itemView.findViewById(R.id.list_title_workout);
            //workoutAvatar = (ImageView) itemView.findViewById(R.id.list_avatar_workout);


        }*/

       /* public void setWorkoutTitle(ExpandableGroup group) {
            workoutTitle.setText(group.getTitle());
        }*/
        //TODO set dynamix Image of workout
        /*public void setWorkoutAvatar(ExpandableGroup group){

            workoutAvatar.setImageResource();
        }*/


        public WorkoutViewHolder(View itemView) {
            super(itemView);
            workoutTitle = (TextView) itemView.findViewById(R.id.list_title_workout);
            //arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
            //icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
        }

        public void setWorkoutTitle(ExpandableGroup workout) {

                workoutTitle.setText(workout.getTitle());
                //icon.setBackgroundResource(((Workout) workout).getIconResId());

        }



}

