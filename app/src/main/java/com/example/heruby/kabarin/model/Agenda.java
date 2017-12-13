package com.example.heruby.kabarin.model;

/**
 * Created by Andri Ginting on 12/13/2017.
 */

public class Agenda {


    private String title, shortdesc;
    private String date;


    public Agenda(String title, String shortdesc, String date) {

        this.title = title;
        this.shortdesc = shortdesc;
        this.date = date;

    }



    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getDate(){
        return date;
    }


}
