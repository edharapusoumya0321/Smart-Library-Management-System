package com.librarymanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 7.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Book ID!");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine().trim();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine().trim();

                    if (id <= 0 || title.isEmpty() || author.isEmpty()) {
                        System.out.println("Please enter valid book details.");
                        break;
                    }

                    Book book = new Book(id, title, author);
                    lib.addBook(book);
                    break;
                }

                case 2:
                    lib.viewBooks();
                    break;

                case 3: {
                    System.out.println("1. Search by Book ID");
                    System.out.println("2. Search by Book Title");
                    System.out.print("Enter search choice: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid search choice!");
                        sc.nextLine();
                        break;
                    }

                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    if (searchChoice == 1) {
                        System.out.print("Enter Book ID: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid Book ID!");
                            sc.nextLine();
                            break;
                        }

                        int searchId = sc.nextInt();
                        sc.nextLine();

                        lib.searchBook(searchId);

                    } else if (searchChoice == 2) {
                        System.out.print("Enter Book Title: ");
                        String searchTitle = sc.nextLine();

                        lib.searchBookByTitle(searchTitle);

                    } else {
                        System.out.println("Invalid search choice!");
                    }

                    break;
                }

                case 4: {
                    System.out.print("Enter Book ID to remove: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Book ID!");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    lib.removeBook(id);
                    break;
                }

                case 5: {
                    System.out.print("Enter Book ID to issue: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Book ID!");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    lib.issueBook(id);
                    break;
                }

                case 6: {
                    System.out.print("Enter Book ID to return: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Book ID!");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    lib.returnBook(id);
                    break;
                }

                case 7:
                    System.out.println(
                        "Thank you for using the Library Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice! Enter a number from 1 to 7."
                    );
            }
        }
    }
}
