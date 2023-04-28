import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

@Data
@Getter
@Setter
public class EnemyPokemon extends Pokemon implements Runnable {

    private static int minX = -44;
    private static int maxX = 1342;
    private static int minY = -35;
    private static int maxY = 667;
    private static int x = 0;
    private static int y = 0;
    public static boolean alivePikachu = false;
    public static boolean aliveSnorlax = false;
    public static boolean aliveDragonite = false;
    public static boolean runAwaySuccessfulQuestionMark;

    public static void remakeBackround(){
        Graphics graphics = new Graphics();
        Thread thread = new Thread(graphics);

        thread.start();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int randomYSpawnLocation() {
        Random random = new Random();
        int randomNumber = random.nextInt(maxY - minY) - minY;
        return randomNumber;
    }

    public static int randomXSpawnLocation() {
        Random random = new Random();
        int randomNumber = random.nextInt(maxX - minX) - minX;
        return randomNumber;
    }


    public EnemyPokemon() {
        Random random = new Random();
        this.setDamage(random.nextInt(3) + 2);
        this.setHealth(random.nextInt(20) + 50);
        this.setLevel(random.nextInt(5) + 1);
        this.setX(EnemyPokemon.randomXSpawnLocation());
        this.setY(EnemyPokemon.randomYSpawnLocation());
    }

    public static void tryToRunAway() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber < 8) {
            JOptionPane.showMessageDialog(null, "Enemy fled!");
            runAwaySuccessfulQuestionMark = true;
            Battle.frame.dispose();
            Battle.removePokemonFromBattleScreen();
            Battle.restartAdventurePart();
        } else {
            JOptionPane.showMessageDialog(null, "Enemy tried to flee but failed!");
        }
    }


    public static void defeated() {
        JOptionPane.showMessageDialog(null, "Congratulations on defeating this powerful Pokemon!");

    }

    public static void enemyHealthPoints() {
        JOptionPane.showMessageDialog(null, "HP: ");

    }


    public void spawnPokemon() throws IOException {
        Random random = new Random();

        int randomNumber = random.nextInt(3);
        if (randomNumber == 0) {
            if (alivePikachu == false){
                alivePikachu=true;
                Pikachu pikachu = new Pikachu();
                Thread thread = new Thread(pikachu);
                thread.start();
            }

        } else if (randomNumber == 1) {
            if (alivePikachu == false){
                alivePikachu=true;
                Dragonite dragonite = new Dragonite();
                Thread thread = new Thread(dragonite);
                thread.start();
            }
        } else if (randomNumber == 2) {
            if (aliveSnorlax == false){
                aliveSnorlax=true;
                Snorlax snorlax = new Snorlax();
                Thread thread = new Thread(snorlax);
                thread.start();
            }
        }
    }

    @Override
    public void run() {

//        while (true) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//            }
//            runAroundRandomly();
//        }


    }
}
