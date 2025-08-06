import java.util.Scanner;

public class Product {
    private static int autoId = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
        this.productId = autoId++;
    }

    public Product(String productName, float price, String category, int quantity) {
        this.productId = autoId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner, boolean checkDuplicate, java.util.List<Product> productList) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên phải từ 10 đến 50 ký tự.");
                continue;
            }
            if (checkDuplicate && productList.stream().anyMatch(p -> p.getProductName().equalsIgnoreCase(name))) {
                System.out.println("Tên sản phẩm đã tồn tại.");
                continue;
            }
            this.productName = name;
            break;
        }

        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm (> 0): ");
                float inputPrice = Float.parseFloat(scanner.nextLine());
                if (inputPrice <= 0) throw new NumberFormatException();
                this.price = inputPrice;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập loại sản phẩm (≤ 200 ký tự): ");
            String cat = scanner.nextLine();
            if (cat.length() > 200) {
                System.out.println("Danh mục quá dài.");
                continue;
            }
            this.category = cat;
            break;
        }

        while (true) {
            try {
                System.out.print("Nhập số lượng tồn kho (≥ 0): ");
                int qty = Integer.parseInt(scanner.nextLine());
                if (qty < 0) throw new NumberFormatException();
                this.quantity = qty;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %s | Giá: %.2f | Danh mục: %s | Tồn kho: %d",
                productId, productName, price, category, quantity);
    }
}
