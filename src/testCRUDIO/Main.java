package testCRUDIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:/Split/emp_data2.txt");
		File file2 = new File("D:/Split/emp_data3.txt");
		Scanner strInput = new Scanner(System.in);
		String choice,cont = "y";        
        Crud crud = new Crud(file);
        while( cont.equalsIgnoreCase("y") ) {        	
        	   System.out.println("\t\t Employee Information System\n\n");
        
	        System.out.println("1 ===> Add  ");
	        System.out.println("2 ===> Show ");	
	        System.out.println("3 ===> Delete ");
	        System.out.println("4 ===> Search ");
	        System.out.println("5 ===> Update ");
	        System.out.println("6 ===> Show data with database ");
	        System.out.println("7 ===> Show data with Thread ");
	    
	        System.out.print("\n\n");
	        System.out.println("Pilih: ");
	        choice = strInput.nextLine();
	        
	        if( choice.equals("1") ) {
	        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        	System.out.print("Enter the Employee ID: ");
	    		String id = strInput.nextLine();
	    		System.out.print("Enter the Employee Name: ");
	    		String name = strInput.nextLine();
	    		System.out.print("Enter the Employee Job: ");
	    		String job = strInput.nextLine();
	    		System.out.print("Enter the Employee Address: ");
	    		String addr = strInput.nextLine();
	        	crud.AddRecord(id, name, job, addr);
	        } else if( choice.equals("2") ) {
	        		crud.ViewAllRecord();
	        } else if( choice.equals("3") ) {
	        		crud.DeleteRecordByID();
	        }	else if( choice.equals("4") ) {
	        		crud.SearchRecordbyID();
	        }	else if( choice.equals("5") ) {
	        		crud.updateRecordbyID();
	        } else if(choice.equals("6")) {
	        	
	        	crud.viewDataDatabase("employee_id","first_name","last_name","email","phone_number","hire_date","job_id","salary",
	        			"commission_pct","manager_id","department_id");
	        } else if(choice.equals("7")) {
	        	FileReader fileReader =  new FileReader(file);
	        	BufferedReader br = new BufferedReader(fileReader);
	        	String employeeData;
	        	Rel relKereta = new Rel();
	    		Crud ka1 = new Crud(file);
	    		Crud ka2 = new Crud(file);
	    		Crud ka3 = new Crud(file);
	    		Crud ka4 = new Crud(file);
	    		
	    		ka1.start();
	    		ka2.start();
	    		ka3.start();
	    		ka4.start();
	        }
		        	
	        System.out.println("Do you want to continue? Y/N");
	        cont = strInput.nextLine();
	       	
        }
	}

}
