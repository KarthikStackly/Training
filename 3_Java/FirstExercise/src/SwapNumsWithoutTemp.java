public class SwapNumsWithoutTemp {
    static void main() {
        System.out.println("Swapping Numbers without using Temp Variables");
        int first = 59;
        int second = 99;

        System.out.println("Before swapping, First Number is " + first + " and Second Number is " + second);

        first = first + second;
        second = first - second;
        first = first - second;

        System.out.println("After swapping, First Number is " + first + " and Second Number is " + second);
    }
}
