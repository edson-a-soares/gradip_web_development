package br.uece.ees.jpaapp.domain.model;

import java.util.Collection;

public interface BooksRepository
{

    public void add(Book book);
    public void remove(String id);
    public Book bookOf(String id);
    public Collection<Book> allBooks();

}
