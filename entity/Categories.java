package Session5.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    // Constructors
    public Categories() {}

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getters and Setters
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // Methods
    public void inputData(Scanner scanner, int nextCatalogId) {
        System.out.print("Enter catalog name: ");
        this.catalogName = scanner.nextLine();
        System.out.print("Enter descriptions: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Enter catalog status (true/false): ");
        this.catalogStatus = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline left-over

        // Set catalogId
        this.catalogId = nextCatalogId;
    }

    public void displayData() {
        System.out.println("Catalog ID: " + this.catalogId);
        System.out.println("Catalog Name: " + this.catalogName);
        System.out.println("Descriptions: " + this.descriptions);
        System.out.println("Catalog Status: " + (this.catalogStatus ? "Active" : "Inactive"));
    }
}

