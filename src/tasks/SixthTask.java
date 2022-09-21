package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//        Из текстового файла удалить все слова, содержащие от трех до пяти символов,
//        но при этом из каждой строки должно быть удалено только четное количество таких слов.
public class SixthTask {
    public static void runSixthTask() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data_task_6.txt"));
            String line;
            ArrayList<String> arr = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                int counter=0;
                for(String i:data){
                    if(i.length()<3 || i.length()>5){
                        arr.add(i);
                        counter++;
                    }
                }
                if(counter%2!=0){
                    arr.add(data[data.length-1]);
                }
            }
            FileWriter writer = new FileWriter("Data_task_6.txt", true);
            writer.write("\n");
            for(String i:arr){
                writer.write(i+" ");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
