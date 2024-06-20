package Session5.run;
import Session5.entity.Categories;
import Session5.entity.Product;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private List<Categories> categoryList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

    public void shopMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------SHOP MENU---------------------------");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    manageCategories(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void manageCategories(Scanner scanner) {
        while (true) {
            System.out.println("---------------------------CATEGORIES MENU---------------------------");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng danh mục cần thêm: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    int nextCatalogId = categoryList.size() + 1;
                    for (int i = 0; i < number; i++) {
                        Categories category = new Categories();
                        category.inputData(scanner, nextCatalogId++);
                        categoryList.add(category);
                    }
                    break;
                case 2:
                    for (Categories category : categoryList) {
                        category.displayData();
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã danh mục cần cập nhật: ");
                    int catalogIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean found = false;
                    for (Categories category : categoryList) {
                        if (category.getCatalogId() == catalogIdToUpdate) {
                            category.inputData(scanner, catalogIdToUpdate);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy mã danh mục.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã danh mục cần xóa: ");
                    int catalogIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean canDelete = true;
                    for (Product product : productList) {
                        if (product.getCatalogId() == catalogIdToDelete) {
                            canDelete = false;
                            break;
                        }
                    }
                    if (canDelete) {
                        categoryList.removeIf(category -> category.getCatalogId() == catalogIdToDelete);
                        System.out.println("Đã xóa danh mục.");
                    } else {
                        System.out.println("Không thể xóa danh mục vì còn sản phẩm thuộc danh mục này.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
                    int catalogIdToChangeStatus = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (Categories category : categoryList) {
                        if (category.getCatalogId() == catalogIdToChangeStatus) {
                            category.setCatalogStatus(!category.isCatalogStatus());
                            System.out.println("Đã cập nhật trạng thái danh mục.");
                            break;
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void manageProducts(Scanner scanner) {
        while (true) {
            System.out.println("---------------------------PRODUCT MANAGEMENT---------------------------");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 0; i < number; i++) {
                        Product product = new Product();
                        product.inputData(scanner, productList, categoryList);
                        productList.add(product);
                    }
                    break;
                case 2:
                    for (Product product : productList) {
                        product.displayData();
                    }
                    break;
                case 3:
                    productList.sort(Comparator.comparing(Product::getPrice));
                    System.out.println("Sản phẩm đã được sắp xếp theo giá.");
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String productIdToUpdate = scanner.nextLine();
                    boolean found = false;
                    for (Product product : productList) {
                        if (product.getProductId().equals(productIdToUpdate)) {
                            product.inputData(scanner, productList, categoryList); // Just pass 0 as index because productId won't change
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy mã sản phẩm.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String productIdToDelete = scanner.nextLine();
                    productList.removeIf(product -> product.getProductId().equals(productIdToDelete));
                    System.out.println("Đã xóa sản phẩm.");
                    break;
                case 6:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String productNameToSearch = scanner.nextLine();
                    for (Product product : productList) {
                        if (product.getProductName().toLowerCase().contains(productNameToSearch.toLowerCase())) {
                            product.displayData();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhập khoảng giá a: ");
                    float priceA = scanner.nextFloat();
                    System.out.print("Nhập khoảng giá b: ");
                    float priceB = scanner.nextFloat();
                    for (Product product : productList) {
                        if (product.getPrice() >= priceA && product.getPrice() <= priceB) {
                            product.displayData();
                        }
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
