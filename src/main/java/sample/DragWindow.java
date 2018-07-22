package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DragWindow extends MouseAdapter
{
    JFrame jFrame= null;
    Point mouseDownCoords=null;
    DragWindow(JFrame jFrame)
    {
        this.jFrame=jFrame;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        mouseDownCoords = null;
        System.out.println("release");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        mouseDownCoords = e.getPoint();
        System.out.println(mouseDownCoords.x);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Point currentCoords = e.getLocationOnScreen();
        jFrame.setLocation(currentCoords.x - mouseDownCoords.x, currentCoords.y - mouseDownCoords.y);
        System.out.println(currentCoords.x);
    }
}
