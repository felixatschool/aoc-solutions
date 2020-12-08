import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;

public class B {
    public static void main(String[] args)throws IOException{
		List<String> rawPassport = inputManager();
		List<String> sortedPassport = rawToSorted(rawPassport);
		int validPassport = passportVerifier(sortedPassport);
		System.out.println(validPassport);
    }

	private static List<String> inputManager()throws IOException{
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
		return input;
	}

	private static List<String> rawToSorted(List<String> w){
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

	private static int passportVerifier(List<String> passports){
		int validCount = 0;
		String a = "";
		String y = "";
		for(String passport:passports){
			int[] fieldPos = new int[]{passport.indexOf("pid"), passport.indexOf("hgt"), passport.indexOf("ecl"),
			   	passport.indexOf("iyr"), passport.indexOf("eyr"),passport.indexOf("byr"), passport.indexOf("hcl")};
			Boolean valid = true;
			for(int i=0;i<fieldPos.length;i++){
				if(fieldPos[i] == -1){
					valid = false;
					break;
				}
				int nextPos = passport.indexOf(":", fieldPos[i]+4);
				if(nextPos == -1)
					nextPos = passport.length()+3;
				String content = passport.substring(fieldPos[i]+4, nextPos-3);
				Boolean validOne = validateField(i, content.trim());
				if(!validateField(i, content.trim()))
					valid=false;
			}
			if(valid)
				validCount++;
		}
		return validCount;
	}

	private static boolean validateField(int i, String content){
		boolean x = false;
		if(i == 0){
			if(content.length() == 9)
				x = true;
		}else if(i == 1){
			if(content.contains("cm")){
				int nmb = Integer.valueOf(content.substring(0, content.indexOf("cm")));
				if(nmb > 149 && nmb < 194)
					x = true;
			}else if(content.contains("in")){
				int nmb = Integer.valueOf(content.substring(0, content.indexOf("in")));
				if(nmb > 58 && nmb < 77){
					x = true;
				}
			}
		}else if(i == 2){
			String[] a = new String[]{"amb","blu","brn","gry","grn","hzl","oth"};
			for(String s:a){
				if(content.equals(s))
					x = true;
			}
		}else if(i == 3){
			if(Integer.valueOf(content) > 2009 && Integer.valueOf(content) < 2021)
				x = true;
		}else if(i == 4){
			if(Integer.valueOf(content) > 2019 && Integer.valueOf(content) < 2031)
				x = true;
		}else if(i == 5){
			if(Integer.valueOf(content) > 1919 && Integer.valueOf(content) < 2003)
				x = true;
		}else if(i == 6){
			if(content.charAt(0)=='#' && content.length() == 7){
				int count = 0;
				char[] a = new char[]{'a','b','c','d','e','f','0','1','2','3','4','5','6','7','8','9'};
				for(char s:a){
					for(int y=0;y<content.length();y++){
						if(content.charAt(y)==s)
							count++;
					}
				}
				if(count==content.length()-1)
					x = true;
			}
		}
		return x;
	}
}
