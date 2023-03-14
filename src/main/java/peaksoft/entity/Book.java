package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kurstan
 * @created at 13.03.2023 15:02
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_gen",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_gen"
    )
    private Long id;
    private String name;
    private String author;
    private int price;
    private boolean isActive;
}
