package com.company;

import java.awt.Graphics2D;

public class Circle extends MyShape {

    private final int w=40,
            h=40;

    //************************************************************************************************************************//

    public Circle(int x, int y) {
        super(x, y);
    }

    //************************************************************************************************************************//

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillOval(x-Math.round(w/2), y-Math.round(h/2), w, h);
    }

}
