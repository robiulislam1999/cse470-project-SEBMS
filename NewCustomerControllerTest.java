/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Database_Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * 
 */
public class NewCustomerControllerTest {
    Database_Connector db;
    public Connection conn;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int id=0000;
    public NewCustomerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        id=1000; //this id is for insrting.
        db= new Database_Connector();
        conn=db.getConnection();
        pst = conn.prepareStatement("INSERT INTO `customer`(`name`, `email`, `address`, `gender`, `contact`, `age`, `pin`, `meter`,`id`) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(4, "GenderOption");
            pst.setString(1, "NAME");
            pst.setString(2, "name@something.com");
            pst.setString(3, "address");
            pst.setInt(5, 123456);
            pst.setInt(6, 00);
            pst.setInt(7, 0000);
            pst.setInt(8, 0000);
            pst.setInt(9, id);
            pst.executeUpdate();
    }
    @After
    public void tearDown() throws SQLException {
        String query= "Delete from customer where id=0;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        conn.close();
         
    }
  
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertingIDtest() throws SQLException
    {   //checking if iniserting works with only id it can be same said for name and other values.
         id=1000; //checking value change this for checking
         int idcheck=0;
         conn=db.getConnection();
         String sql="SELECT * from customer where id=0";
         Statement stmt = conn.createStatement();
         rs=stmt.executeQuery(sql);
         while(rs.next())
         {
             idcheck=rs.getInt(1);
         }
         assertEquals(id,idcheck);
    }
}
