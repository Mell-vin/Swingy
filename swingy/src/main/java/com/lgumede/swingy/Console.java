package com.lgumede.swingy;

import java.util.Scanner;

public class Console {
    static int choice = 37;
    static Scanner input = new Scanner(System.in);
    static Swingy gui = new Swingy();

    public static void main(String[] args) {
        System.out.println("Welcome to swingy. please choose and option");

        while(choice != 0) {
            System.out.println("1) For a new character\n"
                            + "2) For a saved character\n"
                            + "3) to open the gui");
            choice = Integer.parseInt(input.nextLine());

            switch(choice) {
                case 0:
                    System.out.println("Good bye");
                    break;
                case 1:
                    System.out.println("Choose your new hero");
                    break;
                case 2:
                    System.out.println("Choose your saved hero");
                    break;
                case 3:
                    Swingy.main(args);
                    break;
                default:
                    System.out.println("invalid choice. try again");
            }
        }
    }
}
