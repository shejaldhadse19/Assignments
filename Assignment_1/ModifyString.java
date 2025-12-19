package Assignment_1;

public class ModifyString {

	    public static void main(String[] args) {

	        String str = "My name is Shejal Dhadse";

	        System.out.println("Original String: " + str);

	        // length()
	        System.out.println("Length: " + str.length());

	        // isEmpty()
	        System.out.println("Is Empty: " + str.isEmpty());

	        // charAt()
	        System.out.println("Character at index 3: " + str.charAt(3));

	        // toString()
	        System.out.println("To String: " + str.toString());

	        // equals()
	        System.out.println("Equals 'My name is Shejal Dhadse': " +
	                str.equals("My name is Shejal Dhadse"));

	        // compareTo()
	        System.out.println("Compare To 'Hello': " + str.compareTo("Hello"));

	        // contains()
	        System.out.println("Contains 'Shejal': " + str.contains("Shejal"));

	        // indexOf()
	        System.out.println("Index Of 'name': " + str.indexOf("name"));

	        // lastIndexOf()
	        System.out.println("Last Index Of 'a': " + str.lastIndexOf('a'));

	        // startsWith()
	        System.out.println("Starts With 'My': " + str.startsWith("My"));

	        // endsWith()
	        System.out.println("Ends With 'Dhadse': " + str.endsWith("Dhadse"));

	        // matches()
	        System.out.println("Matches regex '.*Shejal.*': " +
	                str.matches(".*Shejal.*"));

	        // substring()
	        System.out.println("Substring (11 to 17): " + str.substring(11, 17));

	        // toLowerCase()
	        System.out.println("Lowercase: " + str.toLowerCase());

	        // trim()
	        String str2 = "   Hello World   ";
	        System.out.println("Trimmed String: '" + str2.trim() + "'");

	        // replace()
	        System.out.println("Replace 'Shejal' with 'Sonal': " +
	                str.replace("Shejal", "Sonal"));

	        // split()
	        String[] words = str.split(" ");
	        System.out.println("Split words:");
	        for (String word : words) {
	            System.out.println(word);
	        }

	        // join()
	        String joined = String.join("-", words);
	        System.out.println("Joined String: " + joined);

	        // valueOf()
	        int num = 100;
	        String valueStr = String.valueOf(num);
	        System.out.println("Value Of int to String: " + valueStr);
	    }
	}
