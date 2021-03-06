package com.company;

import java.awt.Graphics2D;

public abstract class MyShape {

    protected int x, y;

    //************************************************************************************************************************//

    public int getX() {
        return x;
    }

    //************************************************************************************************************************//

    public void setX(int x) {
        this.x = x;
    }

    //************************************************************************************************************************//

    public int getY() {
        return y;
    }

    //************************************************************************************************************************//

    public void setY(int y) {
        this.y = y;
    }

    //************************************************************************************************************************//

    public MyShape(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public MyShape() {
        this(2,2);
    }

    public abstract void draw(Graphics2D g2d);

}

