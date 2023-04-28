import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Graphics implements KeyListener, Runnable{
    public static JFrame frame = new JFrame();
    public static JLabel backgroundLabel = new JLabel();
    public static int screenHeight = 900;
    public static int  screenWidth = (int) (screenHeight*1.618);


    public void makeScreen() throws IOException {

        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        makeBackround();
        //   bossDoor();


        frame.setVisible(true);
    }
    public static void makeBackround() throws IOException {
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://cdna.artstation.com/p/assets/images/images/052/071/822/large/ryan-polito-ninja-village.jpg?1658875955"))));

        backgroundLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(screenWidth, screenHeight, java.awt.Image.SCALE_SMOOTH)));

        backgroundLabel.setSize(screenWidth,screenHeight);
        backgroundLabel.setLocation(0,0);

        frame.add(backgroundLabel);

        frame.repaint();
    }
    private static void bossDoor() throws IOException {
        JLabel label = new JLabel();
        JLabel label1 = new JLabel();
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://art.pixilart.com/0fc84f0c3d4c39f.png"))));

        label1.setText("BOSS");
        label1.setForeground(Color.WHITE);
        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(300, (int) (140*1.618), java.awt.Image.SCALE_SMOOTH)));

        label.setSize(300, (int) (140*1.618));
        label.setLocation(220,-45);
        label1.setSize(100,100);
        label1.setLocation(355,3);


        frame.add(label1);
        frame.add(label);



    }

    public void battleScreen(){

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {

        int keyCode = arg0.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                Character.moveUp();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                Character.moveDown();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                Character.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                Character.moveRight();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @SneakyThrows
    @Override
    public void run() {
        makeBackround();
    }
}