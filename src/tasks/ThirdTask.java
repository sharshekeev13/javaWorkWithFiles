package tasks;

import java.io.*;

//        Имеется файл с текстом. Осуществить шифрование данного текста в новый файл путем
//        записи текста в матрицу символов по строкам, а затем чтение символов из этой матрицы
//        по столбцам. Осуществить расшифровку полученного текста.
public class ThirdTask {
    public static void runThirdTask() throws IOException {
        // ciphering
        writer(reader("Data_task_3.txt"));
        // deciphering
        System.out.println("......................................");
        for(String[] m:reader("Data_task_3.2.txt")){
            for(String n:m){
                System.out.print(n);
            }
            System.out.println();
        }
    }

    public static void writer(String[][] ciphertext) throws IOException {
        FileWriter writer = new FileWriter("Data_task_3.2.txt",false);
        for(String[] m:ciphertext){
            for(String n:m){
                writer.append(n);
            }
            writer.append("\n");
        }
        writer.flush();
    }

    public static String[][] reader(String filename) throws IOException {
        String line;
        int max_length=0;
        int lines=0;
        BufferedReader br1 = new BufferedReader(new FileReader(filename));
        while((line = br1.readLine()) !=null){
            if(max_length<line.length()) max_length=line.length();
            lines++;
        }

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[][] symbols = new String[lines][max_length];
        int i = 0;
        while((line = br.readLine()) !=null) {
            for(int j=0;j<line.length();j++) {
                symbols[i][j] = String.valueOf(line.charAt(j));
            }
            i++;
        }

        for(int k=0;k<lines;k++) {
            for (int j = 0; j < max_length; j++){
                if (symbols[k][j] == null) symbols[k][j] = "@";
            }
        }
        return ciphering(max_length, lines, symbols);
    }
    public static String[][] ciphering(int max_length, int lines, String[][] symbols){
        String[][] ciphertext = new String[max_length][lines];
        for(int p=0;p<lines;p++){
            for(int q=0;q<max_length;q++){
                ciphertext[q][p] = symbols[p][q];
            }
        }
        return ciphertext;
    }
}
