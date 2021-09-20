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
public class CustomerDetailsControllerTest {
    public Connection conn;
    ResultSet rs;
    Database_Connector db;
    String email;
    String name;
    PreparedStatement pst;
    PreparedStatement pst1;
    public CustomerDetailsControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        db=new Database_Connector();
       conn=db.getConnection();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void GenerateInfoTest() throws SQLException 
    {
        //by showing with 1 varibale we can validate the method is working
        email="hasan@gmail.com";//to get information about the client
     
        String sql= "Select * from customer where email=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,email);
            rs=pst.executeQuery();
           
        while(rs.next())
        {
            name=rs.getString(2);
            
        }
        
    String namecheck="Hasan" ; //"Asif"; //"Akbar"    // change varabile here to validate info.
    assertEquals(namecheck,name);
    pst.close();
    rs.close();
    }
    @Test 
        public void UpdateUnitMethodTest() throws SQLException
        {
        String value="";
        
        String month="jan"; //i.e "jan",feb,mar,apr,may,june,july,aug,sep,oct,nov,dec MONTH SELECT
        String email="hasan@gmail.com"; //KEY SEARCH FOR THE TABLE
         double number=50.0;  // UPDATE UNIT NUMBER IN DOUBLE FORMAT HERE TO CHECK AND UPDATE
        String numbers= String.valueOf(number);
        String sql="UPDATE `customer` SET `"+ month + "`=? where email=?";
        pst=conn.prepareStatement(sql);
        pst.setDouble(1, number);
        pst.setString(2,email);
        pst.execute();
        pst.close();
        String sql1= "SELECT "+month+" From customer where email=?";
        pst1=conn.prepareStatement(sql1);
        
        pst1.setString(1,email);
        rs=pst1.executeQuery();
         while(rs.next())
         {
             value=rs.getString(month);
         } 
         System.out.println(value);
         System.out.println(numbers);
         //numbers="60.0"; //if want to show fail
         assertEquals(numbers,value);
        }
        
        
        
}
