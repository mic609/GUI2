package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SpecialPanel extends JPanel{

    int x, y;
    private boolean rysuj = false;
    MyShape shape = null;

    //************************************************************************************************************************//

    public SpecialPanel() {
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_C)
                {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            x = e.getX();
                            y = e.getY();
                            rysuj = true;
                            addShape(new Circle(x,y));
                        }
                    });
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            x = e.getX();
                            y = e.getY();
                            rysuj = true;
                            addShape(new Square(x,y));
                        }
                    });
                }
            }
        });
    }

    //************************************************************************************************************************//

    public boolean isRysuj() {
        return rysuj;
    }

    //************************************************************************************************************************//

    public void addShape(MyShape shape) {
        this.shape = shape;
        repaint();
    }

    //************************************************************************************************************************//

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            if(! isRysuj()) return;
            if(shape == null) return;
            g2d.setColor(Color.CYAN);
            shape.draw(g2d);
        } finally {
            g2d.dispose();
        }
    }
}
