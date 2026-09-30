import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class ProgOnStreamAPI {
    static void main() {

        System.out.println("*** Creating a Stream from List & forEach ***");
        List<String> names = Arrays.asList("Amar", "Akbar", "Anthony");
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);

        System.out.println("\n=== 2. filter() ===");
        List<Integer> numbersForFilter = Arrays.asList(10, 15, 20, 25, 30);
        numbersForFilter.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\n=== 3. map() ===");
        List<Integer> numbersForMap = Arrays.asList(1, 2, 3, 4);
        numbersForMap.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        System.out.println("\n=== 4. sorted() ===");
        List<Integer> numbersForSort = Arrays.asList(40, 10, 30, 20);
        numbersForSort.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n=== 5. collect() ===");
        List<String> collectResult = names.stream()
                .filter(name -> name.startsWith("R"))
                .collect(Collectors.toList());
        System.out.println(collectResult);

        System.out.println("\n=== 6. count() ===");
        List<Integer> numbersForCount = Arrays.asList(10, 20, 30, 40);
        long count = numbersForCount.stream().count();
        System.out.println(count);

        System.out.println("\n=== 7. limit() ===");
        List<Integer> numbersForLimit = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbersForLimit.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n=== 8. distinct() ===");
        List<Integer> numbersForDistinct = Arrays.asList(1, 2, 2, 3, 3, 4);
        numbersForDistinct.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n=== 9. findFirst() ===");
        String first = names.stream()
                .findFirst()
                .get();
        System.out.println(first);

        System.out.println("\n=== 10. reduce() ===");
        List<Integer> numbersForReduce = Arrays.asList(10, 20, 30);
        int sum = numbersForReduce.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("\n=== Employee Salary Filter ===");
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Ram", 50000),
                new Employee(2, "John", 30000),
                new Employee(3, "Arun", 70000)
        );

        empList.stream()
                .filter(e -> e.salary > 40000)
                .forEach(e -> System.out.println(e.name));
    }
}