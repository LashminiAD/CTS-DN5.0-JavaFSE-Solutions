// Author: Lashmini A D
// CTS DN 5.0 - Week1 - Exercise02 - E-commerce Search Function

public class EcommerceSearch {

    // Linear - works on unsorted array
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;
            }
        }
        
        return -1;
    }

    // Binary - works ONLY on sorted array
    public static int binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == targetId) {
                return mid;
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}