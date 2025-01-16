package BaiTap;

import java.util.*;

public class CollectionExercises {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bài 1: List of Integers
        System.out.println("Bài 1: List of Integers");
        System.out.print("Enter the number of integers (n): ");
        int n1 = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            intList.add(scanner.nextInt());
        }
        System.out.println("List entered: " + intList);
        Collections.sort(intList);
        System.out.println("Sorted list (ascending): " + intList);

        System.out.println(); // Add a newline for separation

        // Bài 2: Set of City Names
        System.out.println("Bài 2: Set of City Names");
        System.out.print("Enter the number of cities (n): ");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()
        Set<String> citySet = new TreeSet<>(); // Use TreeSet for automatic sorting
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter city name " + (i + 1) + ": ");
            citySet.add(scanner.nextLine());
        }
        System.out.println("Set entered: " + citySet);
        System.out.println("Sorted set (ascending): " + citySet); // Already sorted by TreeSet

        System.out.println(); // Add a newline for separation

        // Bài 3: Map of Country Names (Integer Key)
        System.out.println("Bài 3: Map of Country Names");
        System.out.print("Enter the number of countries (n): ");
        int n3 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Map<Integer, String> countryMap = new TreeMap<>(); // Use TreeMap for sorted keys
        for (int i = 1; i <= n3; i++) {
            System.out.print("Enter country name for key " + i + ": ");
            countryMap.put(i, scanner.nextLine());
        }
        System.out.println("Map entered: " + countryMap);

        // Display sorted by country name (value)
        System.out.println("Sorted by country name (ascending):");
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(countryMap.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue());
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        scanner.close();
    }
}
