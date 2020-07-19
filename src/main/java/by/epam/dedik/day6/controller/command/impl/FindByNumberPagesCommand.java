package by.epam.dedik.day6.controller.command.impl;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;
import by.epam.dedik.day6.controller.Params;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.CustomBook;

import java.util.List;

public class FindByNumberPagesCommand implements BookCommand {
    @Override
    public void execute(BookRequest request, BookResponse response) {
        BookListDao dao = new BookListDaoImpl();
        int numberPages = Integer.parseInt(request.getParameter(Params.NUMBER_PAGES));
        List<CustomBook> books = dao.findByNumberPages(numberPages);
        response.setBooks(books);
    }
}
