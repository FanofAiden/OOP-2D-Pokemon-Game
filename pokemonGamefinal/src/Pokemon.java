import lombok.Data;

import javax.swing.*;
import java.util.Random;

@Data
public class Pokemon {

    public int level;
    public int damage;
    public int health;
    public int xp;
    public int amountOfXPNeededForNextLevel = level*10;
    public void pokemon(){

    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void levelUp(){
        level++;
        damage = damage + 5;
        health = health + 10;

    }
    public static int attack(int strength, int opponentHealth){
        return (opponentHealth - strength);
    }
    public static void capture(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0){
            JOptionPane.showMessageDialog(null, "Capture Successful\n" + "New Pokemon Secured");

        }else if (randomNumber == 1){
            JOptionPane.showMessageDialog(null, "Capture Failed");
        }
    }
    public static void heal() {
        String potionsUsedString = JOptionPane.showInputDialog("How many potions would you like to use? (Heals 1/2 max hp per potion)");
        int potionsUsed;
        try {
            potionsUsed = Integer.parseInt(potionsUsedString);
        } catch (Exception e){ }

    }


}
