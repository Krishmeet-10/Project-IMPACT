package com.example.project_impact.Navigation_Fragments;

public class vrv_data {
    String name;
    String image;

    public vrv_data(String name, String url) {
        this.name = name;
        this.image = url;
    }

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
