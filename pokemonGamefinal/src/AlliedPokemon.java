import javax.swing.*;
import java.util.Random;

public class AlliedPokemon extends Pokemon{
    public static void runAway(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber < 8){
            JOptionPane.showInputDialog(null, "You were successful in running away!");
        }else{
            JOptionPane.showMessageDialog(null, "Run away failed!");
        }
    }
    public static void killEnemy(){
        //setXp(30);
        SpawnPokemonTimer.startTimer();
    }
    public static void heal(){

    }

}
