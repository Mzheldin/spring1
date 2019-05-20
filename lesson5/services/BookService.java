package lesson5.services;

import lesson5.entities.Book;
import lesson5.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
}
