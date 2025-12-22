public class Main {

    public static void main(String[] args) {

        ClothingItem item = new ClothingItem(
                "T-Shirt",
                "M",
                20000,
                "Clothes"
        );

        System.out.println(item);
        item.applyDiscount(10);
        System.out.println(item);

        Customer customer = new Customer(
                "Zhandarbek",
                "87788187357",
                "zhandarbek@gmail.com"
        );

        customer.addPoints(100);
        System.out.println(customer);

        Order order = new Order(
                1,
                item.getPrice(),
                "2025-01-22",
                "Completed"
        );

        System.out.println(order);
    }
}
