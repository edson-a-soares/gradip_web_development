package br.uece.ees.jpaapp.infrastructure.persistence;

import java.util.Collection;
import org.hibernate.Session;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import javax.persistence.NoResultException;
import br.uece.ees.jpaapp.domain.model.Book;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import br.uece.ees.jpaapp.domain.model.BooksRepository;
import br.uece.ees.jpaapp.infrastructure.persistence.common.AbstractHibernateSession;

public class HibernateBooksRepository
        extends AbstractHibernateSession
        implements BooksRepository
{

    private static final Logger logger = Logger.getLogger(HibernateBooksRepository.class.getName());

    @Override
    public void add(Book aBook)
    {
        try (Session session = this.session()) {

            session.beginTransaction();
            session.saveOrUpdate(aBook);
            session.getTransaction().commit();

        } catch (HibernateException exception) {
            logger.log(Level.SEVERE,"HibernateException: ", exception);
        }
    }

    @Override
    public void remove(String id)
    {
        try (Session session = this.session()) {

            Book aBook = (Book) session.get(Book.class, id);
            if (aBook != null) {
                session.beginTransaction();
                session.remove(aBook);
                session.getTransaction().commit();
            }

        } catch (HibernateException exception) {
            logger.log(Level.SEVERE,"HibernateException: ", exception);
        }
    }

    @Override
    public Book bookOf(String id)
    {
        Book aBook = null;
        try (Session session = this.session()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Book> bookRoot = criteriaQuery.from(Book.class);

            criteriaQuery.where(criteriaBuilder.equal(bookRoot.get("identity"), id));
            aBook = session.createQuery(criteriaQuery).getSingleResult();

        } catch (NoResultException ignored) {
        } catch (HibernateException exception) {
            logger.log(Level.SEVERE, "HibernateException: ", exception);
        }

        return aBook;
    }

    @Override
    public Collection<Book> allBooks()
    {
        Collection<Book> aCollection = null;
        try (Session session = this.session()) {

            CriteriaQuery<Book> criteriaQuery = session
                .getCriteriaBuilder()
                .createQuery(Book.class);

            criteriaQuery.from(Book.class);
            aCollection = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException exception) {
            logger.log(Level.SEVERE, "HibernateException: ", exception);
        }

        return aCollection;
    }

}
