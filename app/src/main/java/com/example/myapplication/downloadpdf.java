package com.example.myapplication;

public class downloadpdf {

    String name;
    String url;
    public downloadpdf(){

    }
    public  downloadpdf(String name,String url){
        this.name=name;
        this.url=url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
