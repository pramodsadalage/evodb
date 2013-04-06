package com.thoughtworks.util;

import com.thoughtworks.domain.DomainObject;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static org.hibernate.classic.Session session;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.getCurrentSession();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void saveDomainObject(DomainObject object) {
        openSessionIfClosed();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public static void updateDomainObject(DomainObject object) {
        openSessionIfClosed();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    public static void removeDomainObject(DomainObject object) {
        openSessionIfClosed();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    private static void openSessionIfClosed() {
        if (!session.isOpen())
            session = getSessionFactory().getCurrentSession();
    }

    public static DomainObject load(DomainObject domainObj, Long id) {
        return get(domainObj, id);
    }

    public static DomainObject get(DomainObject domainObj, Long id) {
        openSessionIfClosed();
        session.beginTransaction();
        domainObj = (DomainObject) session.get(domainObj.getClass(), id);
        session.getTransaction().commit();
        return domainObj;
    }
}