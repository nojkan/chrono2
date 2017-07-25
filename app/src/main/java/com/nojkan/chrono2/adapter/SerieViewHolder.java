package com.nojkan.chrono2.adapter;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Serie;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

import static com.example.android.materialdesigncodelab.R.color.dark_grey;

/**
 * Created by nojkan on 11/07/2017.
 */


public class SerieViewHolder extends CheckableChildViewHolder {


    private TextView serieName;
    private CheckedTextView childCheckedTextView;

    public SerieViewHolder(View itemView) {
        super(itemView);
        childCheckedTextView =
                (CheckedTextView) itemView.findViewById(R.id.list_title_serie);

    }

    public void setSerieName(String name) {
        childCheckedTextView.setText(name);
    }

    public void setSerieActive(Boolean isActive, int index){
        onBind(index);
    }

    public void onBind(int index) {

        childCheckedTextView.setBackgroundColor(0xFF00FF00);
    }

    @Override
    public Checkable getCheckable() {
        return childCheckedTextView;
    }

}