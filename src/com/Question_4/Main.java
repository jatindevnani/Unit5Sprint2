package com.Question_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //This question demands a good design pattern where our client doesn't need to worry
        //about the implementation and instantiation details of our BNP.

        //This can be easily achieved by using the Factory Design Pattern
        //the following classes and interfaces have been implemented to achieve the desired results -

        //Class PaperManufacturingFactory --> This is to get the actual paper
        //Interface Paper --> We could have simply used the classes,
        //But to facilitate low Coupling and also to follow the Dependency inversion SOLID principle
        //We have used an Interface here

        //The actual classes for each denomination that implements Paper
        //1___ PaperSizeS1
        //2___ PaperSizeS2
        //3___ PaperSizeS3

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the size of paper needed -");


        try {

            int denomination = scanner.nextInt();
            scanner.close();

            Paper paper = PaperManufacturingFactory.getPaper(denomination);
            System.out.println(paper.getPaper());

        } catch(Exception e) {

            System.out.println(e.getMessage());

        }finally {
            scanner.close();
        }
    }
}

class PaperManufacturingFactory {
    public static Paper getPaper(int denomination) {
        if(denomination == 10) {
            return new PaperSizeS1();
        } else if (denomination == 100) {
            return new PaperSizeS2();
        } else if (denomination == 1000) {
            return new PaperSizeS3();
        } else {
            throw new IllegalArgumentException("This denomination doesn't exist. Please choose from 10, 100 or 1000");
        }
    }
}


interface Paper {
    String getPaper();
}

class PaperSizeS1 implements Paper {
    public String getPaper() {
        return "Here is your paper of size S1";
    }
}

class PaperSizeS2 implements Paper {
    public String getPaper() {
        return "Here is your paper of size S2";
    }
}

class PaperSizeS3 implements Paper {
    public String getPaper() {
        return "Here is your paper of size S3";
    }
}

