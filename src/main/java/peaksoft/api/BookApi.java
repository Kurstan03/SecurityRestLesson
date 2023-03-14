package peaksoft.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.BookRequest;
import peaksoft.dto.response.BookResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.services.BookService;

import java.util.List;

/**
 * @author kurstan
 * @created at 13.03.2023 15:05
 */
@RestController
@RequestMapping("/api/books")
public class BookApi {
    private final BookService bookService;
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'CUSTOMER')")
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public SimpleResponse saveBook(@RequestBody BookRequest request){
       return bookService.saveBook(request);
    }
    @GetMapping("/{bookId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'CUSTOMER')")
    public BookResponse getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }
    @PutMapping("/{bookId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR')")
    public BookResponse updateBook(
            @PathVariable Long bookId,
            @RequestBody BookRequest request){
        return bookService.updateBook(bookId, request);
    }
    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR')")
    public SimpleResponse deleteBook(@PathVariable Long bookId){
        return bookService.deleteBook(bookId);
    }
}
