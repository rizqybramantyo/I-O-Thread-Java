package crudThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

import App.DataManager;

public class Main {
	public static void main(String[] args) {
		
	
	File file = new File("D:/split/emp_data1.txt");
	DataPegawai dataPegawai = new DataPegawai(file);
	
	//InputStreamReader input = new InputStreamReader(System.in);
	Scanner sc = new Scanner(System.in);
	int ch = 0;
	try {
		do {
			System.out.println("1. Show)");
			System.out.println("2. Add)");
			System.out.println("Menu(3> Update)");
			System.out.println("Menu(4> Delete File)");
			System.out.println("Menu(5> Delete Text");
			System.out.println("Menu(6> Exit)");
			//ch = input.read()-30; // 1->31->31-30 =1
			ch = sc.nextInt();
			switch(ch){
				case 1 :
					dataPegawai.showData();
					break;
				case 2 :
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("Id Pegawai");
					String id = br.readLine();
					System.out.print("Nama Pegawai");
					String name = br.readLine();
					System.out.print("Job Pegawai");
					String job = br.readLine();
					dataPegawai.addData(id,name,job);
					break;
				case 3 :
				//	dataPegawai.
					break;
				case 4 : 
				dataPegawai.deleteData();
					break;
				case 5 : 
				dataPegawai.deleteTextData();	
					break;
				case 6 : 
					System.exit(0);
			}
			
		}while(ch != 5);
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
