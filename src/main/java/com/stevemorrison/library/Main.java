package com.stevemorrison.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book b1 = new Book("1984", "George Orwell");
        User user = new User("Alice");

        library.addBook(b1);

        if (library.isBookAvailable(b1) && user.canBorrow()) {
            user.borrowBook(b1);
            System.out.println(user.getName() + " borrowed " + b1.getTitle());
        }
    }
}

