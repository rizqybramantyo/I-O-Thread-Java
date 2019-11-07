package crudThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataPegawai extends Thread {
	private File file;
	private String id;
	private String nama;
	private String jobId;

	public DataPegawai(File file) {
		this.file = file;
		
	}

	public void showData() {
		
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader reader = new BufferedReader(fileReader);
				String employeeData;
				while ((employeeData = reader.readLine()) != null) {
					String[] data = employeeData.split(",");
					System.out.println(data[0] + " ");
					System.out.println(data[1] + " ");
					System.out.println(data[2] + " ");
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	public boolean addData(String id, String name, String job) {
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// BufferedReader br = new BufferedReader(input);

			String data = id + "," + name + "," + job;
			writer.append(data);
			writer.newLine();

			writer.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

	public boolean updateData() throws Exception {
		String id,name,job;
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// BufferedReader br = new BufferedReader(input);

			
			writer.append(data);
			writer.newLine();

			writer.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	public boolean deleteData() {
		try {
			FileWriter fileWriter = new FileWriter(file,true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String id = null;
			String employeeData = null;
			
			while((employeeData = reader.readLine()) != null) {
				if(employeeData.contains(id))
					
					continue;
			}
			fileWriter.close();
			reader.close();
			
					} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	public boolean deleteTextData() {
		try {
			PrintWriter pw = new PrintWriter(file);
			FileWriter fileWriter = new FileWriter(file,true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line1 = reader.readLine();
			while(line1 != null) {
				boolean flag = false;
				BufferedReader reader2 = new BufferedReader(new FileReader("D:/split/emp_datadelete.txt"));
				
				String line2 = reader2.readLine();
				
				while(line2 != null) {
					if(line1.equals(line2)) {
						flag = true;
						break;
					}
					line2 = reader2.readLine();
				}
				if(!flag)
					pw.println(line1);
				line1 = reader.readLine();
			}
			pw.flush();
			reader.close();
			pw.close();
			System.out.println("sukses");
					} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
