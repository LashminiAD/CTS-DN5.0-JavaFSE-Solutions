// Author: Lashmini A D
// CTS DN 5.0 - Week1 - Exercise02 - E-commerce Search Function

public class Main {
    public static void main(String[] args) {

        // Unsorted array - for linear search
        Product[] unsortedProducts = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(102, "Office Chair", "Furniture"),
            new Product(108, "Notebook", "Stationery"),
            new Product(101, "Bluetooth Speaker", "Electronics")
        };

        // Sorted array (by productId) - for binary search
        Product[] sortedProducts = {
            new Product(101, "Bluetooth Speaker", "Electronics"),
            new Product(102, "Office Chair", "Furniture"),
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(108, "Notebook", "Stationery")
        };

        int targetId = 105;

        // Linear Search
        int linearResult = EcommerceSearch.linearSearch(unsortedProducts, targetId);
        if (linearResult != -1)
            System.out.println("Linear Search: Product found at index " + linearResult 
                + " -> " + unsortedProducts[linearResult].productName);
        else
            System.out.println("Linear Search: Product not found.");

        // Binary Search
        int binaryResult = EcommerceSearch.binarySearch(sortedProducts, targetId);
        if (binaryResult != -1)
            System.out.println("Binary Search: Product found at index " + binaryResult 
                + " -> " + sortedProducts[binaryResult].productName);
        else
            System.out.println("Binary Search: Product not found.");
    }
}