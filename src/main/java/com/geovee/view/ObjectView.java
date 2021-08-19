package com.geovee.view;

import com.geovee.Geo;
import com.geovee.bean.GeoObject;
import com.geovee.bean.ID;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObjectView extends MouseAdapter {

    private final Handler handler;
    private final Geo geo;
    private  GeoObject currentObject;
    private GeoButton red = new GeoButton("Red", 120, 80, Color.red);
    private GeoButton yellow = new GeoButton("Yellow", 120, 80, Color.yellow);
    private GeoButton blue = new GeoButton("Blue", 120, 80, Color.blue);
    private GeoButton exit = new GeoButton("Exit", 120, 80, Color.white);

    public ObjectView(Handler handler, Geo geo){
        this.handler = handler;
        this.geo = geo;


    }

    public void mousePressed(MouseEvent e){

        int mx = e.getX();
        int my = e.getY();

        if(mouseOverButton(mx,my, red) && currentObject != null)
        {
            red.setColor(Color.PINK);
            currentObject.setColor(Color.RED);
        }
        if(mouseOverButton(mx,my, yellow) && currentObject != null)
        {
            yellow.setColor(Color.ORANGE);
            currentObject.setColor(Color.YELLOW);
        }

        if(mouseOverButton(mx,my, blue) && currentObject != null)
        {
            blue.setColor(Color.CYAN);
            currentObject.setColor(Color.BLUE);
        }

        if(mouseOverButton(mx,my, exit) && currentObject != null)
        {
            exit.setColor(Color.CYAN);
            geo.currentState = Geo.STATE.Create;
        }

    }


    public void mouseReleased(MouseEvent e){
        red.setColor(Color.RED);
        yellow.setColor(Color.YELLOW);
        blue.setColor(Color.BLUE);
        exit.setColor(Color.white);
    }

    private boolean mouseOverButton(int mx, int my, GeoButton button)
    {
        return mouseOver(mx,my, button.getX(), button.getY(),button.getWidth(), button.getHeight());

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }

    public void update() {

        currentObject = geo.getCurrentObject();
    }

    public void render(Graphics g) {
        red.position(650, 30);
        red.render(g);

        yellow.position(650, 130);
        yellow.render(g);

        blue.position(650, 230);
        blue.render(g);

        exit.position(650, 330);
        exit.render(g);
    }

}
