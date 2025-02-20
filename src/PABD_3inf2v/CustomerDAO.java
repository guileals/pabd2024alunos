/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PABD_3inf2v;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1886519
 */
public class CustomerDAO {

    private Connection con;

    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Connection OK!");
    }

    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer"
                + " (store_id, first_name, last_name, email, address_id, active)"
                + " values"
                + " (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());

        pst.execute();
        pst.close();
        System.out.println("Customer ADDED!");
    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customer "
                + "where customer_id=?";
    }

    public void updateCustomer(int id) throws SQLException {
        String sql = "update customer "
                + "set store_id=?, first_name=?, last_name=?, email=?, address_id=?, active=? "
                + "where customer_id=?";
    }

    public void showCustomers() throws SQLException {
        Statement st = con.createStatement();

        String query = "select * from customer"
                + " order by customer_id desc"
                + " limit 5";

        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();

        System.out.println("Tabela: " + md.getTableName(1));
        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println("");
        }

        st.close();
    }

    public List<Customer> getCustomers() throws SQLException {
        List<Customer> lista
                = new ArrayList<Customer>();

        Statement st = con.createStatement();

        String query = "select * from customer"
                + " order by customer_id desc";

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Customer(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getTimestamp(8),
                    rs.getTimestamp(9)
            ));
        }

        return lista;
    }

}
