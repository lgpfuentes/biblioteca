package biblioteca.biblioteca.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id;
    private String isbn, title;
    private Date publishYear;

    @ManyToMany(mappedBy = "books")
    private Set<Category> categories;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    public Book(){}
    public Book(String isbn, String title, Date publishYear){
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    

}
