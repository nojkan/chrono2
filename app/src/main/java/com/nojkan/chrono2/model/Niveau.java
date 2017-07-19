package com.nojkan.chrono2.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by erwandiverrez on 22/07/2015.
 * Defines Niveau Object, containing idNiveau and arrayList of Exo object
 */
public class Niveau {
    private static final String TAG = "Niveau";

    private String idNiveau;
    private ArrayList<Workout> exoArrayList;


    public Niveau(String idNiveau, ArrayList exoArrayList) {
        super();
        this.idNiveau = idNiveau;
        this.exoArrayList = exoArrayList;
    }


    public String getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(String idNiveau) {
        this.idNiveau = idNiveau;
    }

    public ArrayList<Workout> getExoArrayList() {
        return exoArrayList;
    }

    public void setExoArrayList(ArrayList<Workout> exoArrayList) {
        this.exoArrayList = exoArrayList;
    }

    @Override
    public String toString() {
        return "Niveau{" +
                "idNiveau='" + idNiveau + '\'' +
                ", exoArrayList=" + exoArrayList +
                '}';
    }

    public static Niveau parse(JSONObject obj) {
        try {
            ArrayList<Workout> parsedExos = new ArrayList<>();

            JSONArray jsonExos = obj.getJSONArray("Exos");
            for(int i = 0; i < jsonExos.length(); i++) {
                Log.v(TAG,"index i : "+ i);
                Log.v(TAG,"json exo length" + jsonExos.length());
                Log.v(TAG,"add id exo : " + Workout.parse(jsonExos.getJSONObject(i)).getIdExo());
                Log.v(TAG,"with #niveaux : " + Workout.parse(jsonExos.getJSONObject(i)).getNbSerie());
                parsedExos.add(Workout.parse(jsonExos.getJSONObject(i)));
            }

            return new Niveau(
                    obj.getString("idNiveau"),
                    parsedExos
            );
        } catch (JSONException e) {
            return null;
        }
    }
}
