package com.geovee;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.geovee.bean.Cube;
import com.geovee.bean.GeoObject;
import com.geovee.bean.ID;
import com.geovee.input.KeyInput;
import com.geovee.input.MouseInput;
import com.geovee.view.*;
import com.geovee.view.Window;

public class Geo extends Canvas implements Runnable{
    public static int WIDTH = 800, HEGIHT = 600;
    private String title = "GeoVee";

    private Thread thread;
    private boolean isRunning = false;

    private Handler handler;
    private ObjectView objectView;
    private CreateView createView;
    private KeyInput input;
    private MouseInput mouse;

    private GeoObject currentObject;

    public enum STATE{
        Create,
        Edit
    };

    public STATE currentState = STATE.Create;

    public Geo(){
        new Window(WIDTH,HEGIHT,title,this);
        start();
        init();
    }

 public void init(){
     handler = new Handler();
     input = new KeyInput();
     mouse = new MouseInput(handler);
     createView = new CreateView(handler, this);
     objectView = new ObjectView(handler, this);

     this.addKeyListener(input);
     this.addMouseListener(createView);
     this.addMouseListener(mouse);
 }


    public static void main(String[] args){
        new Geo();
    }

    private synchronized void start()
    {
        if(isRunning) return;

        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    private synchronized void end()
    {
        if(!isRunning) return;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isRunning = false;
    }

    @Override
    public void run() {

        this.requestFocus();

        long lastTime = System.nanoTime();
        double amountofticks = 60.0;
        double ns = 1000000000 / amountofticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int  frames = 0;

        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            while(delta >= 1){
                update();
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer+= 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void update(){
        handler.update();
        objectView.update();
        createView.update();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, WIDTH,HEGIHT);

        // Render Objects below

        handler.render(g);

        switch (currentState){
        case Create:
            this.addMouseListener(createView);
            this.removeMouseListener(objectView);
        createView.render(g);
        break;
        case Edit:
            this.removeMouseListener(createView);
            this.addMouseListener(objectView);
            objectView.render(g);
        break;}


        bs.show();
        g.dispose();
    }


    private void stop() {
    }

    public GeoObject getCurrentObject() {
        return currentObject;
    }

    public void setCurrentObject(GeoObject currentObject) {
        this.currentObject = currentObject;
    }
}
