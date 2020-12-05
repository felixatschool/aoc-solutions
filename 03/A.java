import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class A {
    public static void main(String[] args)throws IOException{
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
        int c = 0;
        int y = 0;
        for(String line:input){
            y = (y >= line.length())? y - line.length() : y;
            if(line.charAt(y)=='#')
                c++;
            y = y+3;
        }
        System.out.println(c);
    }
}

