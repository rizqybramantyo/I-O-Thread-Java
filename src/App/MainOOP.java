package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

// tugas data pegawai jadi class
// proses add data dengan thread
// delete,update
// deadline 31

public class MainOOP {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:/Split/emp_data1.txt");
		DataManager dataManager = new DataManager(file);
		
		//InputStreamReader input = new InputStreamReader(System.in);
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		try {
			do {
				System.out.println("Menu(1> Show)");
				System.out.println("Menu(2> Add)");
				System.out.println("Menu(3> Update)");
				System.out.println("Menu(4> Delete)");
				System.out.println("Menu(5>Exit)");
				//ch = input.read()-30; // 1->31->31-30 =1
				ch = sc.nextInt();
				switch(ch){
					case 1 :
						dataManager.showData();
						break;
					case 2 :
						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						String id = br.readLine();
						String name = br.readLine();
						String job = br.readLine();
						dataManager.AddData(id,name,job);
						break;
					case 3 :
					//	dataPegawai.
						break;
					case 4 : 
						break;
					case 5 : 
						System.exit(0);
				}
				
			}while(ch != 5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
