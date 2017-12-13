package com.example.heruby.kabarin.model;

/**
 * Created by Andri Ginting on 12/13/2017.
 */

public class Agenda {

    private int id;
    private String title, shortdesc;
    private String date;
    private int image;

    public Agenda(int id, String title, String shortdesc, String date, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.date = date;
        this.image = image;
    }

    public int getId() {
        return id;
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

    public int getImage() {
        return image;
    }
}
