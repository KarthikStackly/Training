public class AllOps {
    static void main() {
        System.out.println("All the Operators available in Java");

        int a = 99;
        int b = 59;

//        Arithmetic Operators
        System.out.println("1. Addition Operator");
        System.out.println(a + " + " + b + " = " + (a+b));
        System.out.println("2. Subtraction Operator");
        System.out.println(a + " - " + b + " = " + (a-b));
        System.out.println("3. Multiplication Operator");
        System.out.println(a + " x " + b + " = " + (a*b));
        System.out.println("4. Division Operator");
        System.out.println(a + " / " + b + " = " + (a/b));
        System.out.println("5. Modulus Operator");
        System.out.println(a + " % " + b + " = " + (a%b));

//        Relational Operators
        System.out.println("6. Equal to");
        System.out.println("Is " + a + " = " + b + " => " + (a==b));
        System.out.println("7. Not Equal to");
        System.out.println("Is " + a + " != " + b + " => " + (a!=b));
        System.out.println("8. Greater than");
        System.out.println("Is " + a + " > " + b + " => " + (a>b));
        System.out.println("9. Less than");
        System.out.println("Is " + a + " < " + b + " => " + (a<b));
        System.out.println("10. Greater than or Equal to");
        System.out.println("Is " + a + " >= " + b + " => " + (a>=b));
        System.out.println("11. Less than or Equal to");
        System.out.println("Is " + a + " <= " + b + " => " + (a<=b));

//        Logical Operators
        System.out.println("12. Logical AND");
        System.out.println("Is " + a + " < " + b + " AND a = " + a + " => " + ((a<b) && (a==99)));
        System.out.println("13. Logical OR");
        System.out.println("Is " + a + " > " + b + " OR a = " + a + " => " + ((a>b) && (a==99)));
        System.out.println("14. NOT");
        System.out.println("The logical opposite of true (!true) is => " + !true);

//        Assignment Operators
        System.out.println("15. Simple assignment");
        int temp = 100;
        System.out.println("int temp = " + temp);
        System.out.println("16. Compounding assignment");
        temp += a;
        System.out.println("  a. temp = temp + a can also be written as temp += a... " + temp);
        temp -= b;
        System.out.println("  b. temp = temp - b can also be written as temp += b... " + temp);
        temp *= a;
        System.out.println("  c. temp = temp * a can also be written as temp += a... " + temp);
        temp -= b;
        System.out.println("  a. temp = temp / b can also be written as temp /= b... " + temp);

//        Unary Operators
        System.out.println("17. Increment Operator");
        System.out.print("temp is " + temp + " and temp++ is ");
        temp++;
        System.out.print(temp);
        System.out.println("18. Decrement Operator");
        System.out.print("temp is " + temp + " and temp-- is ");
        temp--;
        System.out.print(temp);

//        Ternary Operator
        System.out.println("19. Ternary Operator");
        System.out.println(a > b ? (a + " is greater than " + b) : (a + " is less than " + b));

    }
}
