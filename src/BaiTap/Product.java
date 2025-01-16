package BaiTap;

import java.util.*;

class Product {
    private String proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private float price;

    public Product() {
    }

    public Product(String proId, String proName, String producer, int yearMaking, float price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", producer='" + producer + '\'' +
                ", yearMaking=" + yearMaking +
                ", price=" + price +
                '}';
    }
}

class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Product> productMap = new HashMap<>();

        System.out.print("Enter the number of products (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Producer: ");
            String producer = scanner.nextLine();
            System.out.print("Year Making: ");
            int year = scanner.nextInt();
            System.out.print("Price: ");
            float price = scanner.nextFloat();
            scanner.nextLine(); // Consume newline

            productMap.put(i, new Product(id, name, producer, year, price));
        }

        System.out.println("\n--- Entered Product Information ---");
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        // Sort by yearMaking
        List<Map.Entry<Integer, Product>> list = new ArrayList<>(productMap.entrySet());
        Collections.sort(list, Comparator.comparingInt(entry -> entry.getValue().getYearMaking()));

        System.out.println("\n--- Product Information Sorted by Year Making ---");
        for (Map.Entry<Integer, Product> entry : list) {
            System.out.println(entry.getValue());
        }

        scanner.close();
    }
}