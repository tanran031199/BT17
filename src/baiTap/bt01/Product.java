package baiTap.bt01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements Serializable {
    private String id;
    private String name, brand, description;
    private double price;
    public static List<Integer> ids = new ArrayList<>();

    public Product() {
        if(ids.isEmpty()) {
            ids.add(1);
            setId("SP00" + ids.get(0));
        } else {
            ids.add(ids.get(ids.size() - 1) + 1);
            int id = ids.get(ids.size() - 1);

            if(id < 10) {
                setId("SP00" + id);
            } else if(id < 100) {
                setId("SP0" + id);
            } else {
                setId("SP" + id);
            }
        }
    }

    public Product(String name, String brand, String description, double price) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }

    public void addNew(Scanner sc) {
        do {
            System.out.println("Nhập vào tên sản phẩm:");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Tên không được để trống!");
            } else {
                setName(name);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào tên hãng:");
            String brand = sc.nextLine();
            if (brand.isEmpty()) {
                System.err.println("Tên hãng không được để trống!");
            } else {
                setBrand(brand);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào giá sản phẩm:");
            String price = sc.nextLine();
            if (price.isEmpty()) {
                System.err.println("Tên không được để trống!");
            } else {
                setPrice(Float.parseFloat(price));
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào mô tả sản phẩm:");
            String des = sc.nextLine();
            if (des.isEmpty()) {
                System.err.println("Mô tả không được để trống!");
            } else {
                setDescription(des);
                break;
            }
        } while (true);
    }

    public void edit(Scanner sc) {
        do {
            System.out.println("Nhập vào tên sản phẩm:");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                break;
            } else {
                setName(name);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào tên hãng:");
            String brand = sc.nextLine();
            if (brand.isEmpty()) {
                break;
            } else {
                setBrand(brand);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào giá sản phẩm:");
            String price = sc.nextLine();
            if (price.isEmpty()) {
                break;
            } else {
                setPrice(Float.parseFloat(price));
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào mô tả sản phẩm:");
            String des = sc.nextLine();
            if (des.isEmpty()) {
                break;
            } else {
                setDescription(des);
                break;
            }
        } while (true);
    }

    public String display() {
        return "\nMã SP: " + getId() + "\n" +
                "Tên SP: " + getName() + "\n" +
                "Tên hãng: " + getBrand() + "\n" +
                "Giá SP: " + getPrice() + "\n" +
                "Mô tả: " + getDescription() + "\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
