package com.geovee.input;

import com.geovee.bean.Cube;
import com.geovee.bean.GeoObject;
import com.geovee.bean.ID;
import com.geovee.view.Handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private Handler handler;
    private ID id = ID.Cube;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }



    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
    }
}