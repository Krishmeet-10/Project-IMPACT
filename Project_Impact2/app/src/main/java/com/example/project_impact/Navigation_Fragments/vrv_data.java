package com.example.project_impact.Navigation_Fragments;

public class vrv_data {
    String name;
    String image;
    String discp;

    public vrv_data(String name, String url, String discp) {
        this.name = name;
        this.image = url;
        this.discp = discp;
    }

    public  String getDiscp() { return discp;}
    public void setDiscp(String discp) { this.discp = discp;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
