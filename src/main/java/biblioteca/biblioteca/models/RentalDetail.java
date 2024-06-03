package biblioteca.biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class RentalDetail {

    @Id
    @SequenceGenerator(name = "rental_detail_sequence", sequenceName = "rental_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_detail_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private Float subtotal;

    public RentalDetail() {
    }

    public RentalDetail(Rental rental, Book book, Float subtotal) {
        this.rental = rental;
        this.book = book;
        this.subtotal = subtotal;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }
}
