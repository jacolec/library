package com.kodilla.library.borrow;

import com.kodilla.library.copy.Copy;
import com.kodilla.library.reader.Reader;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "BORROWS")
public class Borrow {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "BORROW_ID", unique = true)
    private Long id;
    @Column(name = "DATE_OF_BORROW")
    private LocalDate borrowDate;
    @Column(name = "DATE_OF_RETURN")
    private LocalDate returnDate;

    public Borrow(LocalDate borrowDate, LocalDate returnDate) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;


    @OneToOne
    @JoinColumn(name = "COPY_ID")
    private Copy copy;
}
