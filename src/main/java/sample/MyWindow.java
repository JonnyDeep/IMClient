package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame {
    private JFrame jFrame;
    private int PosX;
    private int PoxY;

    MyWindow(int width,int height)
    {
        jFrame = new JFrame();
        jFrame.setSize(width,height);
    }

    public void dragWindow()
    {
        DragWindow dw = new DragWindow(jFrame);
        jFrame.addMouseListener(dw);
        jFrame.addMouseMotionListener(dw);
    }


}
