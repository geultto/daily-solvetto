/**
정수 스트림을 받아들이고 스트림의 마지막 k 정수의 곱을 구하는 알고리즘을 설계합니다.
    ProductOfNumbers 클래스를 구현합니다.
    ProductOfNumbers() 빈 스트림으로 객체를 초기화합니다. 
    void add(int num) 정수 num을 스트림에 추가합니다. 
    int getProduct(int k) 현재 리스트에서 마지막 k 숫자의 곱을 반환합니다. 
    현재 리스트에는 항상 최소 k개의 숫자가 있다고 가정할 수 있습니다. 
    테스트 케이스는 언제든 연속된 숫자 시퀀스의 곱이 오버플로 없이 단일 32비트 정수에 맞도록 생성
 */
class ProductOfNumbers {
    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = products.size();
        if (k >= size) {
            return 0;
        }
        return products.get(size - 1) / products.get(size - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */