package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.converting.RequestToEntity;
import peaksoft.dto.request.BookRequest;
import peaksoft.dto.response.BookResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Book;
import peaksoft.repositories.BookRepository;
import peaksoft.services.BookService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author kurstan
 * @created at 13.03.2023 15:48
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final RequestToEntity requestToEntity;

    public BookServiceImpl(BookRepository bookRepository, RequestToEntity requestToEntity) {
        this.bookRepository = bookRepository;
        this.requestToEntity = requestToEntity;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public SimpleResponse saveBook(BookRequest request) {
        Book book = requestToEntity.convert(request);
        bookRepository.save(book);
        return new SimpleResponse(
                "Saved!",
                String.format("Book - %s is saved", book.getName())
        );
    }

    @Override
    public BookResponse getBookById(Long bookId) {
        return bookRepository.getBookById(bookId).orElseThrow(
                () -> new NoSuchElementException("Book with id " + bookId + " is not found!"));
    }

    @Override
    public BookResponse updateBook(Long bookId, BookRequest request) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                        () -> new NoSuchElementException("Book with id " + bookId + " is not found!"));
        book.setName(request.name());
        book.setAuthor(request.author());
        book.setPrice(request.price());
        return bookRepository.getBookById(bookId).orElseThrow(
                () -> new NoSuchElementException("Book with id " + bookId + " is not found!")
        );
    }

    @Override
    public SimpleResponse deleteBook(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Book with id - " + bookId + " is not found!");
        }
        bookRepository.deleteById(bookId);
        return new SimpleResponse(
                "Deleted!",
                String.format("Book with id - %s is deleted!", bookId)
        );
    }
}
