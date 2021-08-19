package com.geovee.bean;

import com.geovee.input.KeyInput;

import java.awt.*;

public class Cube extends GeoObject{

    private KeyInput input;

    public Cube(float x, float y,int width, int height, ID id, KeyInput input) {
        super(x, y, id);
        this.input = input;
        this.width = width;
        this.height =height;
    }

    public Cube(float x, float y,int width, int height, ID id) {
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
        g.fillRect((int) x, (int) y, width, height);

    }
}
