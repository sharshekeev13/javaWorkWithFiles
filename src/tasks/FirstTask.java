package tasks;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


//    Cоздать типизированный файл записей со сведениями о телефонах абонентов; каждая
//    запись имеет поля: фамилия абонента, год установки телефона, номер телефона. По
//    заданной фамилии абонента выдать номера его телефонов. Определить количество
//    установленных телефонов с N-го года.
public class FirstTask {
    static Scanner scanner = new Scanner(System.in);
    public static void runFirstTask() {
        while(true) {
            System.out.print("""
                    
                    1. Совершить запись
                    2. Показать информацию по фамилии
                    3. Показать количество установленных номеров по году
                    
                    >>>""");
            int action = scanner.nextInt();
            if (action==1) write();
            else if (action==2) readBySurname();
            else if (action==3) readByYear();
            else System.out.println("Неправильный ввод данных");
        }
    }
    public static void write() {
            try (FileWriter writer = new FileWriter("Data_task_1.txt", true)) {
                while (true) {
                    System.out.print("Введите фамилия: ");
                    scanner.nextLine();
                    String surname = scanner.nextLine();
                    System.out.print("Введите номер: ");
                    String number = scanner.nextLine();
                    System.out.print("Введите год установки: ");
                    String year = scanner.nextLine();
                    writer.write(surname + ":");
                    writer.write(number + ":");
                    writer.write(year+"\n");
                    writer.flush();
                    System.out.println("""
                            Запись прошла успешно! Хотите продолжить?
                            1 - да
                            0 - нет""");
                    int action = scanner.nextInt();
                    if (action == 0) break;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    public static void readBySurname() {
        System.out.println();
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        try{
            BufferedReader br = new BufferedReader(new FileReader("Data_task_1.txt"));
            String line;
            while ((line = br.readLine()) !=null){
                String[] data = line.split(":");
                for(String i:data){
                    if (i.equals(surname)) {
                        System.out.println("Фамилия - номер - год установки\n"+Arrays.toString(data));
                        return;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readByYear(){
        System.out.print("\nВведите год: ");
        String year = scanner.nextLine();
        try{
            BufferedReader br = new BufferedReader(new FileReader("Data_task_1.txt"));
            String line;
            while ((line = br.readLine()) !=null){
                String[] data = line.split(":");
                for(String i:data){
                    if (i.equals(year)) {
                        System.out.println("Фамилия - номер - год установки\n"+Arrays.toString(data));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
