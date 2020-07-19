package by.epam.dedik.day6.controller;

import by.epam.dedik.day6.entity.CustomBook;
import by.epam.dedik.day6.service.BookConverterService;
import by.epam.dedik.day6.service.SortType;

public class BookRequest {
    private static final String EMPTY = "";
    private int year;
    private int numberPages;
    private CustomBook book;
    private String name;
    private String author;
    private SortType sortType;
    private String command;

    public String getParameter(Params params) {
        String parameter;
        switch (params) {
            case BOOK: {
                parameter = book == null ? EMPTY : BookConverterService.toJson(book);
                break;
            }
            case NAME: {
                parameter = name == null ? EMPTY : name;
                break;
            }
            case AUTHOR: {
                parameter = author == null ? EMPTY : author;
                break;
            }
            case YEAR: {
                parameter = String.valueOf(year);
                break;
            }
            case NUMBER_PAGES: {
                parameter = String.valueOf(numberPages);
                break;
            }
            case SORT_TYPE: {
                parameter = String.valueOf(sortType);
                break;
            }
            case COMMAND: {
                parameter = command;
                break;
            }
            default:
                parameter = EMPTY;
        }
        return parameter;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBook(CustomBook book) {
        this.book = book;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
