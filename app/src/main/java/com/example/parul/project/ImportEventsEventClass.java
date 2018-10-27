package com.example.parul.project;

public class ImportEventsEventClass {

    private String name, description, date, venue, timings;
    private int event_img;

    public ImportEventsEventClass(String name, String description, String date, String venue, String timings,
                                  int event_img){
        this.name = name;
        this.description = description;
        this.date = date;
        this.venue = venue;
        this.timings = timings;
        this.event_img = event_img;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getVenue(){
        return venue;
    }

    public String getTimings() {
        return timings;
    }

    public int getEvent_img() {
        return event_img;
    }
}
