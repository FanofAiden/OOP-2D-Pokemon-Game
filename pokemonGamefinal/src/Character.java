import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

@Data
public class Character extends Pokemon {

    public static JLabel label = new JLabel();
    private static int moveMultiplier = 9;
    public static Pikachu pikachu;
    public static Snorlax snorlax;
    public static Dragonite dragonite;
    private static int howClose = 150;
    public static int dragoniteX;
    public static int dragoniteY;
    public static int pikachuX;
    public static int pikachuY;
    public static int snorlaxX;
    public static int snorlaxY;
    public static int yourHP;
    public static int enemyHPTemp;
    public static int enemyHP;
    public static JLabel enemyHPLabel;
    public static JLabel youHpLabel;


    public static void makeImage(JFrame frame) throws IOException {
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://art.pixilart.com/2275c1b42ddf9d6.png"))));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, (int) (140 * 1.618), java.awt.Image.SCALE_SMOOTH)));

        label.setSize(100, (int) (140 * 1.618));
        label.setLocation(300, 150);

        frame.add(label);
    }

    public static void makeImageForBattle(JFrame frame) throws IOException {
        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://art.pixilart.com/2275c1b42ddf9d6.png"))));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(500, (int) (400 * 1.618), java.awt.Image.SCALE_SMOOTH)));

        label.setSize(500, (int) (400 * 1.618));
        label.setLocation(460, 170);

        //label.setBorder(BorderFactory.createLineBorder(Color.RED, 5));


        frame.add(label);
    }

    private static void nearPokemon() {
        try {
            Battle battle = new Battle();
            battle.battleSequence();
            //  EnemyPokemon.hitPokemon();
        } catch (IOException e) {
        }

    }

    public static void initializePikachu() {
        System.out.println("Pikachu");
        EnemyPokemon.alivePikachu = true;
        pikachu = new Pikachu();
        pikachuX = pikachu.getX();
        pikachuY = pikachu.getY();
        Thread thread = new Thread(pikachu);
        thread.start();
    }

    public static void initializeSnorlax() {
        System.out.println("Snorlax");
        EnemyPokemon.aliveSnorlax = true;
        snorlax = new Snorlax();
        snorlaxX = snorlax.getX();
        snorlaxY = snorlax.getY();
        Thread thread = new Thread(snorlax);
        thread.start();
    }

    public static void initializeDragonite() {
        System.out.println("Dragonite");
        EnemyPokemon.aliveDragonite = true;
        dragonite = new Dragonite();
        dragoniteX = dragonite.getX();
        dragoniteY = dragonite.getY();
        Thread thread = new Thread(dragonite);
        thread.start();
    }

    private static void checkIfNearPikachu() {
        if (label.getLocation().y < pikachu.getY() + howClose && label.getLocation().y > pikachu.getY() - howClose && label.getLocation().x < pikachu.getX() + howClose && label.getLocation().x > pikachu.getX() - howClose) {
            nearPokemon();
        }
    }

    private static void checkIfNearDragonite() {
        if (label.getLocation().y < dragonite.getY() + howClose && label.getLocation().y > dragonite.getY() - howClose && label.getLocation().x < dragonite.getX() + howClose && label.getLocation().x > dragonite.getX() - howClose) {
            nearPokemon();
        }
    }

    private static void checkIfNearSnorlax() {
        if (label.getLocation().y < snorlax.getY() + howClose && label.getLocation().y > snorlax.getY() - howClose && label.getLocation().x < snorlax.getX() + howClose && label.getLocation().x > snorlax.getX() - howClose) {
            nearPokemon();
        }
    }

    public static void moveUp() {
        if (label.getLocation().y - moveMultiplier > -35 && !Battle.attacking) {
            label.setLocation(label.getLocation().x, label.getLocation().y - moveMultiplier);
        }
        if (EnemyPokemon.aliveDragonite && !Battle.attacking) {
            checkIfNearDragonite();
        } else if (EnemyPokemon.aliveSnorlax && !Battle.attacking) {
            checkIfNearSnorlax();

        } else if (EnemyPokemon.alivePikachu && !Battle.attacking) {
            checkIfNearPikachu();
        }
    }

    public static void moveDown() {
        if (label.getLocation().y + moveMultiplier < 667 && !Battle.attacking) {
            label.setLocation(label.getLocation().x, label.getLocation().y + moveMultiplier);
        }

        if (EnemyPokemon.aliveDragonite && !Battle.attacking) {
            checkIfNearDragonite();
        } else if (EnemyPokemon.aliveSnorlax && !Battle.attacking) {
            checkIfNearSnorlax();
        } else if (EnemyPokemon.alivePikachu && !Battle.attacking) {
            checkIfNearPikachu();
        }
    }

    public static void moveRight() {
        if (label.getLocation().x - moveMultiplier < 1342 && !Battle.attacking) {
            label.setLocation(label.getLocation().x + moveMultiplier, label.getLocation().y);
        }
        if (EnemyPokemon.aliveDragonite == true && !Battle.attacking) {
            checkIfNearDragonite();
        } else if (EnemyPokemon.aliveSnorlax == true && !Battle.attacking) {
            checkIfNearSnorlax();

        } else if (EnemyPokemon.alivePikachu == true && !Battle.attacking) {
            checkIfNearPikachu();
        }


    }

    public static void moveLeft() {
        if (label.getLocation().x - moveMultiplier > -44 && !Battle.attacking) {
            label.setLocation(label.getLocation().x - moveMultiplier, label.getLocation().y);
        }
        if (EnemyPokemon.aliveDragonite == true && !Battle.attacking) {
            checkIfNearDragonite();
        } else if (EnemyPokemon.aliveSnorlax == true && !Battle.attacking) {
            checkIfNearSnorlax();

        } else if (EnemyPokemon.alivePikachu == true && !Battle.attacking) {
            checkIfNearPikachu();
        }

    }

    public static void yourHP() {
        youHpLabel = new JLabel();
        yourHP = 100;
        youHpLabel.setText(Instructions.getName()+ "'s HP: " + yourHP);
        youHpLabel.setSize(500, 100);
        youHpLabel.setFont(new Font("Serif", Font.BOLD, 50));
        youHpLabel.setForeground(Color.WHITE);
        youHpLabel.setLocation(73, 478);
        Battle.frame.add(youHpLabel);
    }

    public static void enemyHP() {
        enemyHPLabel = new JLabel();
        enemyHP = 0;
        if (EnemyPokemon.aliveSnorlax) {
            enemyHP = snorlax.getHealth();
        } else if (EnemyPokemon.alivePikachu) {
            enemyHP = pikachu.getHealth();
        } else if (EnemyPokemon.aliveDragonite) {
            enemyHP = dragonite.getHealth();
        }

        enemyHPLabel.setText("HP: " + enemyHP);
        enemyHPLabel.setSize(500, 100);
        enemyHPLabel.setFont(new Font("Serif", Font.BOLD, 50));
        enemyHPLabel.setForeground(Color.WHITE);
        enemyHPLabel.setLocation(784, 150);
        Battle.frame.add(enemyHPLabel);
    }

    public static void characterFight(String input) {
        if (input.equalsIgnoreCase("Punch")) {
            JOptionPane.showMessageDialog(null, "You attacks with a Punch for 20 damage!");
            enemyHPTemp = enemyHP;
            enemyHP = enemyHP - 20;
        } else if (input.equalsIgnoreCase("Kick")) {
            JOptionPane.showMessageDialog(null, "You attack with a Kick for 30 damage!");
            enemyHPTemp = enemyHP;
            enemyHP = enemyHP - 30;
        }
    }
}

