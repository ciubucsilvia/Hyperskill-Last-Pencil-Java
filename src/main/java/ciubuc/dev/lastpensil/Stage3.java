package ciubuc.dev.lastpensil;

import java.util.Scanner;

/**
 * Working on the gameplay
 *
 * Description
 * An interesting idea has come to your mind. Let's change the rules of game. Players take turns
 * taking X pencils until none of them remain.
 *
 * Objectives
 * Expand your program by creating a loop. Each player takes turns removing pencils until
 * 0 pencils remain on the table. Each iteration prints 2 lines: lines with pencils
 * (vertical bars) and whose turn is now by printing the *NameX*'s turn string. If there are
 * no pencils left after a player's move, the loop breaks and the game ends without any
 * additional output.
 *
 */
public class Stage3 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String name1 = "John";
        String name2 = "Jack";
//        int pencils = 0;

        System.out.println("How many pencils would you like to use:");

        int pencils = getPencils(scanner.next());
        startGame(name1, name2, pencils);
    }

    protected static void startGame(String name1, String name2, int pencils) {
        System.out.printf("Who will be the first (%s, %s):\n", name1, name2);
        String input = scanner.next();

//        It`s the name that turn
        String name = checkName(name1, name2, input, pencils);

        while(pencils != 0) {
            int removed = scanner.nextInt();
            pencils -= removed;

            name = (name == name1) ? name2 : name1;

            if(pencils != 0) {
                printTurn(name, pencils);
            }
        }

    }

    protected static String checkName(String name1, String name2, String input, int pencils) {
        if(input.equals(name1)) {
            printTurn(name1, pencils);
            return name1;
        } else if(input.equals(name2)) {
            printTurn(name2, pencils);
            return name2;
        } else {
            System.out.println("Choose between 'John' and 'Jack'");
            checkName(name1, name2, scanner.next(), pencils);
        }
        return "";
    }

    protected static void printPencils(int pencils) {
        for(int i = 0; i < pencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    protected static void printTurn(String name, int pencils) {
        printPencils(pencils);
        System.out.printf("%s's turn!\n", name);

    }

    protected static int getPencils(String pencils) {
        try {
            int result =  Integer.parseInt(pencils);

            if(result <= 0) {
                System.out.println("The number of pencils should be positive");
                return getPencils(scanner.next());
            }
            return result;
        } catch (Exception e) {
            System.out.println("The number of pencils should be numeric");
            return getPencils(scanner.next());
        }
    }
}
