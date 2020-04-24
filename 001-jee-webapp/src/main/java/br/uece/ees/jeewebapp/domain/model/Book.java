package br.uece.ees.jeewebapp.domain.model;

import java.time.YearMonth;
import java.util.UUID;

import br.uece.ees.jeewebapp.domain.model.common.Entity;

public class Book extends Entity
{

    private final String title;
    private final String author;
    private final String summary;
    private final String releaseDate;

    public Book()
    {
        title       = "";
        author      = "";
        summary     = "";
        releaseDate = "";
    }

    public Book(String title, String author, String summary, String releaseDate) throws IllegalArgumentException
    {
        super();
        this.title       = title;
        this.author      = author;
        this.summary     = summary;
        this.releaseDate = releaseDate;
    }

    public Book(String identity, String title, String author, String summary, String releaseDate) throws IllegalArgumentException
    {
        YearMonth yearMonth = YearMonth.parse(releaseDate);
        if (yearMonth.isAfter(YearMonth.now()) || yearMonth.equals(YearMonth.now()))
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
        this.releaseDate = releaseDate;
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

    public String getReleaseDate()
    {
        return releaseDate;
    }

}
