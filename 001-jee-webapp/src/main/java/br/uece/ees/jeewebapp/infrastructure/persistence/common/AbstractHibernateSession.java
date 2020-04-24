package br.uece.ees.jeewebapp.infrastructure.persistence.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AbstractHibernateSession
{

    private Session _session;
    private final SessionFactory sessionFactory;

    protected AbstractHibernateSession() {
        super();
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    protected Session session()
    {
        Session actualSession = this._session;
        if (actualSession == null) {
            if (this.sessionFactory == null) {
                throw new IllegalStateException("Requires either a Session or a Session Provider.");
            }

            actualSession = this.sessionFactory.openSession();
        }

        return actualSession;
    }

    protected void set_session(Session aSession) {
        this._session = aSession;
    }

}
