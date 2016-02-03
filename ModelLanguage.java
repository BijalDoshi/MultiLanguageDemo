package com.tth.languagedemo.model;

/**
 * Created by jaimin on 16/10/15.
 */
public class ModelLanguage
{
    public ModelLanguage()
    {

    }
    public ModelLanguage(String name,String address)
    {
        this.name=name;
        this.address=address;


    }
    private String name="";
    private String address="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
