package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static List<PhoneBook> readFile(File file) throws IOException {



        List<PhoneBook> bookList = new ArrayList<>();
        String[] arr = null;

        if (! file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bf = new BufferedReader(fileReader);
        String line = null;
        while ((line = bf.readLine()) != null) {
            arr = line.split(",");
            String phoneNumber = arr[0];
            String typeGroup = arr[1];
            String name = arr[2];
            String gender = arr[3];
            String address = arr[4];

            PhoneBook phoneBook = new PhoneBook(phoneNumber,typeGroup,new User(name,gender,address));
            bookList.add(phoneBook);
        }

        return bookList;
    }
    private File createFile (){
        File folder = new File("data");
        if(!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(folder,"contacts.csv");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
