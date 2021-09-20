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
/**
 *
 * 
 */
public class Databse_ConnectorTest {
       Database_Connector db= new Database_Connector();
       public Connection c1;
    public Databse_ConnectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c1=db.getConnection();
    }
   
    @Test
    public void getConnectionTest()
    {
       assertNotNull(c1);
    }

}
