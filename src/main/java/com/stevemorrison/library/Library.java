package com.stevemorrison.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the library catalog.
 * Responsible for managing the collection of books and providing search & availability functions.
 */

public class Library {
    private List<Book> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    /**
     * Searches the catalog for books with a title containing the given string.
     * @param title The title (or partial title) to search for.
     * @return A list of matching books.
     */

    public List<Book> searchByTitle(String title) {
        return catalog.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean isBookAvailable(Book book) {
        return catalog.contains(book) && !book.isIssued();
    }
}

