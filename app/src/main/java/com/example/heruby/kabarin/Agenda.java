package com.example.akbarramadhan.kabarin_recycleview;

import java.util.Calendar;

/**
 * Created by Akbar Ramadhan on 12/12/2017.
 */

public class Agenda {

    private int id;
    private String title, shortdesc;
    private Calendar date;
    private int image;

    public Agenda(int id, String title, String shortdesc, Calendar date, int image) {
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

    public Calendar getDate(){
        return date;
    }

    public int getImage() {
        return image;
    }
}
