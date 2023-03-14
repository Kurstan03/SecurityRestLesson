package peaksoft.dto.converting;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.BookRequest;
import peaksoft.entity.Book;

/**
 * @author kurstan
 * @created at 13.03.2023 16:01
 */
@Component
public class RequestToEntity implements Convert<Book, BookRequest> {
    @Override
    public Book convert(BookRequest request) {
        Book book = new Book();
        book.setName(request.name());
        book.setAuthor(request.author());
        book.setPrice(request.price());
        book.setActive(true);
        return book;
    }
}
