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

        int ticketsPurchased = 0;
        int currentIncome = 0;

        // Display Menu
        while(true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");

            String option = scanner.next();

            if (option.equals("1")) {
                printCinema(seatingChart);
            }   else if (option.equals("2")) {
                currentIncome += purchaseTicket(rows, seats, seatingChart);
                ticketsPurchased++;
            }   else if (option.equals("0")) {
                break;
            }   else if (option.equals("3")) {
                int totalIncome = totalIncome(rows, seats);
                statistics(rows, seats, ticketsPurchased, currentIncome, totalIncome);
            }
        }

    }

    // Menu Option 1. Show the seats
    public static void printCinema (char[][] seatingChart) {

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

    // Menu option 2. Buy a ticket
    public static int purchaseTicket (int rows, int seats, char[][] seatingChart) {

        System.out.println("Enter a row number: ");
        System.out.print("> ");
        int ticketRow = scanner.nextInt();

        System.out.println("Enter a seat number in that row: ");
        System.out.print("> ");
        int ticketSeat = scanner.nextInt();

        // if array out of range/array exception occurs, restart purchaseTicket method again. Otherwise continue
        if (ticketRow <= 0 || ticketRow > rows || ticketSeat <= 0 || ticketSeat > seats) {
            System.out.println("Wrong input!");
            System.out.println();
            purchaseTicket(rows, seats, seatingChart);
        }   else if (seatingChart[ticketRow - 1][ticketSeat - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            purchaseTicket(rows, seats, seatingChart);
        }   else {
            seatingChart[ticketRow - 1][ticketSeat - 1] = 'B';
            // change the index of User's ticket seat to 'B' and save it
        }

        int priceOfTicket;
        if (rows * seats <= 60 || ticketRow <= rows / 2) {
            priceOfTicket = 10;
        }   else {
            priceOfTicket = 8;
        }
        System.out.println("Ticket price: $" + priceOfTicket);
        return priceOfTicket;
    }

    // Menu option 3. Statistics
    public static void statistics (int rows, int seats, int ticketsPurchased, int currentIncome, int totalIncome) {

        System.out.println("Number of purchased tickets: " + ticketsPurchased);

        double totalSeats = rows * seats;
        double totalSeatsInPercentage = (ticketsPurchased / totalSeats) * 100;

        System.out.printf("Percentage: %.2f%% %n", totalSeatsInPercentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    // Calculating total Income to display in Menu option 3.
    public static int totalIncome (int rows, int seats) {

        int totalSeats = rows * seats;
        int totalPrice;

        if (totalSeats <= 60) {
            totalPrice = totalSeats * 10;
        }   else {
            int frontHalfRows = rows / 2;
            int remainder = rows % 2;
            int backHalfRows = frontHalfRows + remainder;

            int frontHalfPrice = frontHalfRows * seats * 10;
            int backHalfPrice = backHalfRows * seats * 8;

            totalPrice = frontHalfPrice + backHalfPrice;
        }
        return totalPrice;
    }

}

