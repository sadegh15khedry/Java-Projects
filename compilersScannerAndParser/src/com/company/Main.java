package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("enter your input:");
        String input = scanner.nextLine();
        System.out.println(input);
        //scanning--------------------------------------------------------
        char[] inputArray = input.toCharArray();
        Scan s1 = new Scan(inputArray);
        ArrayList<String>tokens=s1.scanner();
        s1.printScannerOutput();
        System.out.println();
        //parsing--------------------------------------------------------
        Parser parser = new Parser(tokens);
        boolean answer=parser.pars();
        if (answer){
            System.out.println("answer : yes we parsed your input!!!!");
        }

    }
}
