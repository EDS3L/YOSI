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
        return session;
    }

    private Session openSessionWithTransition() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    private void closeSession() {
        if(session != null) session.close();
    }

    private void closeSessionWithTransition() {
        if(transaction != null) transaction.commit();
        closeSession();
    }


    @Override
    public void save(Client entity) {
        openSessionWithTransition().save(entity);
        closeSessionWithTransition();
    }

    @Override
    public void update(Client entity) {
        openSessionWithTransition().update(entity);
        closeSessionWithTransition();
    }

    @Override
    public void delete(Client entity) {
        openSessionWithTransition().delete(entity);
        closeSessionWithTransition();
    }

    @Override
    public List<Client> findAll() {
        List<Client> list = (List<Client>) openSession().createQuery("From Client").list();
        closeSession();
        return list;
    }

    @Override
    public Client getEntity(int id) {
        Client clint = (Client) openSession().get(Client.class,id);
        closeSession();
        return clint;
    }
}
