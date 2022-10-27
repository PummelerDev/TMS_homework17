import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPUtils {
	public static void toCheckIP() {
		String str = new Scanner(System.in).nextLine();
		Pattern pattern = Pattern.compile(
				"((([01]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])[\\.]){3})([01]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			System.out.println("IP adress: "+str+ " is correct");
		}else {
			System.out.println("IP adress: "+str+ " is incorrect");
		}
	}

}
