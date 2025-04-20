package com.ps;
import java.util.Scanner;

public class NeighborhoodLibrary {
    static Book[] books = new Book[20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n Welcome to the Neighborhood Library.");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    showCheckedOutBooks(scanner);
                    break;
                case "3":
                    running = false;
                    System.out.println("Thank you, Please come again.");
                    break;
                default:
                    System.out.println("Invalid, try again. ");
            }
        }
    }

    public static void initializeBooks() {
         books[0] = new Book(1, "ISBN-0001", "The House on Mango Street");
        books[1] = new Book(2, "ISBN-0002", "Never Let Me Go");
        books[2] = new Book(3, "ISBN-0003", "It Starts with Us");
        books[3] = new Book(4, "ISBN-0004", "Daisy Jones & The Six");
        books[4] = new Book(5, "ISBN-0005", "Say You'll Remember Me");
        books[5] = new Book(6, "ISBN-0006", "Fearless");
        books[6] = new Book(7, "ISBN-0007", "Sunrise on the Reaping");
        books[7] = new Book(8, "ISBN-0008", "The Vale");
        books[8] = new Book(9, "ISBN-0009", "Great Big Beautiful Life");
        books[9] = new Book(10, "ISBN-0010", "The Perfect Divorce");
        books[10] = new Book(11, "ISBN-0011", "Name");
        books[11] = new Book(12, "ISBN-0012", "James");
        books[12] = new Book(13, "ISBN-0013", "Holly");
        books[13] = new Book(14, "ISBN-0014", "The Let Them Theory");
        books[14] = new Book(15, "ISBN-0015", "Atomic Habits");
        books[15] = new Book(16, "ISBN-0016", "Playing with Reality");
        books[16] = new Book(17, "ISBN-0017", "On the Edge");
        books[17] = new Book(18, "ISBN-0018", "The Secret Life of the Universe");
        books[18] = new Book(19, "ISBN-0019", "By the Fire We Carry");
        books[19] = new Book(20, "ISBN-0020", "The Heart That Fed");
    }

    public static void showAvailableBooks(Scanner scanner) {
        System.out.println("\n Available Books ");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
            }
        }

        System.out.print("Enter the ID of the book to check out (0 to go back: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id == 0) return;

        Book bookToCheckout = findBookById(id);
        if (bookToCheckout != null && !bookToCheckout.isCheckedOut()) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            bookToCheckout.checkOut(name);
            System.out.println("Book checked out to " + name + "!");
        } else {
            System.out.println("Book is not available or Invalid ID.");
        }
    }


}