import javax.swing.*;
import java.util.Random;

public class BossPokemon extends EnemyPokemon{

    public static void taunt(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0){
            JOptionPane.showMessageDialog(null, "YOU SUCK. GIVE UP NOW!!");
        }else if (randomNumber == 1){

        }else if (randomNumber == 2){

        }
    }
    public static void specialMove(){

    }
    public static void bossHP(){
        //int bossHealth = EnemyPokemon.getHealth() + 50;
        //JOptionPane.showMessageDialog(null, "BOSS HP: " + bossHealth);
    }

}
