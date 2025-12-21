public class Main {
    public static void main(String[] args) {

        // ===== ClothingItem =====
        ClothingItem item = new ClothingItem(
                "T-Shirt",
                "M",
                20000
        );

        System.out.println(item);
        item.applyDiscount(10);
        System.out.println(item);

        // ===== Customer =====
        Customer customer = new Customer(
                "Zhandarbek",
                "87788187357"
        );

        customer.addPoints(100);
        System.out.println(customer);

        // ===== Order =====
        Order order = new Order(
                1,
                item.getPrice()
        );

        System.out.println(order);
    }
}
