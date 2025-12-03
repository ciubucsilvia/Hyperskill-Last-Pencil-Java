package ciubuc.dev.lastpensil;

import java.util.Scanner;

/**
 * New rules
 *
 * Description
 * Your friend's suggestion surprised you a little bit. After a couple of "No, you" retaliations,
 * you decided that it would be more convenient to input the initial conditions to determine who
 * goes first, and how many pencils there are on the table.
 *
 * Objectives
 * Write a program that will satisfy the conditions below:
 *
 * 1. Ask users to input the number of pencils with the How many pencils string. Read the number;
 * 2. Ask users to input who goes first from the two possible players. To do so, output the Who will
 * be the first (*Name1*, *Name2*) string. You can ask a user to choose from any two names that
 * consist of the letters of the English alphabet and numbers (for example, John and Jack). Read
 * the name;
 * 3. Print two lines: one with vertical bar symbols representing the input number of pencils, the
 * other with the *NameX* is going first string.
 *
 */
public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name1 = "John";
        String name2 = "Jack";

        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();

        System.out.printf("Who will be the first (%s, %s):\n", name1, name2);
        String input = scanner.next();

        if(input.equals(name1)) {
            printTurn(name1, pencils);
        } else {
            printTurn(name2, pencils);
        }
    }

    protected static void printPencils(int pencils) {
        for(int i = 0; i < pencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    protected static void printTurn(String name, int pencils) {
        printPencils(pencils);
        System.out.printf("%s is going first!", name);
    }
}
