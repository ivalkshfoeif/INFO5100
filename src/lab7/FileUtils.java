package lab7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<String> readFile(String filename){
        try{
            List<String> list = new ArrayList<>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String curLine = scanner.nextLine();
                list.add(curLine);
                System.out.println("New line scanned: "+curLine);
            }
            return list;

        }catch (Exception e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return null;
    }

    public static void createFile(String filename){
        try{
            File file = new File(filename);
            if (file.createNewFile()){
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (Exception e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void writeFile(List<String> list, String filename){
        try(FileWriter fstream = new FileWriter(filename);
            BufferedWriter info = new BufferedWriter(fstream)){
            for (String s : list){
                info.write(s);
                info.write("\n");
                System.out.println("New line written: "+s);
            }
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
