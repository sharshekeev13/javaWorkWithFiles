package tasks;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// 8. Получить файл g, в котором текст выровнен по правому краю путем
// равномерного добавления пробелов.
public class EightTask {
    public static void runEightTask() {
        String records = "";
        try (Scanner scanner = new Scanner(new File("Data_task_8_f.txt"));) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toString();
                    records = records.concat(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(records);
        int length = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine().toString();
            if (line.length() > length){
                length = line.length();
            }
        }
        String rep = "";
        scanner = new Scanner(records);
        String records2 = "";
        while (scanner.hasNextLine()){
            rep = "";
            String line = scanner.nextLine().toString();
            for(int i=0;i < length - line.length();i++) {
                rep += " ";
            }
            records2 = records2.concat(rep + line + "\n");
        }

        try (FileWriter writer = new FileWriter("Data_task_8_g.txt", false))
        {
            writer.write(records2);
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}