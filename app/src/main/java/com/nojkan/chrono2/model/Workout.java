package com.nojkan.chrono2.model;

import android.util.Log;

//import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablecheckrecyclerview.models.SingleCheckExpandableGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nojkan on 11/07/2017.
 */

/**
 * Created by erwandiverrez on 22/07/2015.
 */
public class Workout extends  SingleCheckExpandableGroup {
    private String idExo;
    private String nbSerie;
    private String reposBetweenSerie;
    private String reposAfterExo;
    private List<Serie> items;
    private int iconResId;


    public Workout(String idExo, String nbSerie,String reposBetweenSerie,String reposAfterExo,List<Serie> items) {
        super(idExo,items);
        this.idExo = idExo;
        this.nbSerie = nbSerie;
        this.reposBetweenSerie=reposBetweenSerie;
        this.reposAfterExo=reposAfterExo;
        this.items=items;

    }




   /* public List<Serie> getItems() {
        Log.v("items" , this.items.toString());
        return this.items;
    }*/

    public void setItems(List<Serie> items) {
        this.items = items;
    }



  /*public Workout(String idExo){
        super(idExo, items);
        this.idExo = idExo;
    }*/


    public String getIdExo() {
        return idExo;
    }

    public void setIdExo(String idExo) {
        this.idExo = idExo;
    }

    public String getNbSerie() {
        return nbSerie;
    }

    public void setNbserie(String nbRepet) {
        this.nbSerie = nbRepet;
    }

    public String getReposBetweenSerie() {
        return reposBetweenSerie;
    }

    public void setReposBetweenSerie(String reposBetweenSerie) {
        this.reposBetweenSerie = reposBetweenSerie;
    }

    public String getReposAfterExo() {
        return reposAfterExo;
    }

    public void setReposAfterExo(String reposAfterExo) {
        this.reposAfterExo = reposAfterExo;
    }

    public static Workout parse(JSONObject obj) {

        try {
            int iNbSerie = Integer.parseInt(obj.getString("nbSerie"));
            ArrayList<Serie> listSerie = new ArrayList<Serie>();


            for (int i=0; i < iNbSerie;i++ ){

                listSerie.add(new Serie(i));

        }


            return new Workout(
                    obj.getString("idExo"),
                    obj.getString("nbSerie"),
                    obj.getString("reposBetweenSerie"),
                    obj.getString("reposAfterExo"),
                    listSerie
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}
