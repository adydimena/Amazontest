
package com.example.ady.amazontest;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookList implements Serializable
{

    @SerializedName("Books")
    @Expose
    private List<Book> books = null;
    private final static long serialVersionUID = -5094842312680056379L;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
