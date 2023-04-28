import javax.swing.*;

public class Instructions {


    private static String name;
    public static void gameInstructions(){
        JOptionPane.showMessageDialog(null, "Hello and welcome to our Object oriented pokemon game. \n" +
                "To move your character, use the arrow keys to move up, down, left, and right. \n" +
                "Go around and explore, but beware, there could be some enemy pokemon lurking around. \n" +
                "Good Luck and Have Fun!");
    }
    public static void userNameInput (){
        name = JOptionPane.showInputDialog("Enter your trainer name: ");
    }
    public static String getName(){
        return name;
    }
    public static void setName(String name) {
        Instructions.name = name;
    }
}
