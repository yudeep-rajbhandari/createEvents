package com.hornet.nepalidateconverter;

/**
 * Created by USER on 10/7/2017.
 */

public class notesgetter {
    private Integer ID;String date,Person,Place,Task;

    public notesgetter(Integer ID,String date, String person, String place, String task) {
            this.ID=ID;
        this.date = date;
        Person = person;
        Place = place;
        Task = task;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getPerson() {
        return Person;
    }

    public void setPerson(String person) {
        Person = person;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
