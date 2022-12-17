package com.kodilla.library.copy;

import com.kodilla.library.book.Book;
import com.kodilla.library.borrow.Borrow;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "COPIES")
public class Copy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "COPY_ID", unique = true)
    private Long id;
    @Column(name = "STATUS")
    private String status;


    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;


    @OneToOne
    @JoinColumn(name = "BORROW_ID")
    @Transient
    private Borrow borrow;

    public Copy(String status, Book book) {
        this.status = status;
        this.book = book;
    }
}
