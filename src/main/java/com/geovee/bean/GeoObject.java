package com.geovee.bean;

import java.awt.*;

public abstract class GeoObject {
    protected float x, y, z;
    protected  Color color;
    protected int width;
    protected int height;
    protected  float velX, velY;
    protected ID id;

    public GeoObject(float x , float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;

        color = Color.WHITE;
    }

    public abstract  void update();
    public  abstract  void render(Graphics g);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Color getColor() {
        return color;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public ID getId() {
        return id;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
