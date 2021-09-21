
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.GenerateBillController;
import javafx.event.ActionEvent;

public class GenerateBillControllerTest {
    
    public GenerateBillControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void calculationtest() 
    {   
        double monthvalue=0.0; 
        double tax=30.0;
        GenerateBillController gt= new GenerateBillController();
        double generatedvalue=gt.Calculation(monthvalue);
        double generatedtax=generatedvalue+30;
        String value1=String.valueOf(tax);
        
        String value2=String.valueOf(generatedtax);
        assertEquals(value2,value1);
             
    }
}
