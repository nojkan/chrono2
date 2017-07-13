package com.nojkan.chrono2.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

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
public class Workout extends ExpandableGroup<Serie> {
    private String idExo;
    private String nbSerie;
    private String reposBetweenSerie;
    private String reposAfterExo;
    private static List<Serie> items;

    public List<Serie> getItems() {
        return items;
    }

    public void setItems(List<Serie> items) {
        this.items = items;
    }



    /*public Workout() {
        super();
        this.idExo = "";
        this.nbSerie = "";
        this.reposBetweenSerie="";
        this.reposAfterExo="";
    }*/

    public Workout(String idExo, String nbSerie,String reposBetweenSerie,String reposAfterExo) {
        super(idExo, items);
        this.idExo = idExo;
        this.nbSerie = nbSerie;
        this.reposBetweenSerie=reposBetweenSerie;
        this.reposAfterExo=reposAfterExo;
        this.items=new ArrayList<Serie>();
        for (int i=1; i < Integer.parseInt(nbSerie) ;i++ ){

            items.add(new Serie(nbSerie));

        }
    }



   public Workout(String idExo){
        super(idExo, items);
        this.idExo = idExo;
    }


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
            return new Workout(
                    obj.getString("idExo"),
                    obj.getString("nbSerie"),
                    obj.getString("reposBetweenSerie"),
                    obj.getString("reposAfterExo")
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}