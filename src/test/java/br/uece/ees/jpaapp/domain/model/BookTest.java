package br.uece.ees.jpaapp.domain.model;

import java.time.Year;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testIfBookIsTheSame() throws Exception {

        Book firstBook  = new Book("Can't Hurt Me", "David Goggins", "", "2018");
        Book secondBook = new Book("Can't Hurt Me", "David Goggins", "", "2018");
        assertEquals(firstBook, secondBook);

    }

    @Test
    public void testIfBookIsNew() throws Exception {

        Book aBook = new Book("Can't Hurt Me", "David Goggins", "", "2018");
        assertEquals("-1", aBook.getIdentity());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithInvalidID() throws Exception {

        new Book(UUID.randomUUID().toString().replaceAll("-", ""),
            "The Omen",
            "David Seltzer",
            "",
            "2006"
        );

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithInvalidReleaseYear() throws Exception {

        Book aBook = new Book(
            UUID.randomUUID().toString(),
            "Extreme Ownership",
            "Jocko Willink",
            "",
            Year.now().toString()
        );

    }

}
