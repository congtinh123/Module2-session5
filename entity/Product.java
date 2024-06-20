package Session5.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    // Constructors
    public Product() {}

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    // Methods
    public void inputData(Scanner scanner, List<Product> productList, List<Categories> categoryList) {
        System.out.print("Enter product ID: ");
        this.productId = scanner.nextLine();
        System.out.print("Enter product name: ");
        this.productName = scanner.nextLine();
        System.out.print("Enter price: ");
        this.price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter description: ");
        this.description = scanner.nextLine();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter created date (dd/MM/yyyy): ");
        try {
            this.created = sdf.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Available categories: ");
        for (Categories category : categoryList) {
            category.displayData();
        }
        System.out.print("Enter catalog ID: ");
        this.catalogId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product status (0: Available, 1: Out of stock, 2: Not for sale): ");
        this.productStatus = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: " + this.price);
        System.out.println("Description: " + this.description);
        System.out.println("Created Date: " + sdf.format(this.created));
        System.out.println("Catalog ID: " + this.catalogId);
        System.out.println("Product Status: " + this.productStatus);
    }
}

