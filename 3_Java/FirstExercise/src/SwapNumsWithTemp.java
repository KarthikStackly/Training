public class SwapNumsWithTemp {
    static void main() {
        System.out.println("Swapping Numbers using a temporary variable");
        int first = 59;
        int second = 99;

        System.out.println("Before swapping, First Number is " + first + " and Second Number is " + second);
        int temp = first;
        first = second;
        second = temp;

        System.out.println("After swapping, First Number is " + first + " and Second Number is " + second);

    }
}
