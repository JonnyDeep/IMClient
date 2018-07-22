package sample;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame{
    private JFrame jf;

    LoginUI(int height,int width){
//        super(width,height);
        jf = new JFrame();
        jf.setSize(width,height);
        jf.setUndecorated(true);
        jf.setResizable(false);
        jf.setBackground(Color.green);
        jf.setLocationRelativeTo(this.getOwner());
//        jf.setLayout(null);
    }

    public void show()
    {
        jf.setVisible(true);
    }

//    @Override
//    public void dragWindow() {
//        super.dragWindow();
//        System.out.println("drag");
//    }

    public void dragTheWindow(){
        DragWindow dw = new DragWindow();
        jf.addMouseListener(dw);
        jf.addMouseMotionListener(dw);

    }

    public void setBackground(){
        jf.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("./src/main/java/sample/timg.jpg");
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource("./timg.jpg"));
        JLabel jLabel = new JLabel(imageIcon);
        JPanel jp = new JPanel();
        jp.setSize(430,181);
        jp.setBackground(Color.black);
        jp.setLayout(null);
        jp.setLocation(0,0);
        jLabel.setBounds(0,0,430,181);
        jp.add(jLabel);
        JPanel jp1 = new JPanel();
        jp1.setSize(430,150);
//        jp1.setBackground(Color.lightGray);
        jp1.setLocation(0,181);

        JPanel btnGroupPanel = new JPanel();
        btnGroupPanel.setSize(90,30);
//        btnGroupPanel.setLayout(null);
        JButton btnProxy = new JButton();
        btnProxy.setSize(30,30);

        btnProxy.setHorizontalAlignment(SwingConstants.LEFT);
        btnProxy.setVerticalAlignment(SwingConstants.TOP);
//  btnProxy.setIcon(new ImageIcon("./src/main/java/sample/proxy.PNG"));
        btnProxy.setContentAreaFilled(false);
        btnProxy.setBorderPainted(false);
        btnProxy.setBorder(null);

        btnProxy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cliect");
            }
        });
        JButton btnMin = new JButton(new ImageIcon("./src/main/java/sample/Min.PNG"));
        btnMin.setBorder(null);
        btnMin.setBorderPainted(false);
        btnMin.setContentAreaFilled(false);
        btnMin.setOpaque(false);
        btnMin.setSize(30,30);
        JButton btnClose = new JButton();
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setOpaque(false);
        btnClose.setSize(30,30);
//        btnGroupPanel.setBackground(Color.green);
//        btnGroupPanel.setLayout(new FlowLayout());
        btnGroupPanel.setLayout(null);
        btnProxy.setBounds(0,0,30,30);
        btnMin.setBounds(30,0,30,30);
        btnClose.setBounds(60,0,30,30);
        btnGroupPanel.add(btnProxy);
        btnGroupPanel.add(btnMin);
        btnGroupPanel.add(btnClose);
        jLabel.setLayout(null);
        btnGroupPanel.setBackground(null);
        btnGroupPanel.setOpaque(false);
        btnGroupPanel.setBounds(340,0,90,30);
        jLabel.add(btnGroupPanel);

//        JPanel jbottom = new JPanel(430,150);

        jf.add(jp);
        jf.add(jp1);
        jf.repaint();

        btnMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("min");
                setExtendedState(JFrame.ICONIFIED);
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("close");
                System.exit(0);
            }
        });
    }
    class DragWindow extends MouseAdapter{
        private Point MouseDownCompCoords = null;

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            MouseDownCompCoords = null;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            MouseDownCompCoords = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point currentCoords = e.getLocationOnScreen();
            jf.setLocation(currentCoords.x-MouseDownCompCoords.x,currentCoords.y-MouseDownCompCoords.y);
        }
    }
}
