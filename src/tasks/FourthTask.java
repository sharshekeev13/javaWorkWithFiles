package tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// 4. Создать программу, переписывающую в текстовый файл g содержимое файла f,
// исключая пустые строки, а остальные дополнить справа пробелами или
// ограничить до n символов.
public class FourthTask {
    public static void runFourthTask() {
        int n = 50;
        String records = "";
        try (Scanner scanner = new Scanner(new File("Data_task_4_f.txt"));) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() < n && line.length() != 0) {
                    String rep = "";
                    for(int i=0;i<n- line.length();i++) {
                        rep += " ";
                    }
                    line = line + ( rep );
                    records = records.concat(line + "\n");
                }
                if (line.length() >= n) {
                    line = line.substring(0, n );
                    records = records.concat(line + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // запись
        try(FileWriter writer = new FileWriter("Data_task_4_g.txt", false))
        {
                writer.write(records);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}