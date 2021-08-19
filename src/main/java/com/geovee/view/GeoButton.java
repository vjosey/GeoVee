package com.geovee.view;

import javax.swing.*;
import java.awt.*;

public class GeoButton{
    private int width, height;
    private int x, y;
    private String title;
    private  Color color;



    public GeoButton(String title, int width, int height, Color color)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        this.color = color;

    }


    public void  render(Graphics g){
        Font font = new Font("aria", 1,18);

        g.setFont(font);
        g.setColor(color);
        g.drawString(title, x + 30 ,y + 50);

        g.setColor(color);
        g.drawRect(x,y, width, height);
    }

    public void position(int x, int y){
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
