import java.util.*;
import java.io.*;

public class FilePractice {
    static void saveToFile(List<String> lines, String fileName){
        try(FileWriter writer =  new FileWriter(fileName)){
            for(String line:lines){
                writer.write(line+"\n");
            }
        } catch (IOException e) {
            System.out.println("error saving file");
        }
    }

    static List<String> loadFromFile(String fileName){
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line=reader.readLine())!=null){
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("error loading file");
        }
        return lines;
    }

    static String removeWord(String line, String target){
        String[] words=line.split(" ");
        StringBuilder result = new StringBuilder();
        for(String w: words){
            if(!w.equals(target)){
                result.append(w).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args){
        List<String> data=new ArrayList<>();
        data.add("Hello world is nice");
        data.add("this is a test");
        data.add("file handling");
        data.add("potato");
        data.set(2, "this is an edited line");

        for(int i=0; i<data.size();i++){
            if(data.get(i).contains("is")){
                data.set(i, data.get(i).replace(" is ", " was "));
            }
        }

        data.set(1, removeWord(data.get(1), "test"));

        saveToFile(data, "practice.txt");
        List<String> loaded=loadFromFile("practice.txt");

        System.out.println("The file content:");
        for(String line:loaded){
            System.out.println(line);
        }
    }
}