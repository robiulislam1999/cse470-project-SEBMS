
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

public class PasswordConfirmationControllerTest {
    Database_Connector db;
    public Connection conn;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String pass;
    String previouspass;
   
    
    public PasswordConfirmationControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
         db= new Database_Connector();
         conn=db.getConnection();
          String query= "Select pass from login where login_id='Admin'";
          pst=conn.prepareStatement(query);
            rs=pst.executeQuery();

            
            while(rs.next())
            {
                previouspass = rs.getString("pass");
                         
            }
       
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ChangePasswordConfirmTest() throws SQLException 
    {       String pass="555";
            conn=db.getConnection();
            String query= "UPDATE `login` SET `pass`=? where login_id='Admin'";

            pst=conn.prepareStatement(query);
            pst.setString(1, pass);
            pst.execute();
            String sql= "Select pass from login where login_id='Admin'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            String currentpass="";
            
            while(rs.next())
            {
                currentpass = rs.getString("pass");
                         
            }
           
           assertEquals(pass,currentpass);
            
           
            
    }
}
