/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PABD_3inf2v;

import java.sql.*;

/**
 *
 * @author 1886519
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Customer c = new Customer(1, "Dimitri", "Tolstoi", "d.tolstoi@gmail.com", 10, 1);
    
        CustomerDAO dao = new CustomerDAO();
        
//        dao.insertCustomer(c);
//        dao.updateCustomer(615);
//        dao.deleteCustomer(612);
//        dao.showCustomers();
        System.out.println(dao.getCustomers());

    }

}
