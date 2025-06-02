package com.stevemorrison.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of the library.
 * Responsible for managing borrowed books and enforcing borrowing limits.
 */

public class User {
    private String name;
    private List<Book> borrowedBooks;
    private static final int MAX_BORROW = 3;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_BORROW;
    }

    public void borrowBook(Book book) {
        if (canBorrow()) {
            borrowedBooks.add(book);
            book.issue();
        } else {
            throw new IllegalStateException("User has reached borrowing limit");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returned();
        }
    }
}
