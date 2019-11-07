package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:/Split/emp_data.txt");
		//InputStreamReader input = new InputStreamReader(System.in);
			Scanner sc = new Scanner(System.in);
		int ch = 0;
		try {
			do {
				System.out.println("Menu(1> Show)");
				System.out.println("Menu(2> Add)");
				System.out.println("Menu(3>Exit)");
				//ch = input.read()-30; // 1->31->31-30 =1
				ch = sc.nextInt();
				switch(ch){
					case 1 :
						FileReader fileReader = new FileReader(file);
						BufferedReader reader = new BufferedReader(fileReader);
						String employeeData;
						while((employeeData = reader.readLine()) != null) {
							String[] data = employeeData.split(",");
							System.out.println(data[0] + " ");
							System.out.println(data[1] + " ");
							System.out.println(data[2] + " ");
						}
						reader.close();
						break;
					case 2 :
						FileWriter fileWriter = new FileWriter(file, true);
						BufferedWriter writer = new BufferedWriter(fileWriter);
						//BufferedReader br = new BufferedReader(input);
						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						String id = br.readLine();
						String name = br.readLine();
						String job = br.readLine();
						
						String data = id+","+name+","+job;
						writer.append(data);
						writer.newLine();
						
						writer.close();
						break;
					case 3 : 
						System.exit(0);
				}
				
			}while(ch != 3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
