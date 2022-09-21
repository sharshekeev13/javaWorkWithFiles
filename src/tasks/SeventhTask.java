package tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// 7. Получить файл g, состоящий из строк файла f, содержащих заданную строку S.
// Предусмотреть случай, когда строка размещается в двух строках файла «с
// переносом».
public class SeventhTask {
    public static void runSeventhTask() {
        String S ="на";
        String records = "";
        try (Scanner scanner = new Scanner(new File("Data_task_7_f.txt"));) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toString();
                if (line.contains(S)){
                     records = records.concat(line + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // запись
        try (FileWriter writer = new FileWriter("Data_task_7_g.txt", false))
        {
                writer.write(records);
            }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
    }
}

