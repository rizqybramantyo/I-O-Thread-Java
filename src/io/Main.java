package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:/split/hewan.txt");
		List<Hewan> hewans = new ArrayList <Hewan>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader hewanReader = new BufferedReader(fileReader);
			String hewan;
			while((hewan = hewanReader.readLine()) !=null){
				String[] hewanData = hewan.split(",");
				Hewan objHewan = new Hewan();
				objHewan.setNama(hewanData[0]);
				objHewan.setJenis(hewanData[1]);
				objHewan.setSuara(hewanData[2]);
				objHewan.setGerak(hewanData[3]);
				hewans.add(objHewan);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		for(Hewan hewan : hewans) {
			System.out.println("=========================");
			System.out.println("Nama : " + hewan.getNama());
			System.out.println("Jenis : " + hewan.getJenis());
			System.out.println("Suara : " + hewan.getSuara());
			System.out.println("Gerak : " + hewan.getGerak());
			System.out.println("=========================");
		}
		}
	}


