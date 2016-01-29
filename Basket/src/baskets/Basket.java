package baskets;

import java.util.*;

public class Basket implements Basket_Interface {
    public Map<String, Integer> basket = new Hashtable<String, Integer>();

    @Override
    public void addProduct(String product, int quantity) {
        this.basket.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        this.basket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (this.basket.get(product) != null)
            this.basket.put(product, quantity);
        else System.out.println("такой продукт отсутствует");
    }

    @Override
    public void clear() {
        this.basket.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> result = new ArrayList<String>();
        result.addAll(this.basket.keySet());
        return result;
    }

    @Override
    public int getProductQuantity(String product) {
        int res = 0;
        if (this.basket.get(product) != null)
            res = this.basket.get(product);
        return res;
    }
}