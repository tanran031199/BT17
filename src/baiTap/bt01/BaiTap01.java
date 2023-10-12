package baiTap.bt01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaiTap01 {
    public static List<Product> products = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inMenu = true;
        read();

        do {
            try {
                System.out.println("*********************MENU*********************");
                System.out.println("1. Thêm");
                System.out.println("2. Xem");
                System.out.println("3. Sửa");
                System.out.println("4. Xóa");
                System.out.println("0. Thoát");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        System.out.println();
                        if (products.isEmpty()) {
                            System.out.println("Không có sản phẩm nào trong danh sách!");
                        } else {
                            System.out.println("--------------Danh sách sản phẩm--------------");
                            System.out.println();
                            for (Product p : products) {
                                System.out.println(p.display());
                            }
                            System.out.println("----------------------------------------------");
                        }
                        System.out.println();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        delete();
                        break;
                    case 0:
                        System.out.println("Bạn đã thoát khỏi chương trình!");
                        inMenu = false;
                        break;
                    default:
                        System.err.println("Không có lựa chọn " + choice + ", vui lòng chọn lại!");
                        break;
                }
            } catch (NumberFormatException n) {
                System.err.println("Nhập sai định dạng, nhập lại!");
            }

        } while (inMenu);
    }

    public static void read() {
        File file = new File("src/baiTap/bt01/output.txt");
        if (file.exists() && file.length() > 0) {
            try (
                    FileInputStream inputFile = new FileInputStream(file);
                    ObjectInputStream input = new ObjectInputStream(inputFile);
            ) {
                products = (List<Product>) input.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void write() {
        try (
                FileOutputStream outputFile = new FileOutputStream("src/baiTap/bt01/output.txt");
                ObjectOutputStream output = new ObjectOutputStream(outputFile)
        ) {
            output.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add() {
        if (products.isEmpty()) {
            Product product = new Product();
            product.addNew(sc);
            products.add(product);
        } else {

        }
        write();
    }

    public static void edit() {
        do {
            System.out.println();
            System.out.println("Nhập vào mã sản phẩm cần chỉnh sửa:");
            String id = sc.nextLine();

            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(id)) {
                    index = i;
                }
            }

            if (index != -1) {
                products.get(index).edit(sc);
                write();
                break;
            } else {
                System.err.println("Mã sản phẩm không tồn tại!");
            }
        } while (true);
    }

    public static void delete() {
        do {
            System.out.println();
            System.out.println("Nhập vào mã sản phẩm cần xóa:");
            String id = sc.nextLine();

            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(id)) {
                    index = i;
                }
            }

            if (index != -1) {
                products.remove(index);
                write();
                break;
            } else {
                System.err.println("Mã sản phẩm không tồn tại!");
            }
        } while (true);
    }
}
