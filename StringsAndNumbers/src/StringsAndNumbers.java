import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringsAndNumbers {
	private static Scanner scanner;
	private static List<Entry<Character,Integer>> list1;
	private static List<Entry<Character, Integer>> list2;

	public static void main(String[] args) {
		   scanner = new Scanner(System.in);
	       String line;
	       System.out.print("Input: ");
	       line = scanner.nextLine();
	       System.out.println(line);
	       HashMap<Character,Integer> counts = new HashMap<>();
	       for(char c : line.toCharArray()) {
	    	   Integer count = counts.get(c);
	    	   if (count == null) {
	            count = 0;
	    	   }
	    	   counts.put(c, ++count);
	       }
	       List<Entry<Character,Integer>> list = new ArrayList<>(counts.entrySet());
	       Collections.sort(list, new Comparator<Entry<Character,Integer>>() {
	    	   @Override
	    	   public int compare(Entry<Character, Integer> o1,
	    			   Entry<Character, Integer> o2) {
	    		   return o2.getValue() - o1.getValue();
	    	   }
	       });
	       if (list.size() > 11) list1 = new ArrayList<>(list.subList(0,10));
	       else list1 = list;
	       list2 = list1;
	       int i = 9;
	       for(Entry<Character,Integer> entry : list2) {
	    	   entry.setValue(i);
	    	   i--;
	       }
	       for(Entry<Character,Integer> entry : list2) {
	    	   line = line.replace(entry.getKey(), Integer.toString(entry.getValue()).charAt(0));
	       }
	       System.out.println(line);
	       Pattern p = Pattern.compile("\\d+");
	       Matcher m = p.matcher(line);
	       BigInteger sum = BigInteger.valueOf(0);
	       while (m.find()) {
	    	   	sum = sum.add(new BigInteger(m.group()));
	    		}
	       System.out.println(sum);
			}
}
