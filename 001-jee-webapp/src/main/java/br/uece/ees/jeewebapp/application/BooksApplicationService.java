package br.uece.ees.jeewebapp.application;

import java.util.Collection;
import br.uece.ees.jeewebapp.domain.model.Book;
import br.uece.ees.jeewebapp.domain.model.BooksRepository;

public class BooksApplicationService
{

    private final BooksRepository booksRepository;

    public BooksApplicationService(BooksRepository repository)
    {
        booksRepository = repository;
    }

    public void newBook(Book aBook)
    {
        this.booksRepository().add(aBook);
    }

    public void editBook(Book aBook)
    {
        this.booksRepository().add(aBook);
    }

    public Collection<Book> allBooks()
    {
        return this.booksRepository().allBooks();
    }

    public Book requestBook(String id)
    {
        return this.booksRepository().bookOf(id);
    }

    public void removeBook(String id)
    {
        this.booksRepository().remove(id);
    }

    private BooksRepository booksRepository()
    {
        return booksRepository;
    }

}
