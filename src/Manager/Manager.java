package Manager;
import Contact.Contact;
import Regex.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    Regex regex = new Regex();
    public void displayAllContact() {
        contacts.forEach(System.out::println);
    }

    public Contact createNewFriend() {
        String phone = null;
        boolean checkPhone = false;
        while (!checkPhone) {
            System.out.print("Enter Phone: ");
            phone = scanner.next();
            if (regex.checkPhone(phone)) {
                checkPhone = true;
            }
        }


        System.out.print("Enter Group:");
        String group = scanner.next();

        scanner.nextLine();
        System.out.print("Enter Name:");
        String name = scanner.nextLine();

        System.out.print("Enter Gender:  1. Male  |  2. Female");
        System.out.print("-------- Your choice: ");
        int choiceGender = scanner.nextInt();
        String gender = null;
        switch (choiceGender) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
        }

        System.out.print("Enter Address:");
        String address = scanner.next();

        System.out.print("Enter Birthday:");
        String birthday = scanner.next();

        String email = null;
        boolean checkEmail = false;
        while (!checkEmail) {
            System.out.print("Enter Email: ");
            email = scanner.next();
            if (regex.checkEmail(email)) {
                checkEmail = true;
            }
        }

        return new Contact(phone, group, name, gender, address, birthday, email);
    }

    public void addFriend(Contact contact) {
        contacts.add(contact);
    }

    public void updateFriend(String phone) {
        Contact contact = null;
        for (Contact c: contacts) {
            if (c.getPhone().equals(phone)) {
                contact = c;
            }
        }
        if (contact != null) {
            int index = contacts.indexOf(contact);
            System.out.print("Re-Enter Group:");
            String group = scanner.next();
            contact.setGroup(group);

            scanner.nextLine();
            System.out.print("Re-Enter Name:");
            String name = scanner.nextLine();
            contact.setName(name);

            System.out.print("Re- Enter Gender:  1. Male  |  2. Female");
            System.out.print("-------- Your choice: ");
            int choiceGender = scanner.nextInt();
            String gender = null;
            switch (choiceGender) {
                case 1:
                    gender = "Male";
                    break;
                case 2:
                    gender = "Female";
                    break;
            }
            contact.setGender(gender);

            System.out.print("Re-Enter Address:");
            String address = scanner.next();
            contact.setAddress(address);

            System.out.print("Re-Enter Birthday:");
            String birthday = scanner.next();
            contact.setBirthday(birthday);

            String email = null;
            boolean checkEmail = false;
            while (!checkEmail) {
                System.out.print("Re-Enter Email: ");
                email = scanner.next();
                if (regex.checkEmail(email)) {
                    checkEmail = true;
                }
            }
            contact.setEmail(email);
        }
    }

    public void deleteFriend(String phone) {
        Contact contact = null;
        for (Contact c: contacts) {
            if (c.getPhone().equals(phone)) {
                contact = c;
            }
        }
        if (contact != null) {
            contacts.remove(contact);
        }
    }

    public void searchFriend(String phone) {
        Contact contact = null;
        for (Contact c: contacts) {
            if (c.getPhone().equals(phone)) {
                contact = c;
            }
        }
        if (contact != null) {
            System.out.println(contact);
        }
    }

    public void writeFile(String pathName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathName));
            for (Contact c: contacts) {
                bufferedWriter.write(c.display());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println(" Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> readFile(String pathName) {
        ArrayList<Contact> contact1 = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strings = line.split(",");
                String phone = strings[0];
                String group = strings[1];
                String name = strings[2];
                String gender = strings[3];
                String address = strings[4];
                String birthday = strings[5];
                String email = strings[6];
                contact1.add(new Contact(phone, group, name, gender, address, birthday, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        contacts = contact1;
        return contact1;
    }
}
