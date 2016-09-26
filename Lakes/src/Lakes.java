import java.util.Scanner;

public class Lakes {
	private static Scanner scanner;

	public static void main(String[] args) {
	      
		   scanner = new Scanner(System.in);
	       String input;
	       int flag = 0;
	       int volume = 0;
	       int it_level = 0;
	       int level = 0;
	       System.out.print("Input: ");
	       input = scanner.nextLine();
	       System.out.println(input);
	       for (int i=0; i<input.length(); i++) {
	    	   switch (input.charAt(i)) {
	    	   case 'd' : flag = 1;
	    	   break;
	    	   case 'h' : flag = 0;
	    	   break;
	    	   case 'u' : flag = -1;
	    	   break;
	    	   }
	    	   level = level + flag;
	    	   if (level < 0) it_level = 0;
	    	   else it_level = level;
	    	   volume = volume + flag*500 + it_level*1000;
	       }
	       System.out.println(volume);
	}
}