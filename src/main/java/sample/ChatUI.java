package sample;

import Entity.Message;
import Entity.User;
import com.google.gson.Gson;
import com.sun.awt.AWTUtilities;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;

public class ChatUI extends JFrame implements Runnable {
    private JFrame jFrame;
    private ImageIcon imageIcon;
    private JPanel topPanel;
    private JPanel showContentPanel;
    private JPanel inputPanel;
    private JPanel rightImagepanel;
    private ImageIcon rightImageIcon;
    private static Client client;
    private JEditorPane jTextPane;
    private JLabel jname;
    private static User user;
    public static void setClient(Client c){
        client = c;
    }



    public ChatUI(Client c,User u){
        user = u;
        client = c;
        jFrame = new JFrame();
        jFrame.setSize(new Dimension(600,600));
        jFrame.setUndecorated(true);
        ImageIcon backgroundImage  = new ImageIcon("./src/main/java/sample/chat.jpg");
        Image img = backgroundImage.getImage();
        img = img.getScaledInstance(600,600,Image.SCALE_DEFAULT);
        backgroundImage.setImage(img);
        ImageLabel jLabel = new ImageLabel(backgroundImage);
        jLabel.setAlpha(0.5f);

        jFrame.setLocationRelativeTo(this.getOwner());

        topPanel = new JPanel();
        topPanel.setSize(new Dimension(600,100));
//        topPanel.setBackground(Color.BLUE);
//        topPanel.setOpaque(false);

        ImageIcon head = new ImageIcon(new ImageIcon("./src/main/java/sample/head.jpg").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
        JLabel headLable = new JLabel(head);
        headLable.setSize(60,60);

        JPanel jClosePanel = new JPanel();
        jClosePanel.setSize(new Dimension(150,30));
        jClosePanel.setOpaque(false);
        JButton jCloseBtn = new JButton();
        jCloseBtn.setPreferredSize(new Dimension(15,15));
        jCloseBtn.setIcon(new ImageIcon(new ImageIcon("./src/main/java/sample/Closed.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
;       jCloseBtn.setOpaque(false);
        jCloseBtn.setBorder(null);
        jCloseBtn.setContentAreaFilled(false);
        jCloseBtn.setBorderPainted(false);


        JButton jMinBtn = new JButton();
        jMinBtn.setPreferredSize(new Dimension(15,15));
        jMinBtn.setIcon(new ImageIcon(new ImageIcon("./src/main/java/sample/Chatmin.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
        jMinBtn.setOpaque(false);
        jMinBtn.setBorder(null);
        jMinBtn.setContentAreaFilled(false);
        jMinBtn.setBorderPainted(false);


        JButton jMaxBtn = new JButton();
        jMaxBtn.setPreferredSize(new Dimension(15,15));
        jMaxBtn.setIcon(new ImageIcon(new ImageIcon("./src/main/java/sample/max.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
        jMaxBtn.setOpaque(false);
        jMaxBtn.setBorder(null);
        jMaxBtn.setContentAreaFilled(false);
        jMaxBtn.setBorderPainted(false);


        jClosePanel.add(jMinBtn);
        jClosePanel.add(jMaxBtn);
        jClosePanel.add(jCloseBtn);
        jname = new JLabel();
        if(client!=null)
        {
            jname.setText(user.getName());
        }

        jname.setSize(new Dimension(100,30));
        jname.setBackground(Color.black);
        topPanel.setLayout(null);
        headLable.setBounds(10,10,60,60);
        jClosePanel.setBounds(495,0,150,30);
        jname.setBounds(70,10,100,30);


        topPanel.add(headLable);
        topPanel.add(jClosePanel);
        topPanel.add(jname);

        showContentPanel = new JPanel();
        showContentPanel.setSize(new Dimension(450,350));
//        showContentPanel.setOpaque(false);

//        showContentPanel.setBackground(Color.white);
        jTextPane = new JEditorPane();
        jTextPane.setPreferredSize(new Dimension(450,350));
//        jTextPane.setBackground(Color.white);
        jTextPane.setOpaque(false);
        jTextPane.setBorder(null);
        jTextPane.setFont(new Font("宋体",Font.BOLD,20));

        jTextPane.setEditable(false);
//        jTextPane.setBorder(BorderFactory.createMatteBorder(2,0,2,2, Color.lightGray));
        showContentPanel.setLayout(null);
        jTextPane.setBounds(0,0,450,350);
        showContentPanel.add(jTextPane);


        inputPanel = new JPanel();
        inputPanel.setSize(new Dimension(450,150));
//        inputPanel.setBackground(Color.black);

        inputPanel.setOpaque(false);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setPreferredSize(new Dimension(450,70));
        jEditorPane.setOpaque(false);
        jEditorPane.setBackground(new Color(0,0,0,0));
//        jEditorPane.setContentType("text/html");
        jEditorPane.setFont(new Font("宋体",Font.PLAIN,20));


        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(new Dimension(450,20));
        menuBar.setBorderPainted(false);
        JMenu fontMenu = new JMenu("");
        fontMenu.setIcon(new ImageIcon("./src/main/java/sample/A.png"));
        fontMenu.setSize(new Dimension(20,20));

        JMenu smileMenu = new JMenu("");
        smileMenu.setIcon(new ImageIcon("./src/main/java/sample/Smile.png"));
        smileMenu.setSize(new Dimension(20,20));

        JMenu phoneMenu = new JMenu("");
        phoneMenu.setIcon(new ImageIcon("./src/main/java/sample/phone.png"));
        phoneMenu.setSize(new Dimension(20,20));

        JMenu pictureMenu = new JMenu("");
        pictureMenu.setIcon(new ImageIcon("./src/main/java/sample/Picture.png"));
        pictureMenu.setSize(new Dimension(20,20));

        JMenu sscissorMenue = new JMenu("");
        sscissorMenue.setIcon(new ImageIcon("./src/main/java/sample/sscissor.png"));
        sscissorMenue.setSize(new Dimension(20,20));

        menuBar.add(fontMenu);
        menuBar.add(smileMenu);
        menuBar.add(phoneMenu);
        menuBar.add(pictureMenu);
        menuBar.add(sscissorMenue);

        menuBar.setBackground(Color.white);
        menuBar.setOpaque(false);
//        menuBar.setBorder(null);
//        menuBar.setBorderPainted(false);


        inputPanel.setLayout(null);
        jEditorPane.setBounds(0,30,450,70);
        menuBar.setBounds(0,0,450,30);
        inputPanel.add(jEditorPane);
        inputPanel.add(menuBar);




        rightImagepanel = new JPanel();
        rightImagepanel.setSize(150,500);
//        rightImagepanel.setBackground(Color.pink);
        rightImagepanel.setOpaque(false);

        ImageIcon image = new ImageIcon("./src/main/java/sample/QQ.png");
        Image img1 = image.getImage();
        img.getScaledInstance(150,500,Image.SCALE_DEFAULT);
        image.setImage(img1);
        JLabel jQQLabel = new JLabel(image);

        rightImagepanel.setLayout(null);
        jQQLabel.setBounds(0,0,150,500);
        jQQLabel.setOpaque(false);
        rightImagepanel.add(jQQLabel);

        JPanel jBtnPanel = new JPanel();
        jBtnPanel.setSize(new Dimension(450,50));
        jBtnPanel.setOpaque(false);
        JButton jSend = new JButton("发  送");
        JButton jClose = new JButton("关  闭");
        jSend.setFont(new Font("黑体",Font.PLAIN,14));
        jSend.setForeground(Color.white);
        jSend.setBackground(Color.BLUE);
        jClose.setFont(new Font("黑体",Font.PLAIN,14));
        jClose.setForeground(Color.white);
        jClose.setBackground(Color.BLUE);
        jBtnPanel.setLayout(null);
        jClose.setBounds(250,10,80,30);
        jSend.setBounds(340,10,80,30);
        jBtnPanel.add(jClose);
        jBtnPanel.add(jSend);
        jLabel.setLayout(null);

        showContentPanel.setBounds(0,100,450,350);
        inputPanel.setBounds(0,450,450,100);
        rightImagepanel.setBounds(450,100,150,500);
        jBtnPanel.setBounds(0,550,450,50);



        jLabel.add(topPanel);
        jLabel.add(showContentPanel);
        jLabel.add(inputPanel);
        jLabel.add(jBtnPanel);
        jLabel.add(rightImagepanel);




        jFrame.setLayout(null);
        jLabel.setBounds(0,0,600,600);
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jEditorPane.requestFocus();

//        this.addKeyListener(new ChatKeyAdapter());

        jSend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(jEditorPane.getText());
            }
        });
        jEditorPane.registerKeyboardAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String context = jEditorPane.getText();
                jEditorPane.setText("");
//                System.out.println(jEditorPane.getText()+context+"\n");

                String message;
                if(client.getSocket().getLocalPort()==8089){
                    message= "{\"sendIP\":\"127.0.0.1:8089\",\"RecvIP\":\"127.0.0.1:8090\",\"msg\":\""+context+"\"}";
                }else{
                    message= "{\"sendIP\":\"127.0.0.1:8090\",\"RecvIP\":\"127.0.0.1:8089\",\"msg\":\""+context+"\"}";
                }

                if(client!=null){
                    client.sendMessage(message);
                }
                jTextPane.setText(jTextPane.getText()+client.getSocket().getLocalAddress().toString().substring(1)+" "+client.getSocket().getLocalPort()+":\n"+context+"\n");
//                System.out.println(client.getSocket().getLocalAddress().toString()+" "+client.getSocket().getLocalPort()+":\n"+jTextPane.getText()+context+"\n");

            }
        },KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);

    }

    public void dragTheWindow(){
        DragWindow dw = new DragWindow();
        jFrame.addMouseListener(dw);
        jFrame.addMouseMotionListener(dw);

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
            jFrame.setLocation(currentCoords.x-MouseDownCompCoords.x,currentCoords.y-MouseDownCompCoords.y);
        }
    }

    public void run(){
        while (true) {
            StringBuffer strBuffer = new StringBuffer();
            Message message =new Gson().fromJson(client.recvMessage().trim(),Message.class);

            strBuffer.append(message.getSendIP() + ":\n" + message.getMsg());
//
//            System.out.println("接受到了"+client.recvMessage());
            if (!message.getMsg().equals("")) {
                System.out.println("show");
                jTextPane.setText(jTextPane.getText() + strBuffer + "\n");
                jFrame.repaint();
            }
            strBuffer.delete(0, strBuffer.length());
        }
    }


}

//class ChatKeyAdapter extends KeyAdapter{
//    @Override
//    public void keyPressed(KeyEvent e) {
//        super.keyPressed(e);
//        if(e.getKeyChar()==KeyEvent.VK_E){
//            System.out.println("key pressed");
//        }
//    }
//}
class ImageLabel extends JLabel{
    public ImageLabel(ImageIcon icon){
        super.setIcon(icon);
    }
    private AlphaComposite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1);
    private float alpha;

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        if (isVisible())   paintImmediately(getBounds());
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(cmp.derive(alpha));
        super.paintComponent(g2d);

    }


}