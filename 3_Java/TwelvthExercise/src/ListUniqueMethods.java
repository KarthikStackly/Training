import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListUniqueMethods {
    static void main() {

        System.out.println("=== 1. Standard List Operations (ArrayList) ===");
        List<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Blueberry"); // Insert at index 1

        // Accessing & Modifying
        System.out.println("Element at index 1: " + list.get(1));
        list.set(0, "Avocado");   // Replace index 0

        // Search & Inspection
        System.out.println("Contains Banana? " + list.contains("Banana"));
        System.out.println("Index of Banana: " + list.indexOf("Banana"));

        // Modifying with Lambda (Java 8+)
        list.replaceAll(String::toUpperCase);
        list.sort(Comparator.naturalOrder());
        System.out.println("Sorted & Uppercased: " + list);

        // Sublist view
        List<String> sub = list.subList(0, 2);
        System.out.println("SubList (0 to 2): " + sub);


        System.out.println("\n=== 2. LinkedList Specifics (Deque / Stack / Queue) ===");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("B", "C"));

        // Deque (Double-Ended Queue)
        linkedList.addFirst("A");
        linkedList.addLast("D");
        System.out.println("LinkedList after addFirst/addLast: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst() + ", Last element: " + linkedList.getLast());

        // Stack operations (LIFO)
        linkedList.push("Top");
        System.out.println("After push(): " + linkedList);
        System.out.println("Popped element: " + linkedList.pop());

        // Queue operations (FIFO)
        linkedList.offer("Tail");
        System.out.println("Polled head: " + linkedList.poll());
        System.out.println("Final LinkedList state: " + linkedList);


        System.out.println("\n=== 3. ArrayList Specific Capacity Tuning ===");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.ensureCapacity(50); // Pre-allocate memory to avoid resizes
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.trimToSize();       // Shrink memory back to actual size (2)
        System.out.println("ArrayList after trimToSize: " + arrayList);


        System.out.println("\n=== 4. CopyOnWriteArrayList Specifics ===");
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(Arrays.asList("Red", "Green"));

        // Thread-safe conditional adds
        boolean addedExisting = cowList.addIfAbsent("Red");   // Won't add duplicate
        boolean addedNew      = cowList.addIfAbsent("Blue");  // Will add

        System.out.println("Added duplicate 'Red'? " + addedExisting);
        System.out.println("Added new 'Blue'? " + addedNew);
        System.out.println("CopyOnWriteArrayList content: " + cowList);
    }
}