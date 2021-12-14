package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Window extends JFrame{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Window ramka = new Window();
                ramka.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }
    public Window(){
        this("Kółka, kwadraty i uciekające przyciski");
    }

    //************************************************************************************************************************//

    public Window(String title){

        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,480,480);
        panel.setLayout(null);
        setContentPane(panel);

        MyButton firstButton = new MyButton("Przejdź do kanwy");
        firstButton.setBounds(300,300,150,40);
        firstButton.setXYLocation(250,250);
        panel.add(firstButton);

        firstButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);

                Random rand = new Random();
                int warunek1 = rand.nextInt(4);

                int xp;
                int yp;
                int dodaj = 30;

                //------//
                //Losowe zmienianie pozycji przycisku. Dodane warunki aby przycisk nie wyleciał po za okno
                switch(warunek1){
                    case 0: {
                        xp = firstButton.getX()+dodaj;
                        yp = firstButton.getY()+dodaj;
                        if(xp >= panel.getHeight()-firstButton.getWidth()) xp = firstButton.getX()-dodaj;
                        if(yp >= panel.getHeight()-firstButton.getHeight()) yp = firstButton.getY()-dodaj;
                        break;
                    }
                    case 1:
                    {
                        xp = firstButton.getX()-dodaj;
                        yp = firstButton.getY()+dodaj;
                        if(xp < 0) xp = firstButton.getX()+dodaj;
                        if(yp >= panel.getHeight()-firstButton.getHeight()) yp = firstButton.getY()-dodaj;
                        break;
                    }
                    case 2:
                    {
                        xp = firstButton.getX()+dodaj;
                        yp = firstButton.getY()-dodaj;
                        if(xp >= panel.getHeight()-firstButton.getWidth()) xp = firstButton.getX()-dodaj;
                        if(yp < 0) yp = firstButton.getY()+dodaj;
                        break;
                    }
                    case 3:
                    {
                        xp = firstButton.getX()-dodaj;
                        yp = firstButton.getY()-dodaj;
                        if(xp < 0) xp = firstButton.getX()+dodaj;
                        if(yp < 0) yp = firstButton.getY()+dodaj;
                        break;
                    }
                    default:
                    {
                        xp = firstButton.getX();
                        yp = firstButton.getY();
                        break;
                    }
                }

                //********************//
                //Wyświetlanie przycisku ze strefą bezpieczną. Na przycisk można najechać w odpowiednim obszarze
                //z lewej strony
                if(e.getX() != 0)
                    firstButton.setLocation(xp,yp);
                else if(((e.getY() >= firstButton.getHeight()/3) && (e.getY() <= firstButton.getHeight()*2/3))){
                    //nie zmieniaj położenia
                }
                else
                    firstButton.setLocation(xp,yp);
            }
        });


        // Przejście do kanwy po naciśnięciu przycisku
        firstButton.addActionListener(e -> {

            panel.remove(firstButton);
            remove(panel);

            SpecialPanel kanwa = new SpecialPanel();
            kanwa.setFocusable(true);
            kanwa.setBounds(50,30,400,400);
            kanwa.setBorder(new LineBorder(new Color(232, 0, 0), 4, true));
            kanwa.setBackground(Color.LIGHT_GRAY);

            add(kanwa);
            repaint();
            revalidate();
        });

    }
}
