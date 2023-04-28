
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.IOException;
import java.net.URL;

public class Battle {
    public static int screenHeight = 900;
    public static int screenWidth = (int) (screenHeight * 1.618);
    public static boolean attacking;
    private static JLabel label;

    public static JLabel backgroundLabel2 = new JLabel();
    public static JFrame frame = new JFrame();

    public void battleSequence() throws IOException {
        Graphics.frame.dispose();

        attacking = true;
        battleFrame();


        if (EnemyPokemon.aliveDragonite) {
            battleDragonite(); //put pic on battle screen
            Dragonite.removeDragonite(Graphics.frame); //remove pic from adventure part screen
        } else if (EnemyPokemon.aliveSnorlax) {
            battleSnorlax();
            Snorlax.removeSnorlax(Graphics.frame);
        } else if (EnemyPokemon.alivePikachu) {
            battlePikachu();
            Pikachu.removePikachu(Graphics.frame);
        }

        ImageIcon ii = new ImageIcon((ImageIO.read(new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/b4f53ec3-b5bb-42db-9868-be27f9fe2abb/d4r6ruq-109bd6bb-94ce-4778-91aa-3111ca23d4b3.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2I0ZjUzZWMzLWI1YmItNDJkYi05ODY4LWJlMjdmOWZlMmFiYlwvZDRyNnJ1cS0xMDliZDZiYi05NGNlLTQ3NzgtOTFhYS0zMTExY2EyM2Q0YjMucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.bXEbUs4kjs5QazSRHJeRqA094gTc4r2vuZhk0122F9M"))));
        Character.yourHP();
        Character.enemyHP();
        backgroundLabel2.setIcon(new ImageIcon(ii.getImage().getScaledInstance(screenWidth, screenHeight, java.awt.Image.SCALE_SMOOTH)));

        backgroundLabel2.setSize(screenWidth, screenHeight);
        backgroundLabel2.setLocation(0, 0);

        frame.add(backgroundLabel2);

        frame.setVisible(true);

        String input = "";
        do {
            input = JOptionPane.showInputDialog(null, "What would you like to do? \n Your options are fight, block or run");
            checkInput(input);
        } while (Character.enemyHP > 0 && Character.yourHP > 0 && !input.equalsIgnoreCase("run") && !input.equalsIgnoreCase("flee") && !EnemyPokemon.runAwaySuccessfulQuestionMark);

        if (Character.enemyHP < 1){
            removePokemonFromBattleScreen();
            restartAdventurePart();
            frame.dispose();
            JOptionPane.showMessageDialog(null, "You won the battle, but you didn't win the war");
        } else if (Character.yourHP < 1){
            removePokemonFromBattleScreen();
            restartAdventurePart();
            frame.dispose();
            JOptionPane.showMessageDialog(null, "You lost the battle but you can still win the game");
        }

    }
    public static void removePokemonFromBattleScreen(){
        if (EnemyPokemon.alivePikachu) {
            EnemyPokemon.alivePikachu = false;
            Pikachu.removePikachu(frame);
        } else if (EnemyPokemon.aliveSnorlax) {
            EnemyPokemon.aliveSnorlax = false;
            Snorlax.removeSnorlax(frame);
        } else if (EnemyPokemon.aliveDragonite) {
            EnemyPokemon.aliveDragonite = false;
            Dragonite.removeDragonite(frame);
        }
        frame.remove(label);

        frame.remove(Character.enemyHPLabel);
        frame.remove(Character.youHpLabel);
    }

    @SneakyThrows
    public static void restartAdventurePart() {
        Character.makeImage(Graphics.frame);
        Main.graphics.makeScreen();
        attacking = false;

        JOptionPane.showMessageDialog(null, "Your speed has increased as a result of fighting");
    }

    @SneakyThrows
    public static void checkInput(String input) {

        if (input.equalsIgnoreCase("fight")) {
            String input2 = JOptionPane.showInputDialog("do you want to punch or kick");
            Character.characterFight(input2);

            if (EnemyPokemon.alivePikachu) {
                Pikachu.pikachusMoves();
            } else if (EnemyPokemon.aliveSnorlax) {
                Snorlax.snorlaxsMoves();
            } else if (EnemyPokemon.aliveDragonite) {
                Dragonite.dragonitesMoves();
            }
            Character.enemyHPLabel.setText("HP: " + Character.enemyHP);
            Character.youHpLabel.setText(Instructions.getName() + "'s HP: " + Character.yourHP);

        } else if (input.equalsIgnoreCase("block")) {
            JOptionPane.showMessageDialog(null,"you chose to block, their attack will do no damage");
        } else if (input.equalsIgnoreCase("run") || input.equalsIgnoreCase("flee")) {
            frame.dispose();
            restartAdventurePart();
            removePokemonFromBattleScreen();

        } else {
            checkInput(JOptionPane.showInputDialog("Did not understand \"" + input + "\" please re-enter your choice"));
        }
    }

    public static void battleSnorlax() {
        System.out.println("Battle Snorlax");
        label = new JLabel();
        ImageIcon ii = null;
        try {
            ii = new ImageIcon((ImageIO.read(new URL("https://static.wikia.nocookie.net/international-pokedex/images/a/a1/Snorlax_%28Platinum%29.png/revision/latest?cb=20180323185307"))));
        } catch (IOException e) {
        }

        label.setSize(200, (int) (150 * 1.618));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setLocation(1090, 145);

        frame.add(label);

    }

    public static void battlePikachu() {
        System.out.println("Battle Pikachu");

        label = new JLabel();
        ImageIcon ii = null;
        try {
            ii = new ImageIcon((ImageIO.read(new URL("https://www.pinclipart.com/picdir/big/334-3347949_pikachu-pikachu-pixel-art-clipart.png"))));
        } catch (IOException e) {
        }

        label.setSize(100, (int) (75 * 1.618));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setLocation(1099, 244);

        Graphics.frame.remove(Graphics.backgroundLabel);

        frame.add(label);


    }

    public static void battleDragonite() {
        System.out.println("Battle Dragonite");

        label = new JLabel();
        ImageIcon ii = null;
        try {
            ii = new ImageIcon((ImageIO.read(new URL("https://art.pixilart.com/fee897f6e6db464.png"))));
        } catch (IOException e) {
        }

        label.setSize(300, (int) (225 * 1.618));

        label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setLocation(1036, -26);

        frame.add(label);


    }

    @SneakyThrows
    public void battleFrame() {
        Character.makeImageForBattle(frame);
        frame.setSize(Graphics.screenWidth, Graphics.screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

    }


}
