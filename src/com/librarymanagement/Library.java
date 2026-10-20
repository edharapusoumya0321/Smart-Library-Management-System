package com.librarymanagement;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> b = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {

        for (Book existingBook : b) {
            if (existingBook.getBookId() == book.getBookId()) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        b.add(book);
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void viewBooks() {

        if (b.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : b) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + book.isAvailable());
            System.out.println("--------------------");
        }
    }

    // Search for a book by ID
    public void searchBook(int id) {

        for (Book book : b) {
            if (book.getBookId() == id) {
                System.out.println("Book found!");
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available: " + book.isAvailable());
                return;
            }
        }

        System.out.println("Book not found.");
    }
    

    // Search for a book by title
    public void searchBookByTitle(String title) {

        for (Book book : b) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found!");
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available: " + book.isAvailable());
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Remove a book by ID
    public void removeBook(int id) {

        for (Book book : b) {
            if (book.getBookId() == id) {
                b.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Issue a book
    public void issueBook(int id) {

        for (Book book : b) {
            if (book.getBookId() == id) {

                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(int id) {

        for (Book book : b) {
            if (book.getBookId() == id) {

                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}
