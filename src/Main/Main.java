package Main;
import Contact.Contact;
import Manager.Manager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        int choice;
        do {
            System.out.println("---------------");
            System.out.println("1. Display contact");
            System.out.println("2. Add");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Write to file");
            System.out.println("7. Read from file");
            System.out.println("0. Exit");
            System.out.println("---------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("---------------");
            switch (choice) {
                case 1:
                    System.out.println("1. Display contact");
                    manager.displayAllContact();
                    break;
                case 2:
                    System.out.println("2. Add");
                    Contact contact = manager.createNewFriend();
                    manager.addFriend(contact);
                    break;
                case 3:
                    System.out.println("3. Update");
                    System.out.print("Enter phone that you want to update: ");
                    String updatePhone = scanner.next();
                    manager.updateFriend(updatePhone);
                    break;
                case 4:
                    System.out.println("4. Delete");
                    System.out.print("Enter phone that you want to delete: ");
                    String deletePhone = scanner.next();
                    manager.deleteFriend(deletePhone);
                    break;
                case 5:
                    System.out.println("5. Search");
                    System.out.print("Enter phone that you want to view: ");
                    String viewPhone = scanner.next();
                    manager.searchFriend(viewPhone);
                    break;
                case 6:
                    System.out.println("6. Write to file");
                    System.out.print("Link: ");
                    String writeLink = scanner.next();
                    manager.writeFile(writeLink);
                    break;
                case 7:
                    System.out.println("7. Read from file");
                    System.out.print("Link: ");
                    String readLink = scanner.next();
                    manager.readFile(readLink);
                    break;
            }
        } while (choice != 0);
    }
}
