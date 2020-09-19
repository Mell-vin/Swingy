package com.lgumede.swingy;

import java.util.Scanner;

import com.lgumede.swingy.view.Terminal;

public class Console {
    static int choice = 37;
    static Scanner input = new Scanner(System.in);
    static Swingy gui = new Swingy();

    public static void main(String[] args) {
        new Terminal().menu(args);
    }
}
