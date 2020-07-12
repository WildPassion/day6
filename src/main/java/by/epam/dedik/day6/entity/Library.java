package by.epam.dedik.day6.entity;

import java.util.List;

public class Library {
    private static Library instance;

    private List<Book> books;

    private Library() {
    }

    public static Library getInstance() {
        return instance == null ? new Library() : instance;
    }

    public List<Book> getBooks() {
        return books;
    }
}
