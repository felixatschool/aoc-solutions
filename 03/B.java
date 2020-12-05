import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class B {
    public static void main(String[] args)throws IOException{
        System.out.println((long) slope(1,1) * (long) slope(3,1) * (long) slope(5,1) * (long) slope(7,1) * (long) slope(1,2));
    }

    public static int slope(int a, int b)throws IOException{
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
        int c = 0;
        int y = 0;
        boolean z = (b>1);
        int r = 0;
        for(String line:input){
            if(z)
                r++;
            if (r==b){
                r = 0;
                continue;
            }
            y = (y >= line.length())? y - line.length() : y;
            if(line.charAt(y)=='#')
                c++;
            y = y+a;
        }
        return c;
    }
}

