import lombok.Data;

import javax.swing.*;
import java.io.IOException;
import java.util.Random;

@Data
public class SpawnPokemonTimer implements Runnable{

    public static int getHowLongForPokemonToSpawn() {
        return howLongForPokemonToSpawn;
    }
    public static void setHowLongForPokemonToSpawn(int howLongForPokemonToSpawn) {
        SpawnPokemonTimer.howLongForPokemonToSpawn = howLongForPokemonToSpawn;
    }

    private static int howLongForPokemonToSpawn = 5;
    private static boolean timerOnOff = true;
    public void pauseTimer(){
        timerOnOff = false;
    }
    public static void startTimer(){
        timerOnOff = true;
    }

    @Override
    public void run() {
        while (timerOnOff){
            try {
                Thread.sleep(howLongForPokemonToSpawn*1000);
                System.out.println(howLongForPokemonToSpawn + " seconds passed");
            } catch (InterruptedException e) {
            }
            if (EnemyPokemon.aliveSnorlax == false && EnemyPokemon.alivePikachu == false && EnemyPokemon.aliveDragonite == false) { //there isnt a pokemon already alive
                try {
                    spawnPokemon();
                } catch (IOException e) {
                }
            }
        }
    }
    public void spawnPokemon() throws IOException {
        System.out.println("Enemy Pokemon Spawned");
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0){
            Character.initializePikachu();
        }else if (randomNumber == 1){
            Character.initializeDragonite();
        }else if (randomNumber == 2){
            Character.initializeSnorlax();
        }
    }
}
