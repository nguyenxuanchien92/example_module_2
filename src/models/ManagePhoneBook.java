package models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagePhoneBook implements Validate {
    public Scanner sc = new Scanner(System.in);
    public String choice = "";
    public static List<PhoneBook> bookList = new ArrayList<>();

    public void showMenu() {
        do {
            createMenu();
        } while (choice != "8");
    }

    private void createMenu() {
        System.out.println("---------Danh bạ điện thoại---------");
        System.out.println("1.Hiển thị danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xoá");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
        System.out.print("Chọn chức năng: ");

        choice = sc.nextLine();
        String regex = "[0-8]";
        boolean result = isValidate(regex, choice);
        if (result) {
            switch (choice) {
                case "1":
                    showListUser();
                    break;
                case "2":
                    addPhoneBook();
                    break;
                case "3":
                    System.out.println("Cập nhật");
                    break;
                case "4":
                    System.out.println("Xoá");
                    break;
                case "5":
                    System.out.println("Tìm kiếm ");
                    break;
                case "6":
                    System.out.println("Đọc ghi từ file");
                    break;
                case "7":
                    System.out.println("Ghi vào file");
                    break;
                case "8":
                    System.out.println("---------Chương trình kết thúc---------");
                    System.exit(0);
            }
        } else {
            System.out.println("Bạn nhập sai\n");
        }
    }

    private void addPhoneBook() {
        System.out.println("------Thêm danh bạ----");
        System.out.println("Số điện thoại");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhóm của danh bạ");
        String typeGroup = sc.nextLine();
        System.out.println("Họ tên");
        String name = sc.nextLine();
        System.out.println("Địa chỉ");
        String address = sc.nextLine();

        //check dob
//        String regexDOB = "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";
//        System.out.println("Ngày sinh");
//        String dob = sc.nextLine();
//        boolean resultDOB = isValidate(regexDOB, dob);
//        if (! resultDOB) {
//            System.out.println("không hợp lệ");
//            addPhoneBook();
//        }
        boolean resultDOB = checkDOB();
        if (! resultDOB) {
            addPhoneBook();
        }

        boolean resultEmail = checkEmail();
        if (! resultEmail) {
            addPhoneBook();
        }
        //check email

//        String regexEmail = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
//        System.out.println("Email");
//        String email = sc.nextLine();
//        boolean resultEmail = isValidate(regexEmail, email);
//        if (! resultEmail) {
//            System.out.println("không hợp lệ");
//            addPhoneBook();
//        }
    }

    private boolean checkDOB() {
        String regexDOB = "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";
        System.out.println("Ngày sinh");
        String dob = sc.nextLine();
        boolean resultDOB = isValidate(regexDOB, dob);
        if (! resultDOB) {
            System.out.println("không hợp lệ");
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        String regexEmail = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        System.out.println("Email");
        String email = sc.nextLine();
        boolean resultEmail = isValidate(regexEmail, email);
        if (! resultEmail) {
            System.out.println("không hợp lệ");
            return false;
        }
        return true;
    }

    private void showListUser() {

        List<PhoneBook> bookList = null;
        try {
            File file = new File("contacts.csv");
            if (! file.exists()) {
                file.createNewFile();
            }
            bookList = IOFile.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bookList);
    }

    @Override
    public boolean isValidate(String regex, String input) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.matches();
        if (result)
            return true;
        return false;
    }
}
