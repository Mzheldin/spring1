package lesson5.controllers;

import lesson5.entities.Book;
import lesson5.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/showAll")
    public String showAll(Model uiModel){
        uiModel.addAttribute("books", bookService.getAll());
        return "books";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model uiModel){
        Book book = new Book();
        uiModel.addAttribute("book", book);
        return "bookAdd";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String showAddForm(Book book){
        bookService.addBook(book);
        return "redirect:/book/showAll";
    }

    @RequestMapping("/test")
    public String test(Model uiModel){
        return "index";
    }

}
