package com.kodilla.library.reader;

import com.kodilla.library.borrow.Borrow;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "READER_ID", unique = true)
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "SIGN_UP_DATE")
    private LocalDate signUpDate;

    public Reader(String firstname, String lastname, LocalDate signUpDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.signUpDate = signUpDate;
    }

    @OneToMany(
            targetEntity = Borrow.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrow> borrows = new ArrayList<>();
}
