package com.example.myguide.datapkg;

public class Recordssetget {
    private String Title;
    private String Date;
    private String Venue;
    private String Ammount;
    private String userid;
    private String details;
    private String year;
    private String maindate;

    public Recordssetget(String title, String date, String venue, String ammount, String userid, String details, String year, String maindate) {
        Title = title;
        Date = date;
        Venue = venue;
        Ammount = ammount;
        this.userid = userid;
        this.details = details;
        this.year = year;
        this.maindate = maindate;
    }

    public Recordssetget() {
    }




    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getAmmount() {
        return Ammount;
    }

    public void setAmmount(String ammount) {
        Ammount = ammount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMaindate() {
        return maindate;
    }

    public void setMaindate(String maindate) {
        this.maindate = maindate;
    }
}
