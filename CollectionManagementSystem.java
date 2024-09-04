import java.util.*;

// Interface for common collection operations
interface CollectionManager<T> {
    void addElement(T element);
    void removeElement(T element);
    void displayAllElements();
}

// ListManager class for managing lists
class ListManager<T> implements CollectionManager<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public void addElement(T element) {
        list.add(element);
        System.out.println("Element added to the list: " + element);
    }

    @Override
    public void removeElement(T element) {
        if (list.remove(element)) {
            System.out.println("Element removed from the list: " + element);
        } else {
            System.out.println("Element not found in the list: " + element);
        }
    }

    @Override
    public void displayAllElements() {
        System.out.println("Elements in the list:");
        list.forEach(System.out::println);
    }
}

// SetManager class for managing sets
class SetManager<T> implements CollectionManager<T> {
    private Set<T> set = new HashSet<>();

    @Override
    public void addElement(T element) {
        set.add(element);
        System.out.println("Element added to the set: " + element);
    }

    @Override
    public void removeElement(T element) {
        if (set.remove(element)) {
            System.out.println("Element removed from the set: " + element);
        } else {
            System.out.println("Element not found in the set: " + element);
        }
    }

    @Override
    public void displayAllElements() {
        System.out.println("Elements in the set:");
        set.forEach(System.out::println);
    }
}

// MapManager class for managing maps
class MapManager<K, V> implements CollectionManager<Map.Entry<K, V>> {
    private Map<K, V> map = new TreeMap<>();

    @Override
    public void addElement(Map.Entry<K, V> entry) {
        map.put(entry.getKey(), entry.getValue());
        System.out.println("Key-Value pair added to the map: " + entry);
    }

    @Override
    public void removeElement(Map.Entry<K, V> entry) {
        if (map.containsKey(entry.getKey())) {
            map.remove(entry.getKey());
            System.out.println("Key-Value pair removed from the map: " + entry);
        } else {
            System.out.println("Key not found in the map: " + entry.getKey());
        }
    }

    @Override
    public void displayAllElements() {
        System.out.println("Key-Value pairs in the map:");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

// Main class for the Collection Management System
public class CollectionManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListManager<String> listManager = new ListManager<>();
        SetManager<Integer> setManager = new SetManager<>();
        MapManager<String, Double> mapManager = new MapManager<>();

        while (true) {
            System.out.println("\nCollection Management System Menu:");
            System.out.println("1. Lists");
            System.out.println("2. Sets");
            System.out.println("3. Maps");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    performCollectionOperations(listManager, "List");
                    break;
                case 2:
                    performCollectionOperations(setManager, "Set");
                    break;
                case 3:
                    performCollectionOperations(mapManager, "Map");
                    break;
                case 4:
                    System.out.println("Exiting the Collection Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static <T> void performCollectionOperations(CollectionManager<T> collectionManager, String collectionType) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + collectionType + " Management Menu:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("4. Back to main menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    T elementToAdd = getElementFromUserInput(scanner, collectionType);
                    collectionManager.addElement(elementToAdd);
                    break;
                case 2:
                    System.out.print("Enter the element to remove: ");
                    T elementToRemove = getElementFromUserInput(scanner, collectionType);
                    collectionManager.removeElement(elementToRemove);
                    break;
                case 3:
                    collectionManager.displayAllElements();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static <T> T getElementFromUserInput(Scanner scanner, String collectionType) {
        try {
            if (collectionType.equals("List")) {
                return (T) scanner.nextLine();
            } else if (collectionType.equals("Set")) {
                return (T) (Integer) scanner.nextInt();
            } else if (collectionType.equals("Map")) {
                System.out.print("Enter the key: ");
                String key = scanner.next();
                System.out.print("Enter the value: ");
                Double value = scanner.nextDouble();
                return (T) new AbstractMap.SimpleEntry<>(key, value);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid element.");
            scanner.nextLine(); // Consume the invalid input
        }

        return null;
    }
}
