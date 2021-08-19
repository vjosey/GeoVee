package com.geovee.view;

import javax.swing.*;
import java.awt.*;
import com.geovee.Geo;

public class Window {
    public Window( int width, int height , String title, Geo geo)
    {

        JPanel rightPanel = new JPanel();
        int rightPanelWidth = width /5;
        rightPanel.setBackground(Color.GRAY);
        rightPanel.setBounds(width - rightPanelWidth,0, rightPanelWidth, height);
        rightPanel.setLayout(new BorderLayout());

        JButton box = new JButton();
        box.setText("Box");
        box.setBackground(Color.LIGHT_GRAY);
        box.setBounds(0,100, rightPanelWidth, 100);
        box.setHorizontalAlignment(JButton.CENTER);


        JButton square = new JButton();
        square.setText("square");
        square.setBackground(Color.LIGHT_GRAY);
        square.setBounds(0,0, rightPanelWidth, 100);
        square.setHorizontalAlignment(JButton.CENTER);



        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(geo);

        frame.setVisible(true);
    }
}
