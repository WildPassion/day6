package by.epam.dedik.day6.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;

    private List<Book> books;

    private Library() {
        books = new ArrayList<Book>();
    }

    public static Library getInstance() {
        instance = instance == null ? new Library() : instance;
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }
}
