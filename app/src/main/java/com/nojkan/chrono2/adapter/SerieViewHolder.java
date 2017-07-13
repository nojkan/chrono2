package com.nojkan.chrono2.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by nojkan on 11/07/2017.
 */


public class SerieViewHolder extends ChildViewHolder {


    private TextView childTextView;

    public SerieViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_title);
    }

    public void setSerieName(String name) {
        childTextView.setText(name);
    }


}