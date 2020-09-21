package com.lgumede.swingy.model.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckFileFormat {
    static String[][] temp = null;
	static FileReader fr = null;
	static BufferedReader br = null;
    
    // public void saveHero() {
	// 	try {
	//         File file = new File("simulation.txt");
	//         if (file.createNewFile()){
	//             System.out.println("New sim file created");
	//         } else {
	//             System.out.println("Deleting and re-creating simulation.txt");
	//             file.delete();
	//             file.createNewFile();
	//         }
	// 	} catch(IOException e) {
	// 		System.out.println("Something went wrong in creating the sim file (''- )");
	// 		System.exit(1);
	// 	}
    // }
    
    // public void fetchHero() {
	// 	try {
	//         File file = new File("simulation.txt");
	//         if (file.createNewFile()){
	//             System.out.println("New sim file created");
	//         } else {
	//             System.out.println("Deleting and re-creating simulation.txt");
	//             file.delete();
	//             file.createNewFile();
	//         }
	// 	} catch(IOException e) {
	// 		System.out.println("Something went wrong in creating the sim file (''- )");
	// 		System.exit(1);
	// 	}
	// }

	// public int FileReader() {
	// 		try {
	//             fr = new FileReader("Heroes.txt");
	//             br = new BufferedReader(fr);
	//             String line;

	//             //line = br.readLine();
	//             if (iterations == 0){
	//                 System.out.println("File empty... (''- )");
	//             } else {
	//                 while ((line = br.readLine()) != null) {
	//                 	temp = lineFormat(line);
	//                     if(temp == null) {
	//                     	fr.close();
	//                         br.close();
	//                     	return 0;
	//                     } else if (temp.length == 1) {
	//                     	continue;
	//                     }
	//                     else {
	//                     	PlaneList = AirCraftList(temp, PlaneList);
	//                     }
	//                 }
	//                 fr.close();
	//                 br.close();
	//                 return 1;
	//             }
	//         } catch (Exception e) {
	//             System.out.println("No saved heroes");
	//             return 0;
	//         }
	// 	return 0;
    // }
}
