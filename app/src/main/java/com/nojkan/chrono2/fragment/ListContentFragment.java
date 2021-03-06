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
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.nojkan.chrono2.model.Niveau;
import com.nojkan.chrono2.model.NiveauxController;

/**
 * Provides UI for the view with List.
 */
public class ListContentFragment extends Fragment {
    private static final String TAG = "ListNiveaux";

    private static NiveauxController niveauxController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        niveauxController = NiveauxController.getInstance(null);
        String[] myNiveaux = niveauxController.getIdNiveauxList();

        Log.v(TAG, "idNiveau list :" + myNiveaux.toString());

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public TextView name;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            name = (TextView) itemView.findViewById(R.id.list_title);
            //description = (TextView) itemView.findViewById(R.id.list_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    Niveau nivClick = niveauxController.getNiveau(getAdapterPosition());
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    intent.putExtra(DetailActivity.EXTRA_NIVEAU, "Niveau " + nivClick.getIdNiveau());
                    Log.v(TAG,"Niveau Click"+ nivClick.getIdNiveau());
                    context.startActivity(intent);
                }
            });
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        //private static final int LENGTH = 13 ;

        private final String[] mNiveaux;
        //private final Drawable[] mPlaceAvators;

        public ContentAdapter(Context context) {
            //Resources resources = context.getResources();
            //mPlaces = resources.getStringArray(R.array.places);
            mNiveaux = niveauxController.getIdNiveauxList();
            /*TypedArray a = resources.obtainTypedArray(R.array.place_avator);
            mPlaceAvators = new Drawable[a.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceAvators[i] = a.getDrawable(i);
            }
            a.recycle();*/
        }
      @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            /*holder.avator.setImageDrawable(mPlaceAvators[position % mPlaceAvators.length]);*/
            holder.name.setText(mNiveaux[position % mNiveaux.length]);

        }

        @Override
        public int getItemCount() {
            return mNiveaux.length;
        }
    }

}
