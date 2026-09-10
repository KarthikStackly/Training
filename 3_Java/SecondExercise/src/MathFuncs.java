public class MathFuncs {
    static void main() {
        System.out.println("Java Math Functions");
        double x = -67.98765;
        double y = 13.3;
        System.out.println("1. Absolute Value of " + x + " is " + Math.abs(x));
        System.out.println("2. Floor of " + x + " is " + Math.floor(x));
        System.out.println("3. Ceiling of " + y + " is " + Math.ceil(y));
        System.out.println("4. Round of " + x + " is " + Math.round(x));
        System.out.println("5. Maximum of " + x + " and " + y + " is " + Math.max(x,y));
        System.out.println("6. Minimum of " + x + " and " + y + " is " + Math.min(x,y));
        System.out.println("7. Power: 5 to the power 3 is " + Math.pow(5,3));
        System.out.println("8. Square Root of 25 is " + Math.sqrt(25));
        System.out.println("9. Cube Root of 125 is " + Math.cbrt(125));
        System.out.println("10. Random Number lies between 0 & 1: " + Math.random());
        System.out.println("11. Sine: " + Math.sin(Math.PI / 2));
        System.out.println("12. Cosine: " + Math.cos(0));
    }
}
