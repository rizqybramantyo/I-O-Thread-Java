package coba1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		File file = new File("D:/test.txt");
//		String strData = " ";
//		String strData1 = " ";
//		String strData2 = " ";
//		try {
//			FileReader fileReader = new FileReader(file);
//			BufferedReader input = new BufferedReader(fileReader);
//			strData = input.readLine();
//			strData1 = input.readLine();
//			strData2 = input.readLine();
//			// fungsi untuk mengambil data ascii
////			int data = 0;
////			while(data != -1) {
////				data = fileReader.read();
////				if(data== -1) continue;
////				
////				System.out.println((char)data + " ");
//			//}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(strData2.equals("L")) {
//			for (int i = 0; i <= Integer.parseInt(strData); i++) {
//			for (int j = i; j <= Integer.parseInt(strData); j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j <= i; j++) {
//				System.out.print(strData1);
//			}
//			
//			System.out.println();
//		} 
//		}
//		else if(strData2.equals("R")){
//			for (int i=0;i<Integer.parseInt(strData);i++) {
//				for (int j=0;j<i;j++) {
//					System.out.print(strData1);
//				}
//				System.out.println();
//				}
//		}
//		else {
//			System.out.println("Error");
//		}
		File file = new File("D:/split/person.txt.txt");
		List<Person> persons = new ArrayList <Person>();
		try {
		FileReader fileReader = new FileReader(file);
		BufferedReader personReader = new BufferedReader(fileReader);
		String person;
		while((person = personReader.readLine()) !=null) {
			String[] personData = person.split(",");
			Person objPerson = new Person();
			objPerson.setName(personData[0]);
			objPerson.setAddress(personData[1]);
//			System.out.print(objPerson.getName() + " " );
//			System.out.print(objPerson.getAddress() + "\n");
			persons.add(objPerson);
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		//foreach
		for(Person person : persons) {
			System.out.println("=========================");
			System.out.println("Nama : " + person.getName());
			System.out.println("Alamat : " + person.getAddress());
			System.out.println("=========================");
		}
		//for biasa
		for(int i = 0; i<persons.size(); i++) {
			System.out.println("=========================");
			System.out.println("Nama : " + persons.get(i).getName());
			System.out.println("Alamat : " + persons.get(i).getAddress());
			System.out.println("=========================");

		}
	}
	}
//System.out.println(strData);
	


