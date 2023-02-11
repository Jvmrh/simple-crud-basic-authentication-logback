package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_SEQ")
    @SequenceGenerator(sequenceName = "book_sequence", initialValue = 1, allocationSize = 1, name = "book_SEQ")
    @Column()
    private Long bookid;

    @Column(nullable = false)
    private String bookname;

    @Column()
    private String author;

    @Column
    private int price;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname()
    {
        return bookname;
    }

    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
}


