package testCRUDIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import testCRUDIO.Database;
import testCRUDIO.Employee;

public class Crud extends Thread{
	private File file;
	private File file2;
	private String id;
	private String name;
	private String job;
	private String addr;
	private Rel rel;
	
	public Crud(File file){
	
		this.file = file;
		//this.rel =rel;
	}
	
	public boolean AddRecord(String id, String name, String job, String addr) throws IOException {
		try {
		FileWriter fileWriter = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
			   		
		String data=id+","+name+","+job+","+addr;
		bw.append(data);
		bw.flush();
		bw.newLine();
		bw.close();		
		}catch (Exception e) {
			return false;
		}
		return true;
}
	public void ViewAllRecord() throws IOException {
		
		try {
		FileReader fileReader =  new FileReader(file);
    	BufferedReader br = new BufferedReader(fileReader);
    	String employeeData;
    	while ((employeeData = br.readLine()) != null) {
			String[] data = employeeData.split(",");
			System.out.println("id 	   :"+data[0] + " ");
			System.out.println("nama   :"+data[1] + " ");
			System.out.println("job    :"+data[2] + " ");
			System.out.println("alamat :"+data[3] + " ");
		}
		br.close();	
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
    }
	
	public void DeleteRecordByID() throws IOException {
		Scanner strInput =  new Scanner(System.in);
		String id, record;
		
		
		File tempDB = new File("D:/Split/emp_data2baru.txt");
		File db = new File("D:/Split/emp_data2.txt");
		
		
		BufferedReader br = new BufferedReader( new FileReader( db ) );
		BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );
		
		System.out.println("Enter the Employee ID: ");
		id =  strInput.nextLine();
		
		
		while( ( record = br.readLine() ) != null ) {
			
			
			if( record.contains(id) ) 
				continue;

			bw.write(record);
			bw.flush();
			bw.newLine();

		}
		
		br.close();
		bw.close();
		
		db.delete();
		
		tempDB.renameTo(db);

}
	public void SearchRecordbyID() throws IOException {
		String id,record;
		Scanner strInput = new Scanner(System.in);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader( fileReader );
		
		System.out.println("Id : ");
		id = strInput.nextLine();
		while( ( record = br.readLine() ) != null ) {
			
			String[] data = record.split(",");
			if( record.contains(id) ) {
				System.out.println("id 	   :"+data[0] + " ");
				System.out.println("nama   :"+data[1] + " ");
				System.out.println("job    :"+data[2] + " ");
				System.out.println("alamat :"+data[3] + " ");	
			}	
		}
		br.close();
		
}
	public void updateRecordbyID() throws IOException {
		String newName, newJob, newAddr, record, id,record2;
		
		File tempDB = new File("D:/Split/emp_data2baru.txt");
		File db = new File("D:/Split/emp_data2.txt");
		
		BufferedReader br = new BufferedReader( new FileReader(db) );
		BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );
		    		
		Scanner strInput = new Scanner(System.in);
		
		System.out.println("\t\t Update Employee Record\n\n");   
	/****/		
		System.out.println("Enter the Employee ID: ");
    		id = strInput.nextLine();	    		
    		    		
    		while( ( record = br.readLine() ) != null ) {
    			
    			String[] data = record.split(",");
    			if( record.contains(id) ) {
    				System.out.println("id 	   :"+data[0] + " ");
    				System.out.println("nama   :"+data[1] + " ");
    				System.out.println("job    :"+data[2] + " ");
    				System.out.println("alamat :"+data[3] + " ");
    			}
    			
    		}	    		
    		
    	br.close();
	/****/    	   
		System.out.println("Nama Baru : ");
		newName = strInput.nextLine();    		
		System.out.println("Job baru: ");
		newJob = strInput.nextLine();  
		System.out.println("Alamat baru: ");
		newAddr = strInput.nextLine();  
		
		BufferedReader br2 = new BufferedReader( new FileReader(db) );
			
		while( (record2 = br2.readLine() ) != null ) {    			
			if(record2.contains(id)) {
				bw.write(id+","+newName+","+newJob+","+newAddr);
			} else {
			
				bw.write(record2);	
			}    			
			bw.flush();
			bw.newLine();
		}
		
		bw.close();
		br2.close();    		
		db.delete();    		
		boolean success = tempDB.renameTo(db);    		
		System.out.println(success);    		
		
	}
	public void viewDataDatabase(String employee_id, String first_name, String last_name, String email,
			String phone_number, String hire_date, String job_id, String salary, String commission_pct, String manager_id, String department_id)  throws IOException{
		File file2 = new File("D:/Split/emp_data3.txt");
		FileWriter fileWriter = new FileWriter(file2,true);
		BufferedWriter bw = new BufferedWriter(fileWriter);

		Database emp = new Database();
		Employee empl = new Employee();
		List<Employee> result =  new ArrayList<Employee>();
		result = emp.getAll();
		
		for (int i = 0; i<result.size();i++) {
			Employee model = result.get(i);
			System.out.println(model.getEmployee_id()+
					"\t"+model.getFirst_name()+
					"\t"+model.getLast_name()+
					"\t"+model.getEmail()+
					"\t"+model.getPhone_number()+
					"\t"+model.getHire_date()+
					"\t"+model.getJob_id()+
					"\t"+model.getSalary()+
					"\t"+model.getCommission_pct()+
					"\t"+model.getManager_id()+
					"\t"+model.getDepartment_id()+"\t");
		}
		String data=employee_id+","+first_name+","+last_name+","+email+","+phone_number+","+hire_date+","+job_id+","+salary+","+commission_pct+","+manager_id+","+department_id;
		bw.append(data);
	}
	public void viewDataThread() {
		synchronized(rel){
			rel.kereta = Thread.currentThread().getName();
			for(int i = 0; i < 20; i++){
				rel.jarak = i;
				for(int j = 0; j < rel.jarak; j++){
					System.out.print("=");
				}
				System.out.print("###"+rel.kereta+"###@^>");
				for(int j = 20-1; j > i; j--){
					System.out.print("=");
				}
				System.out.println();
				try{
					Thread.sleep(300);
				}catch(Exception e){}
			}
		}
	}
	
}
