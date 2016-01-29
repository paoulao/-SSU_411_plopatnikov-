package baskets;

import java.util.Scanner;

public class Basket_solution {
    public static void main(String[] args) {
        System.out.println("1 - добавить продукт");
        System.out.println("2 - удалить продукт");
        System.out.println("3 - изменить количество продукта");
        System.out.println("4 - очистить корзину");
        System.out.println("5 - вывести список продуктов в корзине");
        System.out.println("6 - получить количество продуктов");

        Basket basket = new Basket();
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            Scanner in1 = new Scanner(System.in);
            String str;
            Scanner in2 = new Scanner(System.in);
            int num;
            if (s.equals("1")) {
                System.out.println("введите название продукта");
                str = in1.nextLine();
                str.toString();
                System.out.println("введите количество продукта");
                num = in2.nextInt();
                basket.addProduct(str, num);
            } else if (s.equals("2")) {
                System.out.println("введите название продукта");
                str = in1.nextLine();
                basket.removeProduct(str);
            } else if (s.equals("3")) {
                System.out.println("введите название продукта");
                str = in1.nextLine();
                System.out.println("введите количество продукта");
                num = in2.nextInt();
                basket.updateProductQuantity(str, num);
            } else if (s.equals("4"))
                basket.clear();
            else if (s.equals("5"))
                System.out.println(basket.getProducts());
            else if (s.equals("6")) {
                System.out.println("введите название продукта");
                str = in1.nextLine();
                System.out.println(basket.getProductQuantity(str));
            } else System.out.println("выберите из списка");
        }
    }
}