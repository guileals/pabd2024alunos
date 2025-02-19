/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PABD_3inf1v;

import java.sql.*;

/**
 *
 * @author 1886519
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
//    cd "CAMINHO_PROJETO"
//    git add .
//    git commit -m "MENSAGEM"
//    git push -u origin main
    
    public static void main(String[] args) throws SQLException {

        Customer c = new Customer(1, "Dalai", "Lama", "dalai@microsoft.com", 10, 1);
        
        CustomerDAO dao = new CustomerDAO();
        
//        dao.insertCustomer(c);
//        dao.updateCustomer(611);
//        dao.deleteCustomer(610);
//        dao.showCustomers();
        System.out.println(dao.getCustomers());
        
    }

}
