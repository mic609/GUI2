package com.company;

import java.awt.Graphics2D;

public class Square extends MyShape {

    private final int w=40,
            h=40;

    //************************************************************************************************************************//

    public Square(int x, int y) {
        super(x, y);
    }

    //************************************************************************************************************************//

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x, y, w, h);
    }

}
