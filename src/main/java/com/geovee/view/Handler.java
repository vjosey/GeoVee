package com.geovee.view;

import com.geovee.bean.GeoObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GeoObject> objects = new LinkedList<>();

    public void update(){
        for( GeoObject object : objects){
            object.update();
        }
    }

    public void render(Graphics g){
        for( GeoObject object : objects){
            object.render(g);
        }
    }

    public void addObject(GeoObject object){
        objects.add(object);
    }

    public void remove(GeoObject object)
    {
        objects.remove(object);
    }

}
