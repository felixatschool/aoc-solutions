import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;

public class A {
    public static void main(String[] args)throws IOException{
		List<String> rawPassport = inputManager();
		List<String> sortedPassport = rawToSorted(rawPassport);
		int validPassport = passportVerifier(sortedPassport);
		System.out.println(validPassport);
    }

	public static List<String> inputManager()throws IOException{
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
		return input;
	}

	public static List<String> rawToSorted(List<String> w){
		List<String> x = new LinkedList<String>();
		String singlePassport = "";
		for(String l:w){
			singlePassport += l;
			if(l.trim().isEmpty()){
				x.add(singlePassport);
				singlePassport = "";
			}
		}
		return x;
	}

	public static int passportVerifier(List<String> passports){
		int validCount = 0;
		for(String passport:passports){
			int field = 0;
			for(int i=0;i<passport.length();i++){
				if(passport.charAt(i) == ':')
					field++;
			}
			if(field>7)
				validCount++;
			else if(field==7){
				if(!passport.contains("cid"))
						validCount++;
			}
		}
		return validCount;
	}
}

