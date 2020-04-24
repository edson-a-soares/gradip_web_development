package br.uece.ees.jeewebapp.domain.model;

import java.util.UUID;
import org.junit.Test;
import java.time.YearMonth;
import static org.junit.Assert.assertEquals;

public class BookTest
{

    @Test
    public void testIfBookIsTheSame() throws Exception
    {
        Book firstBook  = new Book("Can't Hurt Me", "David Goggins", "", "2018-01");
        Book secondBook = new Book("Can't Hurt Me", "David Goggins", "", "2018-02");
        assertEquals(firstBook, secondBook);
    }

    @Test
    public void testIfBookIsNew() throws Exception
    {
        Book aBook = new Book("Can't Hurt Me", "David Goggins", "", "2018-01");
        assertEquals("-1", aBook.getIdentity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithInvalidID() throws Exception
    {
        new Book(UUID.randomUUID().toString().replaceAll("-", ""),
            "The Omen",
            "David Seltzer",
            "",
            "2006-01"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithInvalidReleaseYear() throws Exception
    {
        Book aBook = new Book(
            UUID.randomUUID().toString(),
            "Extreme Ownership",
            "Jocko Willink",
            "",
            YearMonth.now().toString()
        );
    }

}
