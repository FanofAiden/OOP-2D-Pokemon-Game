import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Dragonite extends EnemyPokemon implements Runnable {
    private static JLabel label;

    public Dragonite() {
        super();
    }

    public static void spawnDragonite() throws IOException {
        Graphics.frame.remove(Graphics.backgroundLabel);
        label = new JLabel();
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://art.pixilart.com/fee897f6e6db464.png"))));

        label.setSize(190, (int) (280));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));


        label.setLocation(Character.dragoniteX, Character.dragoniteY);

        Graphics.frame.add(label);
        Graphics.makeBackround();
        Graphics.frame.repaint();

        EnemyPokemon.remakeBackround();
    }

    public static void removeDragonite(JFrame frame) {
        frame.remove(label);
    }

    @Override
    public void run() {
        try {
            spawnDragonite();
        } catch (IOException e) {
        }
    }

    public static void dragoniteTaunts() {
        JLabel label = new JLabel();
        label.setText("ROAR!");
        label.setSize(300, 100);
        label.setForeground(Color.WHITE);
        label.setLocation(110, 400);
        Battle.frame.add(label);
    }

    public static void dragonitesMoves() throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        System.out.println(Character.enemyHP);
        if (Character.enemyHP > 0) {

            if (randomNumber == 0) {
                JOptionPane.showMessageDialog(null, "Dragonite attacks with Dragon Tail for 30 damage!");
                Character.yourHP = Character.yourHP - 30;
            } else if (randomNumber == 1) {
                JOptionPane.showMessageDialog(null, "Dragonite attacks with Draco Meteor for 60 damage!");
                Character.yourHP = Character.yourHP - 60;
            } else if (randomNumber == 2) {
                JOptionPane.showMessageDialog(null, "Dragonite blocks your attack!");
                Character.enemyHP = Character.enemyHPTemp;
            } else if (randomNumber == 3) {
                EnemyPokemon.tryToRunAway();
                //end battle sequence in enemyPokemon

            }
        } else {
            JOptionPane.showMessageDialog(null, "You defeated the Pokemon before it could attack");
        }
//        else if (randomNumber == 4){
//            dragoniteTaunts();
//            return 0;
//        }
    }
}

