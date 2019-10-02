package com.example.dell.introscreen;

public class ScreenItem {
    String Title,Desciption;
    int ScreenImg;

    public ScreenItem(String title, String desciption, int screenImg) {
        Title = title;
        Desciption = desciption;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesciption() {
        return Desciption;
    }

    public void setDesciption(String desciption) {
        Desciption = desciption;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
