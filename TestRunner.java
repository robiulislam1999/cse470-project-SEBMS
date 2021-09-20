/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 *
 */
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;	
public class TestRunner {
    public static void main(String[]args)
    {
        Result result=JUnitCore.runClasses(LoginControllerTest.class);
        for (Failure failure : result.getFailures())
                {
                    System.out.println(failure.toString());
                }
         System.out.println("Result=="+result.wasSuccessful());
        
          result=JUnitCore.runClasses(CustomerDetailsControllerTest.class);
        for (Failure failure : result.getFailures())
                {
                    System.out.println(failure.toString());
                }
         System.out.println("Result=="+result.wasSuccessful());
         
          result=JUnitCore.runClasses(NewCustomerControllerTest.class);
        for (Failure failure : result.getFailures())
                {
                    System.out.println(failure.toString());
                }
         System.out.println("Result=="+result.wasSuccessful());
           result=JUnitCore.runClasses(PasswordConfirmationControllerTest.class);
        for (Failure failure : result.getFailures())
                {
                    System.out.println(failure.toString());
                }
         System.out.println("Result=="+result.wasSuccessful());
         
    }
}
