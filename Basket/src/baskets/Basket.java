package baskets;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Basket implements Basket_Interface {
    public Map<String, Integer> prod = new Hashtable<String, Integer>();

    @Override
    public void addProduct(String product, int quantity) {
        this.prod.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        this.prod.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (this.prod.get(product) != null)
            this.prod.put(product, quantity);
        else System.out.println("такой продукт отсутствует");
    }

    @Override
    public void clear() {
        this.prod.clear();
    }

    @Override
    public List<String> getProducts() {
        ArrayList<String> res = new ArrayList<String>();
        int ii = 0;
        for (Map.Entry entry : this.prod.entrySet()) {
            res.add(ii, entry.getKey().toString() + " " + entry.getValue().toString());
            ii += 1;
        }
        return res;
    }

    @Override
    public int getProductQuantity(String product) {
        int res = 0;
        if (this.prod.get(product) != null)
            res = this.prod.get(product);
        return res;
    }
}