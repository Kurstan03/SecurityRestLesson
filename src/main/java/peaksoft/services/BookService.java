package peaksoft.services;

import peaksoft.dto.request.BookRequest;
import peaksoft.dto.response.BookResponse;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

/**
 * @author kurstan
 * @created at 13.03.2023 15:48
 */
public interface BookService {
    List<BookResponse> getAllBooks();
    SimpleResponse saveBook(BookRequest request);
    BookResponse updateBook(Long bookId, BookRequest request);
    SimpleResponse deleteBook(Long bookId);
    BookResponse getBookById(Long bookId);
}
