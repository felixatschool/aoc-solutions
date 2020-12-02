import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class B {
    public static void main(String[] args)throws IOException{
        List<String> sum = Files.readAllLines(Paths.get("sum.txt"));
        loop:
        for(String a:sum){
            for(String b:sum){
                for(String c:sum){
                    int x = Integer.valueOf(a);
                    int y = Integer.valueOf(b);
                    int z = Integer.valueOf(c);
                    if(x+y+z==2020){
                        System.out.println(x*y*z);
                        break loop;
                    }
                }
            }
        }

    }
}

