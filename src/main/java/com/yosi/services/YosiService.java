package com.yosi.services;

import com.yosi.model.Client;
import org.hibernate.Hibernate;

import java.util.List;

public class YosiService {

    private AbstractDAO<Client> yosiDAO;

    public YosiService(AbstractDAO<Client> abstractDAO) {
        this.yosiDAO = abstractDAO;
        System.out.println("wywołanie");
    }

    public void save(Client entity){
        yosiDAO.save(entity);
    }
    public void update(Client entity){
        yosiDAO.update(entity);
    }
    public void delete(Client entity){
        yosiDAO.delete(entity);
    }
    public List<Client> findAll(){
        List<Client> clients = yosiDAO.findAll();
        for(Client client : clients){
            Hibernate.initialize(client.getOrderAddress());
            Hibernate.initialize(client.getShipments());
        }
        return clients;
    }
    public Client getEntity(int id) {
        Client client = yosiDAO.getEntity(id);
        Hibernate.initialize(client.getOrderAddress());
        Hibernate.initialize(client.getShipments());
        return client;
    }

}
