package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of rows: ");
        System.out.print("> ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row: ");
        System.out.print("> ");
        int seats = scanner.nextInt();

        char[][] seatingChart = new char[rows][seats];
        for (char[] row: seatingChart) {
            Arrays.fill(row, 'S');
        }
        menu(rows, seats, seatingChart);
        // go to menu
    }


    public static void printCinema (char[][] seatingChart) {
        // 1. Show the seats

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seatingChart[0].length; i++) {
            System.out.print(" " + i);;
        }
        System.out.println();

        for (int j = 0; j < seatingChart.length; j++) {
            System.out.print(j + 1);
            for (int k = 0; k < seatingChart[j].length; k++) {
                System.out.print(" " + seatingChart[j][k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void purchaseTicket (int rows, int seats, char[][] seatingChart) {
        // 2. Buy a ticket

        System.out.println("Enter a row number: ");
        System.out.print("> ");
        int ticketRow = scanner.nextInt();

        System.out.println("Enter a seat number in that row: ");
        System.out.print("> ");
        int ticketSeat = scanner.nextInt();

        int priceOfTicket;
        if (rows * seats <= 60 || ticketRow <= rows / 2) {
            priceOfTicket = 10;
        }   else {
            priceOfTicket = 8;
        }


        // alternative method for the same priceOfTicket calculation as above
//        int totalSeats = rows * seats;
//        int priceOfTicket = 10;
//
//        int frontHalfRows = rows/2;
//        int remainder = rows % 2;
//        int backHalfRows = frontHalfRows + remainder;
//
//        if (totalSeats >= 60 && ticketRow >= backHalfRows) {
//            priceOfTicket = 8;
//        }


        System.out.println("Ticket price: $" + priceOfTicket);
        seatingChart[ticketRow - 1][ticketSeat - 1] = 'B';
        // we just change the index of User's ticket seat to 'B' and save it
    }

    public static void menu(int rows, int seats, char[][] seatingChart) {
        // menu options
        while(true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            System.out.print("> ");

            String option = scanner.next();

            if (option.equals("1")) {
                printCinema(seatingChart);
            }   else if (option.equals("2")) {
                purchaseTicket(rows,seats,seatingChart);
            }   else if (option.equals("0")) {
                break;
            }
        }
    }

}