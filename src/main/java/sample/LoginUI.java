package sample;

import com.sun.deploy.panel.JavaPanel;
import com.sun.javaws.JAuthenticator;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import sun.plugin.dom.core.CoreConstants;

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
//        jp.setBackground(Color.black);
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

        JPanel jbottom = new JPanel();
        jbottom.setPreferredSize(new Dimension(430,100));
        jbottom.setBackground(Color.black);

        JPanel jImagePanel = new JPanel();
        jImagePanel.setPreferredSize(new Dimension(120,100));
//        jImagePanel.setBackground(Color.green);
        JLabel jHead = new JLabel(new ImageIcon("./src/main/java/sample/head.jpg"));
        jHead.setPreferredSize(new Dimension(80, 80));
        jHead.setBackground(Color.BLACK);
        jImagePanel.setLayout(null);
        jHead.setBounds(30,15,80,80);
        jImagePanel.add(jHead);

        JPanel jNamePwdPanel = new JPanel();
        jNamePwdPanel.setPreferredSize(new Dimension(190,100));
//        jNamePwdPanel.setBackground(Color.BLUE);

        JEditorPane jUserName = new JEditorPane();
        jUserName.setPreferredSize(new Dimension(190,30));
//        jUserName.setSize(190,30);

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setPreferredSize(new Dimension(190,30));
        jPasswordField.setBorder(null);

        JCheckBox jRememberPwd  = new JCheckBox("记住密码");
        jRememberPwd.setOpaque(false);
        jRememberPwd.setContentAreaFilled(false);
        jRememberPwd.setBackground(Color.white);
        jRememberPwd.setFont(new Font("宋体",Font.PLAIN,13));
        jRememberPwd.setForeground(Color.BLACK);
        JCheckBox jAutoLogin = new JCheckBox("自动登入");
        jAutoLogin.setFont(new Font("宋体",Font.PLAIN,13));
        jAutoLogin.setForeground(Color.BLACK);
//        ButtonGroup bg = new ButtonGroup();

        jNamePwdPanel.setLayout(null);
        jUserName.setBounds(0,15,190,30);
        jPasswordField.setBounds(0,46,190,30);
        jRememberPwd.setBounds(0,80,100,16);
        jAutoLogin.setBounds(100,80,100,16);
        jNamePwdPanel.add(jUserName);
        jNamePwdPanel.add(jPasswordField);
        jNamePwdPanel.add(jRememberPwd);
        jNamePwdPanel.add(jAutoLogin);

        JPanel jLink = new JPanel();
        //change the borderlayout content area
        jLink.setPreferredSize(new Dimension(120,100));
//        jLink.setBackground(Color.pink);

        JLabel jFindPwd = new JLabel("找回密码");
        jFindPwd.setFont(new Font("黑体",Font.PLAIN,15));
        jFindPwd.setForeground(Color.BLUE);

        JLabel jRegist = new JLabel("注册账号");
        jRegist.setFont(new Font("黑体",Font.PLAIN,15));
        jRegist.setForeground(Color.BLUE);
        jLink.setLayout(null);
        jFindPwd.setBounds(10,25,100,20);
        jRegist.setBounds(10,55,100,20);
        jLink.add(jFindPwd);
        jLink.add(jRegist);

        JPanel jSubmit = new JPanel();
        jSubmit.setPreferredSize(new Dimension(430,81));
//        jSubmit.setBackground(Color.ORANGE);

        JButton jLoginBtn = new JButton("登    录");
        jLoginBtn.setFont(new Font("黑体",Font.PLAIN,16));
        jLoginBtn.setPreferredSize(new Dimension(190,40));
        jLoginBtn.setBackground(Color.BLUE);
        jLoginBtn.setForeground(Color.WHITE);

        jSubmit.add(jLoginBtn);

        jbottom.setLayout(new BorderLayout());

        jbottom.add("West",jImagePanel);
        jbottom.add("Center",jNamePwdPanel);
        jbottom.add("East",jLink);

        jp1.setLayout(null);
        jbottom.setBounds(0,0,430,100);
        jSubmit.setBounds(0,100,430,81);
        jp1.add(jbottom);
        jp1.add(jSubmit);
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
