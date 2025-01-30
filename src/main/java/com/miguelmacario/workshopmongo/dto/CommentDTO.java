package com.miguelmacario.workshopmongo.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private LocalDate date;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String text, AuthorDTO author, LocalDate date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
