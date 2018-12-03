package simple_dao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IDAOFactory {
    CarDao getCarDao ();
    ClientDao getClientDao ();
}
