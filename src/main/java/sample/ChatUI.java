package sample;

import com.sun.awt.AWTUtilities;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class ChatUI extends JFrame {
    private JFrame jFrame;
    private ImageIcon imageIcon;
    private JPanel topPanel;
    private JPanel showContentPanel;
    private JPanel inputPanel;
    private JPanel rightImagepanel;
    private ImageIcon rightImageIcon;

    public ChatUI(){
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
        topPanel.setBackground(Color.BLUE);
        topPanel.setOpaque(false);

        showContentPanel = new JPanel();
        showContentPanel.setSize(new Dimension(450,350));
//        showContentPanel.setOpaque(false);

//        showContentPanel.setBackground(Color.ORANGE);
        JEditorPane jTextPane = new JEditorPane();
        jTextPane.setPreferredSize(new Dimension(450,350));
        jTextPane.setOpaque(false);

        jTextPane.setEditable(false);
        jTextPane.setBorder(BorderFactory.createMatteBorder(2,0,2,2, Color.lightGray));
        showContentPanel.setLayout(null);
        jTextPane.setBounds(0,0,450,350);
        showContentPanel.add(jTextPane);


        inputPanel = new JPanel();
        inputPanel.setSize(new Dimension(450,150));
//        inputPanel.setBackground(Color.black);

        inputPanel.setOpaque(false);
        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setPreferredSize(new Dimension(450,100));
        jEditorPane.setOpaque(false);

        inputPanel.setLayout(null);
        jEditorPane.setBounds(0,0,450,100);
        inputPanel.add(jEditorPane);

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
                System.out.println(jEditorPane.getText());
            }
        });
        jEditorPane.registerKeyboardAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String context = jEditorPane.getText();
                jEditorPane.setText("");
                System.out.println(jEditorPane.getText()+context+"\n");
                jTextPane.setText(jTextPane.getText()+context+"\n");


            }
        },KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);

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