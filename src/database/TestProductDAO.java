package main;

import database.ProductDAO;

public class TestProductDAO {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        dao.insertProduct(
                "T-Shirt",
                "M",
                7990.0,
                10
        );

        dao.getAllProducts();
    }
}
