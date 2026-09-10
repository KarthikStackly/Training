public class StringFuncs {
    static void main() {
        String str1 = "Preyfox   Stackly LLC";
        String str2 = " preyfoxstackly llc";

        System.out.println("Java String Functions");
        System.out.println("1. Length of '" + str1 + "' is " + str1.length());
        System.out.println("2. Upper Case of '"  + str2 + "' is " + str2.toUpperCase());
        System.out.println("3. Lower Case of '" + str1 + "' is "  + str1.toLowerCase());
        System.out.println("4. Character at index 4 in '" + str1 + "' is " + str1.charAt(4));
        System.out.println("5. Substring in '" + str2 + "' is " + str2.substring(0, 5));
        System.out.println("6. Index of 'l' in '" + str1 + "' is " + str1.indexOf("H"));
        System.out.println("7. Last Index of 'l' in '" + str2 + "' is " + str2.lastIndexOf("a"));
        System.out.println("8. Does '" + str2 + "' Contains 'stack': " + str2.contains("stack"));
        System.out.println("9. Does '" + str2 + "' Starts with 'preyfox': " + str2.startsWith("preyfox"));
        System.out.println("10. Does '" + str1 + "' Ends with 'LLC': " + str1.endsWith("LLC"));
        System.out.println("11. Does '" + str1 + "' Equals " + str2 + "? => " + str1.equals(str2));
        System.out.println("12. Does '" + str1 + "' Equals " + str2 + " when Ignoring Case? => " + str1.equalsIgnoreCase(str2));
        System.out.println("13. Replace 'Stackly LLC' with 'LLC, Stackly' => " + str1.replace("Stackly LLC", "LLC, Stackly") );
        System.out.println("14. Trim '" + str1 + "' => " + str1.trim());
        System.out.println("15: Concatenate 'java training' in '" + str2 + "' => " + str2.concat( " java training"));
        System.out.println("stackly" == "stackly");

        String x = "stackly";
        String y = "stackly";
        System.out.println(x == y);
        String z = new String("stackly");

        System.out.println(x == z);
        System.out.println(x.equals(z));


    }
}
