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
import controller.GenerateBillController;
import javafx.event.ActionEvent;
/**
 *
 * 
 */
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void calculationtest() 
    {   
        double monthvalue=0.0; //for jan , feb in db
        double tax=30.0;
        GenerateBillController gt= new GenerateBillController();
        double generatedvalue=gt.Calculation(monthvalue);
        double generatedtax=generatedvalue+30;
        String value1=String.valueOf(tax);
        
        String value2=String.valueOf(generatedtax);
        assertEquals(value2,value1);
             
    }
}
