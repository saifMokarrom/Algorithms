import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class problem1 {
	

	public static void main(String[] args) {
	
		File file = new File("src/LAb1input.txt");
		String output = "";
		String stat = "";
		float ev_cnt=0; int odd_cnt = 0; int pal_cnt=0;
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNext()) {
				String num = scan.next();
				String word = scan.next();
				
				output = output.concat(num+" "+parityChecker(num)+" and "+word+" "+isPalindrome(word)+"\n");

				if (parityChecker(num) == "has even parity") ev_cnt++;
				else if(parityChecker(num) == "has odd parity") odd_cnt++;
				if (isPalindrome(word) == "is a palindrome") pal_cnt++;
				
			}
			
			stat = stat.concat("Percentage of odd parity: "+(int)((odd_cnt/5.0)*100.0)+"%\n");
			stat = stat.concat("Percentage of even parity: "+(int)((ev_cnt/5.0)*100.0)+"%\n");
			stat = stat.concat("Percentage of no parity: "+(int)(((5-ev_cnt-odd_cnt)/5.0)*100.0)+"%\n");
			stat = stat.concat("Percentage of palindrom: "+(int)((pal_cnt/5.0)*100.0)+"%\n");
			stat = stat.concat("Percentage of no-palindrom: "+(int)(((5-pal_cnt)/5.0)*100.0)+"%\n");

			try {
				FileWriter writer = new FileWriter("src/output.txt");
				writer.write(output);
				writer.close();
				FileWriter writer2 = writer2 = new FileWriter("src/record.txt");
				writer2.write(stat);
				writer2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		


	}
	private static String parityChecker(String num) {
		for (int i = 0;i<num.length();i++) {
			if (num.charAt(i) == '.' && num.charAt(i+1) != '0') {
				return "cannot have parity";
			}
		}
		if (num.charAt(num.length()-1) == '0' || num.charAt(num.length()-1) == '2' || num.charAt(num.length()-1) == '4' || num.charAt(num.length()-1) == '6' || num.charAt(num.length()-1) == '8')
			return "has even parity";
		return "has odd parity";
	}
	private static String isPalindrome(String word) {
		if (word == null) return "is not a palindrome";
		int n = word.length();
		int i = 0;
		while(i<(n/2)) {
			if (word.charAt(i) != word.charAt(n-1-i)) return "is not a palindrome";
		    i++;
		}
		return "is a palindrome";
		
	}

}
