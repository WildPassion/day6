package by.epam.dedik.day6.service;

import by.epam.dedik.day6.entity.Book;

import java.util.Comparator;

public enum SortType {
    NAME((first, second) -> first.getName().toLowerCase()
            .compareTo(second.getName().toLowerCase())),
    AUTHOR((first, second) -> first.getAuthors().get(0).toLowerCase()
            .compareTo(second.getAuthors().get(0).toLowerCase())),
    YEAR((first, second) -> Integer.compare(first.getYear(), second.getYear())),
    NUMBER_PAGES((first, second) -> Integer.compare(first.getNumberPages(), second.getNumberPages()));

    private Comparator<Book> comparator;

    SortType(Comparator<Book> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }
}
