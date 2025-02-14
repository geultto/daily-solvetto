import java.util.*;

class ProductOfNumbers {

    private ArrayList<Integer> numList;

    public ProductOfNumbers() {
        numList = new ArrayList<>();
    }
    
    public void add(int num) {
        numList.add(num);
    }
    
    public int getProduct(int k) {
        // Hint 1: Keep all prefix products of numbers in an array, then calculate the product of last K elements in O(1) complexity.
        int product = numList.get(numList.size() - 1);

        for(int i = numList.size() - 2; i >= numList.size() - k ; i--) {
            product *= numList.get(i);

            // Hint 2: When a zero number is added, clean the array of prefix products.
            if(numList.get(i) == 0) {
                product = 0;
                break;
            }
        }

        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */