package tasks;

import java.io.*;
import java.util.Arrays;

//        В текстовый файл занесены пары чисел, разделенных пробелом (каждая пара чисел – в новой строке).
//        Рассматривая каждую пару как координаты точек на плоскости, найти наибольшее и наименьшее
//        расстояния между этими точками.
public class SecondTask {
    public static void runSecondTask() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data_task_2.txt"));
            String line;
            while((line = br.readLine()) !=null) {
                int[] coords = new int[4];
                String[] coords_2_spots = line.split(" ");
                System.out.println("\nПервая и вторая точка\n x y  x y\n" +
                        Arrays.toString(coords_2_spots));
                int k=0;
                for (String coords_2_spot : coords_2_spots) {
                    String[] coords_xy = coords_2_spot.split(";");
                    for (String s : coords_xy) {
                        if (k == 4) k = 0;
                        coords[k] = Integer.parseInt(s);
                        k++;
                    }
                }
                double distance = Math.sqrt(Math.pow(coords[2]-coords[0],2)+Math.pow(coords[3]-coords[1],2));
                System.out.printf("\nРасстояние между %s и %s равно %.2f\n",coords_2_spots[0],coords_2_spots[1],distance);
            }
        }catch(IOException e){
            System.out.println("Error "+e);
        }
    }
}
