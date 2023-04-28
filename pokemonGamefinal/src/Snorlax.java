import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

@Data
public class Snorlax extends EnemyPokemon implements Runnable {
    private static JLabel label;

    public Snorlax(){
        super();
    }
    public static void spawnSnorlax() throws IOException {
        // if (Snorlax.getHealth() < 1) {
        Graphics.frame.remove(Graphics.backgroundLabel);
        label = new JLabel();
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://static.wikia.nocookie.net/international-pokedex/images/a/a1/Snorlax_%28Platinum%29.png/revision/latest?cb=20180323185307"))));

        label.setSize(150, (int) (125 * 1.618));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setLocation(Character.snorlaxX, Character.snorlaxY);

        Graphics.frame.add(label);

        EnemyPokemon.remakeBackround();
    }
    // }
    public static void removeSnorlax(JFrame frame){
        frame.remove(label);
    }

    @Override
    public void run() {
        try {
            spawnSnorlax();
        } catch (IOException e) {
        }
    }

    public static void snorlaxTaunts() {
        JLabel label = new JLabel();
        label.setText("zzzZZZ");
        label.setSize(300,100);
        label.setForeground(Color.WHITE);
        label.setLocation(110,420);
        Battle.frame.add(label);

    }
    public static int snorlaxsMoves()throws IOException{
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        System.out.println(Character.enemyHP);
        if (Character.enemyHP > 0) {
            if (randomNumber == 0) {
                JOptionPane.showMessageDialog(null, "Snorlax attacks with Lick for 15 damage!");
                Character.yourHP = Character.yourHP - 15;
            } else if (randomNumber == 1) {
                JOptionPane.showMessageDialog(null, "Snorlax attacks with Hyper Beam for 40 damage!");
                Character.yourHP = Character.yourHP - 40;
            } else if (randomNumber == 2) {
                JOptionPane.showMessageDialog(null, "Snorlax blocks your attack!");
                Character.enemyHP = Character.enemyHPTemp;
            } else if (randomNumber == 3) {
                EnemyPokemon.tryToRunAway();
                //end battle sequence in enemyPokemon

            } else {
                JOptionPane.showMessageDialog(null, "You defeated the Pokemon before it could attack");
            }
        }
//        else if (randomNumber == 4){
//            snorlaxTaunts();
//        }
        return 0;
    }
}
