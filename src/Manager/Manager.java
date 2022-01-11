package Manager;
import Contact.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    public void displayAllContact() {
        contacts.forEach(System.out::println);
    }

    public Contact createNewFriend() {
        Pattern phonePattern = Pattern.compile("^[0][0-9]{9}&");
        String phone = null;
        boolean checkPhone = false;
        while (!checkPhone) {
            System.out.print("Enter Phone: ");
            phone = scanner.next();
            if (phonePattern.matcher(phone).find()) {
                checkPhone = true;
            } else {
                System.out.println("    ☢ The phone number should be included 10 numbers with 0 first!");
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

        Pattern emailPattern = Pattern.compile("^[a-zA-Z1-9]{1,20}@[a-z]{1,5}.[a-z]{2,3}$");
        String email = null;
        boolean checkEmail = false;
        while (!checkEmail) {
            System.out.print("Enter Email: ");
            email = scanner.next();
            if (emailPattern.matcher(email).find()) {
                checkEmail = true;
            } else {
                System.out.println("    ☢ Email is wrong!");
                System.out.println("    ☢ Example: abc@abc.acb, abc123@abc.abc");
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

            Pattern emailPattern = Pattern.compile("^[a-zA-Z1-9]{1,20}@[a-z]{1,5}.[a-z]{2,3}$");
            String email = null;
            boolean checkEmail = false;
            while (!checkEmail) {
                System.out.print("Enter Email: ");
                email = scanner.next();
                if (emailPattern.matcher(email).find()) {
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
