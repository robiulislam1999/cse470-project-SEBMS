package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Database_Connector;

public class LoginControllerTest {
   public Connection con;
   LoginController l ;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Database_Connector db;
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebms","root", "");
        db=new Database_Connector();
        con=db.getConnection();
        
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public void testsignin_email() throws SQLException
    {
     String mailid="";
     String passw="";
     
       String email="robiul@gmail.com";
      String pass="555";
     String query= "Select login_id, pass from login where login_id=? and pass=?";

            pst=con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            rs=pst.executeQuery();

            
            while(rs.next()){
                mailid = rs.getString("login_id");
                passw= rs.getString("pass");
            }
            assertEquals(mailid,email);
            
     
    }
    @Test
    public void tetingsingin_pass() throws SQLException
    {
         String mailid="";
     String passw="";
     
       String email="robiul@gmail.com";
      String pass="555";
     String query= "Select login_id, pass from login where login_id=? and pass=?";

            pst=con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            rs=pst.executeQuery();

            
            while(rs.next()){
                mailid = rs.getString("login_id");
                passw= rs.getString("pass");
            }
        assertEquals(passw,pass);
    }
    
}
