package com.geovee.bean;

import com.geovee.input.KeyInput;

import java.awt.*;

public class Sphere extends GeoObject{


    public Sphere(float x, float y,int width, int height, ID id) {
        super(x, y, id);

        this.width = width;
        this.height =height;
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, width, height);

    }
}
