package ciubuc.dev.lastpensil;

import java.util.Scanner;

/**
 *Fair play
 *
 * Description
 * The game was interesting, but it went sour. No one was playing a fair game! You've taken
 * 10 pencils, your friend decided that it is unfair and somehow took a negative number!
 * Moreover, you both can't decide which of you won. Maybe, it's time to add new rules to the
 * game.
 *
 * Objectives
 * In this stage, your task is to add a new level of control over the game. Check the input.
 * If it's incorrect, print the reason why. Also, limit the possible amount of pencils taken.
 * Let's say that players can remove not more than 3 pencils at a time.
 *
 * Here are possible errors and their feedback:
 *
 * 1. The initial number of pencils is not a numeric string, so it can't be converted to an
 * integer — The number of pencils should be numeric;
 *
 * 2. The initial number of pencils is equal to 0 — The number of pencils should be positive;
 *
 * 3. If the input is a negative amount, apply condition (1), as the minus sign is not a numeric;
 *
 * 4. If the chosen first player is not *Name1* or *Name2* — Choose between *Name1* and *Name2*;
 *
 * 5. One of the players has taken the number of pencils that differs from 1, 2, or 3 —
 * Possible values: '1', '2' or '3';
 *
 * 6. One of the players has taken more pencils than there are on the table —
 * Too many pencils were taken.
 *
 * If one of the errors occurs, ask for input once again. Please note that when an error
 * occurs, you don't need to print whose turn it is. Just output the error feedback
 * (see the examples below).
 *
 * Don't forget to help determine the winner of the game. The player who takes the last pencil
 * loses the game. Print out the result at the end of the game with the line *Winner-name* won!
 */
public class Stage4 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String name1 = "John";
        String name2 = "Jack";

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
            int removed = 0;
            name = (name == name1) ? name2 : name1;

//            try {
                removed = scanner.nextInt();

            if(pencils < removed) {
                System.out.println("Too many pencils were taken");
                continue;
            }

//            } catch(Exception e) {
//                printMessagePossibleValues();
//                continue;
//            }

            if(!checkRemovedPencils(removed)) {
                continue;
            }

            pencils -= removed;

            if(pencils > 0) {
                printTurn(name, pencils);
            } else {
                System.out.printf("%s won!", name);
                break;
            }
        }
    }

    protected static String checkName(String name1,
                                      String name2,
                                      String input,
                                      int pencils) {
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

    protected static boolean checkRemovedPencils(int removed) {
        switch (removed) {
            case 1, 2, 3 -> {
                return true;
            }
            default -> printMessagePossibleValues();
        }
        return false;
    }

    protected static void printMessagePossibleValues() {
        System.out.println("Possible values: '1', '2' or '3'");
    }
}