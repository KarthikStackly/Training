import java.util.*;

public class MapNMethods {
    static void main() {
// Map storing Employee ID -> Salary
    Map<Integer, Double> empSalaries = new HashMap<>();

//      ADD (put / putIfAbsent)
    empSalaries.put(101, 55000.0);
    empSalaries.put(102, 62000.5);
    empSalaries.put(103, 48000.0);
    empSalaries.putIfAbsent(104, 75000.0); // adds only if that id doesn't exist..
    System.out.println("*** Here are your Employees ***");
    displayEmployees(empSalaries);

//  Check if presetn (containsKey / containsValue)
    int searchId = 102;
    double targetSalary = 48000.0;

    System.out.println("\n*** Checking Presence ***");
    if (empSalaries.containsKey(searchId)) {
        System.out.println("Employee ID " + searchId + " exists with salary: INR " + empSalaries.get(searchId));
    } else {
        System.out.println("Employee ID " + searchId + " not found.");
    }

    if (empSalaries.containsValue(targetSalary)) {
        System.out.println("A salary of INR " + targetSalary + " exists in records.");
    }

    // Delete/remove
    int removeId = 103;
    empSalaries.remove(removeId);
    System.out.println("\n*** Here are your Employees after deleting ID " + removeId + " ***");
    displayEmployees(empSalaries);
}

// Display Employees (Looping through the Map)
private static void displayEmployees(Map<Integer, Double> map) {
    map.forEach((id, salary) ->
            System.out.println("Employee ID: " + id + " | Salary: INR " + salary)
        );
    }
}
