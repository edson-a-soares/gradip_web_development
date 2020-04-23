package br.uece.ees.jpaapp.domain.model;

import java.time.Year;
import java.util.UUID;
import br.uece.ees.jpaapp.domain.model.common.Entity;

public class Book extends Entity
{

    private final String title;
    private final String author;
    private final String summary;
    private final String releaseYear;

    public Book()
    {
        title       = "";
        author      = "";
        summary     = "";
        releaseYear = "";
    }

    public Book(String title, String author, String summary, String releaseYear) throws IllegalArgumentException
    {
        super();
        this.title       = title;
        this.author      = author;
        this.summary     = summary;
        this.releaseYear = releaseYear;
    }

    public Book(String identity, String title, String author, String summary, String releaseYear) throws IllegalArgumentException
    {
        Year year = Year.parse(releaseYear);
        if (year.isAfter(Year.now()) || year.equals(Year.now()))
            throw new IllegalArgumentException("");

        if (title.isEmpty() || title.length() > 125)
            throw new IllegalArgumentException("");

        if (author.isEmpty() || author.length() > 50)
            throw new IllegalArgumentException("");

        if (UUID.fromString(identity).toString().isEmpty() || identity.length() != 36)
            throw new IllegalArgumentException("");

        super.setIdentity(identity);
        this.title       = title;
        this.author      = author;
        this.summary     = summary;
        this.releaseYear = releaseYear;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getSummary()
    {
        return summary;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

}
