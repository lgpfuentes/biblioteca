package biblioteca.biblioteca.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table()
public class Rental {

    @Id
    @SequenceGenerator(name = "rental_sequence", sequenceName = "rental_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Date rentalDate;
    private Date returnDate;
    private Float total;

    @OneToMany
    private List<RentalDetail> rentalDetails;

    public Rental() {
    }

    public Rental(User user, Date rentalDate, Date returnDate, Float total) {
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.total = total;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<RentalDetail> getRentalDetails() {
        return rentalDetails;
    }

    public void setRentalDetails(List<RentalDetail> rentalDetails) {
        this.rentalDetails = rentalDetails;
    }
}
