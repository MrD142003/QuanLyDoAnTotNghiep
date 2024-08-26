package com.example.myprojects;

public class DataClass {
    private String time, title;
    private int image;

    public DataClass(String title, String time, int image) {
        this.title = title;
        this.time = time;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
