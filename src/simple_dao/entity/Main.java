package simple_dao.entity;

import simple_dao.dao.CarDao;
import simple_dao.dao.ClientDao;
import simple_dao.dao.DAOFactory;
import simple_dao.dao.IDAOFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        CarDao carDao = factory.getCarDao();

        ClientDao clientDao = factory.getClientDao();

     /*   Car car = new Car();
        car.setMark("Audi");
        car.setModel("A8");
        car.setPrice(150000);

        carDao.add(car); */

     /*  List<Car> cars = carDao.getAll();

        for (Car car:cars) {
            System.out.println(car.getId()+" "+ car.getMark()
            +" "+car.getModel()+" "+car.getPrice());

        }*/

       /* Client client = new Client();
        client.setName("Randy");
        client.setAge(55);
        client.setPhone("77722333");


        clientDao.add(client); */

        List<Client> clients = clientDao.getAll();

        for (Client client : clients ){
            System.out.println(client.getId()+" "+client.getName()+" "
            +client.getAge()+" "+client.getPhone());


        }


        }

    }

