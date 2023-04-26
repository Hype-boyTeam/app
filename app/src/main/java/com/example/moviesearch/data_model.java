package com.example.moviesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data_model {



    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;



    @SerializedName("text")
    @Expose
    private String text;



    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }






}
