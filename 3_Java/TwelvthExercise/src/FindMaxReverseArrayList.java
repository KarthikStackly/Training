import java.util.*;

public class FindMaxReverseArrayList {
    static void main() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(15, 42, 8, 99, 23, 71, 4));

        System.out.println("Your List: " + numbers);
//       First step finding max Number
        int max = Collections.max(numbers);
        System.out.println("Maximum Number: " + max);

//      Alternative using Stream API:
//      int maxStream = numbers.stream().max(Integer::compareTo).orElse(0);

//      reversing the List
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);
    }
}