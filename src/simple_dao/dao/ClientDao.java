package simple_dao.dao;

import simple_dao.entity.Client;

import java.util.List;

public interface ClientDao {

    void add(Client client);

    List<Client> getAll();

    Client getById(int id);
}
