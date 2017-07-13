package com.nojkan.chrono2.model;

import android.content.Context;
import android.util.Log;

import org.codehaus.jackson.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by erwandiverrez on 22/07/2015.
 * Parse le json des niveaux
 */
public class NiveauxController {

    private static final String TAG = NiveauxController.class.getName();

    private JsonParser jp = null;
    private JSONArray niveauArray=null;
    private static NiveauxController instance;

    public static NiveauxController getInstance(Context context){
        if (context != null) {
            if (instance == null) {
                instance = new NiveauxController(context);

            }
        }
        return instance;
    }

    private NiveauxController(Context context) {

            String json = loadJSONFromAsset(context);
            try {

                JSONObject jsonObj = new JSONObject(json);
                niveauArray = jsonObj.getJSONArray("niveaux");
                Log.v(TAG,"NiveauArraySize =" + niveauArray.length());

            } catch (JSONException e) {
                e.printStackTrace();
            }


    }



    public String loadJSONFromAsset(Context context) {
         String json = null;
        try {

            InputStream is = context.getAssets().open("niveaux.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public JSONArray findAll() {
        return niveauArray;
    }

    public String[] getIdNiveauxList() {

        String[] idNviveauxList = new String[niveauArray.length()];

        for (int i = 0 ; i < niveauArray.length() ;i++){
            JSONObject jsonNiveau = null;
            try {
                jsonNiveau = niveauArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String idNiveau = "";
            try {
                idNiveau =  jsonNiveau.get("idNiveau").toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (idNiveau != null) {
                idNviveauxList[i]=idNiveau;
            }
        }


        return idNviveauxList;
    }

    public Niveau getNiveau(int index) {
        try {
            return Niveau.parse(niveauArray.getJSONObject(index));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
