package com.stevemorrison.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testBookIssueAndReturn() {
        Book book = new Book("Test Book", "Author");
        assertFalse(book.isIssued());
        book.issue();
        assertTrue(book.isIssued());
        book.returned();
        assertFalse(book.isIssued());
    }

    @Test
    void testUserBorrowingLimit() {
        User user = new User("Test User");
        Book b1 = new Book("A", "Author");
        Book b2 = new Book("B", "Author");
        Book b3 = new Book("C", "Author");
        Book b4 = new Book("D", "Author");

        user.borrowBook(b1);
        user.borrowBook(b2);
        user.borrowBook(b3);

        assertEquals(3, user.getBorrowedBooks().size());
        assertThrows(IllegalStateException.class, () -> user.borrowBook(b4));
    }

    @Test
    void testLibrarySearchAndAvailability() {
        Library library = new Library();
        Book book = new Book("Harry Potter", "J.K. Rowling");
        library.addBook(book);

        assertTrue(library.searchByTitle("Harry").contains(book));
        assertTrue(library.isBookAvailable(book));
        book.issue();
        assertFalse(library.isBookAvailable(book));
    }
}

