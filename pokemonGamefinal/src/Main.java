import java.io.IOException;

public class Main {
    public static SpawnPokemonTimer timer;
    public static Graphics graphics;
    public static void main(String[] args) throws IOException {
        Instructions.gameInstructions();
        Instructions.userNameInput();
        makeScreen();
        spawnPokemonTimer();

    }

    private static void spawnPokemonTimer(){
        timer = new SpawnPokemonTimer();
        Thread thread = new Thread(timer);
        thread.start();
    }
    private static void makeScreen() throws IOException {
        graphics = new Graphics();

        Character.makeImage(Graphics.frame);

        graphics.makeScreen();

    }
}
