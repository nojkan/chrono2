package com.nojkan.chrono2.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Serie;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import static com.example.android.materialdesigncodelab.R.color.dark_grey;

/**
 * Created by nojkan on 11/07/2017.
 */


public class SerieViewHolder extends ChildViewHolder {


    private TextView serieName;

    public SerieViewHolder(View itemView) {
        super(itemView);
        serieName = (TextView) itemView.findViewById(R.id.list_title_serie);
    }

    public void setSerieName(String name) {
        serieName.setText(name);
    }

    public void setSerieActive(Boolean isActive, int index){
        onBind(index);
    }

    public void onBind(int index) {

        itemView.setBackgroundColor(0xFF00FF00);
    }

}