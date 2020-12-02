import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class B {
    public static void main(String[] args)throws IOException{
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
        String pw;
        char l;
        int min;
        int max;
        int mark;
        int count;
        int goodPw=0;

        for(String line:input){
            count = 0;
            l = line.substring(line.indexOf(":")-1).charAt(0);
            pw = line.substring(line.indexOf(":")+1);

            mark = line.indexOf("-");
            min = Integer.valueOf(line.substring(0,mark));
            max = Integer.valueOf(line.substring(mark+1, line.indexOf(" ", mark+1)));

            if((pw.charAt(min) == l && pw.charAt(max) !=l ) ||(pw.charAt(max) == l && pw.charAt(min) != l ))
                goodPw++;
        }
        System.out.println(goodPw);
    }
}

