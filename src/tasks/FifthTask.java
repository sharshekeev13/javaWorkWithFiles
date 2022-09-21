package tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//    В файле, содержащем фамилии студентов и их оценки, изменить на прописные буквы фамилии
//    тех студентов, которые имеют средний балл за национальной шкалой более «4».
public class FifthTask {
    public static void runFifthTask() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data_task_5.txt"));
            String line;
            ArrayList<String> arr = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[1].equals("4") || data[1].equals("5")) {
                    data[0] = data[0].toLowerCase();
                }
                arr.add(data[0]+" "+data[1]);
            }
            FileWriter writer = new FileWriter("Data_task_5.txt", false);
            for(String i:arr){
                writer.write(i+ "\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}