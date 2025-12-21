public class ClothingItem {

    // Киімнің атауы
    private String name;

    // Киімнің өлшемі (S, M, L)
    private String size;

    // Киімнің бағасы
    private double price;

    // Конструктор – объект жасағанда мән береміз
    public ClothingItem(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    // Жеңілдік беру
    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
    //бағасын есептеу
    public double getPrice() {
        return price;
    }

    // Экранға шығару
    public String toString() {
        return "Name: " + name +
                ", Size: " + size +
                ", Price: " + price;
    }
}




