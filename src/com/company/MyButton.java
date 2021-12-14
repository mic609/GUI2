package com.company;

import javax.swing.*;

public class MyButton extends JButton {

    int xLocation;
    int yLocation;

    //************************************************************************************************************************//

    MyButton(String title){
        super.setText(title);
    }

    //************************************************************************************************************************//

    public void setXYLocation(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
}
