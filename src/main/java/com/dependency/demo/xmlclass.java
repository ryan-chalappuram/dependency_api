package com.dependency.demo;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class xmlclass{

    public static String lang;
    public static String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



}