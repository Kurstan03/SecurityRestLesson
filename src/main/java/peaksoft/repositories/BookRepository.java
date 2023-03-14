package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.BookResponse;
import peaksoft.entity.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author kurstan
 * @created at 13.03.2023 15:45
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select new peaksoft.dto.response.BookResponse(b.id, b.name, b.author, b.price, b.isActive) from Book b")
    List<BookResponse> getAllBooks();

    Optional<BookResponse> getBookById(Long bookId);
}
