package com.kodilla.library.book;

import com.kodilla.library.copy.Copy;
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
@Table(name = "BOOKS")
public class Book {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "BOOK_ID", unique = true)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "RELEASED")
    private LocalDate releaseDate;

    public Book(String title, String author, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }



    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Copy> copies;
}
