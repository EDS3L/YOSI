package com.yosi.services;

import com.yosi.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class YosiDAODB implements AbstractDAO<Client> {

    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    private SessionFactory getSessionFactory() {

        try {


            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            MetadataSources sources = new MetadataSources(registry);

            Metadata metadata = sources.getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            e.printStackTrace();
            if(sessionFactory != null) StandardServiceRegistryBuilder.destroy(registry);
        }


        return sessionFactory;
    }

    private Session openSession() {
        if(sessionFactory == null) sessionFactory = getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("Session Opened");
        return session;
    }

    private Session openSessionWithTransition() {
        session = openSession();
        transaction = session.beginTransaction();
        System.out.println("sesja otworzona z transition");
        return session;
    }

    private void closeSession() {
        if(session != null) session.close();
        System.out.println("zamknięcie sesji");
    }

    private void closeSessionWithTransition() {
        try {
            if (transaction != null) {
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession();
            System.out.println("zamknięcie sesji z tranzykcją");
        }
    }


    @Override
    public void save(Client entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Client entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> findAll() {
        try (Session session = openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        }
    }

    @Override
    public Client getEntity(int id) {
        try (Session session = openSession()) {
            return session.get(Client.class, id);
        }
    }
}
