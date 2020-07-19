package epam.dedik.day6.controller.command;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.controller.command.impl.AddBookCommand;
import by.epam.dedik.day6.entity.CustomBook;
import epam.dedik.day6.data.DataTransfer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddBookCommandTest {
    private BookCommand bookCommand;

    @BeforeClass
    private void setBookCommand() {
        bookCommand = new AddBookCommand();
    }

    @Test(dataProvider = "getValidBook", dataProviderClass = DataTransfer.class)
    public void execute_book_libraryWithBook(CustomBook book) {
        BookRequest request = new BookRequest();
        request.setBook(book);
    }
}
