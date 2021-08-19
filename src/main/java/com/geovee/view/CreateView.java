package com.geovee.view;

import com.geovee.Geo;
import com.geovee.bean.Cube;
import com.geovee.bean.GeoObject;
import com.geovee.bean.ID;
import com.geovee.bean.Sphere;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateView extends MouseAdapter {

    private final Geo geo;
    private ID id = ID.Cube;
    private boolean canAdd = false;
    private Handler handler;
    private GeoButton box = new GeoButton("Box", 120, 80, Color.white);
    private GeoButton square = new GeoButton("Square", 120, 80, Color.white);
    private GeoButton circle = new GeoButton("Circle", 120, 80, Color.white);

    public CreateView(Handler handler, Geo geo){
        this.handler = handler;
        this.geo = geo;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();


        if(mouseOverButton(mx,my, box))
        {
            box.setColor(Color.GREEN);

            id = ID.Cube;
            canAdd = true;
        }

        if(mouseOverButton(mx,my, square))
        {

            square.setColor(Color.GREEN);
            id = ID.Sphere;
            canAdd = true;
        }

        if(mouseOverButton(mx,my, circle))
        {

            circle.setColor(Color.GREEN);
            id = ID.Tetrahedron;
            canAdd = true;
        }



        for(GeoObject object : handler.objects)
        {
            if(mouseOverObject(mx,my, object))
            {
                object.setColor(Color.GREEN);
                geo.currentState = Geo.STATE.Edit;
                geo.setCurrentObject(object);

                canAdd = false;
            }
        }

if(canAdd && !mouseOverButton(mx,my, box) && !mouseOverButton(mx,my, square) && !mouseOverButton(mx,my, circle)){
        switch (id){
            case Cube:
                handler.addObject(new Cube(mx, my, 32, 32,id));
                break;
            case Sphere:
                handler.addObject(new Sphere(mx, my, 32, 32,id));
                break;
            case Tetrahedron:
                handler.addObject(new Cube(mx, my, 32, 32,id));
                break;
            case Cylinder:
                handler.addObject(new Cube(mx, my, 32, 32,id));
                break;
            default:
                break;
        }
        canAdd= false;
}
    }
    public void mouseReleased(MouseEvent e){

        box.setColor(Color.WHITE);
        square.setColor(Color.WHITE);
        circle.setColor(Color.WHITE);
    }
    public void update(){}
    public void render(Graphics g){
        box.position(650, 30);
        box.render(g);

        square.position(650, 130);
        square.render(g);

        circle.position(650, 230);
        circle.render(g);

    }
  private boolean mouseOverButton(int mx, int my, GeoButton button)
  {
      return mouseOver(mx,my, button.getX(), button.getY(),button.getWidth(), button.getHeight());

  }

    private boolean mouseOverObject(int mx, int my, GeoObject object)
    {
        return mouseOver(mx,my, (int)object.getX(),(int) object.getY(),object.getWidth(), object.getHeight());

    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }
}
