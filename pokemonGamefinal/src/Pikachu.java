import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

@Data
public class Pikachu extends EnemyPokemon implements Runnable {

    public Pikachu() {
        super();
    }

    private static JLabel label;

    public void spawnPikachu() throws IOException {

        label = new JLabel();
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://www.pinclipart.com/picdir/big/334-3347949_pikachu-pikachu-pixel-art-clipart.png"))));

        label.setSize(57, (int) (60));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setLocation(Character.pikachuX, Character.pikachuY);

        Graphics.frame.remove(Graphics.backgroundLabel);

        Graphics.frame.add(label);

        EnemyPokemon.remakeBackround();
    }

    public static void removePikachu(JFrame frame) {
        frame.remove(label);
    }

    @Override
    public void run() {
        try {
            spawnPikachu();
        } catch (IOException e) {
        }
    }

    public static void pikachuTaunts() {
        JLabel label = new JLabel();
        label.setText("Pika! Pika!");
        label.setSize(300, 100);
        label.setForeground(Color.WHITE);
        label.setLocation(110, 420);
        Battle.frame.add(label);

    }

    public static void pikachusMoves() throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        System.out.println(Character.enemyHP);
        if (Character.enemyHP > 0) {
            if (randomNumber == 0) {
                JOptionPane.showMessageDialog(null, "Pikachu attacks with Volt tackle for 50 damage!");
                Character.yourHP = Character.yourHP - 50;
            } else if (randomNumber == 1) {
                JOptionPane.showMessageDialog(null, "Pikachu attacks with Iron tail for 40 damage!");
                Character.yourHP = Character.yourHP - 40;
            } else if (randomNumber == 2) {
                JOptionPane.showMessageDialog(null, "Pikachu attacks with Quick Attack for 15 damage!");
                Character.yourHP = Character.yourHP - 15;
            } else if (randomNumber == 3) {
                JOptionPane.showMessageDialog(null, "Pikachu blocks your attack!");
                Character.enemyHP = Character.enemyHPTemp;
            } else if (randomNumber == 4) {
                EnemyPokemon.tryToRunAway();
            }
        } else{
            JOptionPane.showMessageDialog(null, "You defeated the Pokemon before it could attack");
        }
//        else if (randomNumber == 5){
//            pikachuTaunts();
//            return 0;
//        }
        //return 0;
    }

}
