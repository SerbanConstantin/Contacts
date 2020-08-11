package contacts;

import contacts.model.Contact;
import contacts.model.Organization;
import contacts.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String action = "";
        List<Contact> contactList = new ArrayList<>();
        System.out.println("Enter action (add, remove, edit, count, info, exit):");

        while (!(action = bufferedReader.readLine()).equals("exit")) {
            switch (action) {
                case "count":
                    System.out.print("The Phone Book has " + contactList.size() + " records.");
                    break;

                case "add":
                    System.out.print("Enter the type (person, organization):");
                    Contact contact;
                    switch (bufferedReader.readLine()) {
                        case "person":
                            contact = new Person();
                            System.out.print("Enter the name of the person: ");
                            ((Person) contact).setName(bufferedReader.readLine());
                            System.out.print("Enter the surname of the person: ");
                            ((Person) contact).setSurname(bufferedReader.readLine());
                            System.out.print("Enter the birth date:");
                            ((Person) contact).setBirthdate(bufferedReader.readLine());

                            System.out.print("Enter the gender (M, F):");
                            ((Person) contact).setGender(bufferedReader.readLine());

                            System.out.print("Enter the number:");
                            contact.setPhoneNumber(bufferedReader.readLine());
                            contactList.add(contact);

                            System.out.println("The record created!");
                            break;
                        case "organization":
                            contact = new Organization();
                            System.out.print("Enter the organization name:");
                            ((Organization) contact).setOrganizationName(bufferedReader.readLine());

                            System.out.print("Enter the address:");
                            ((Organization) contact).setAddress(bufferedReader.readLine());

                            System.out.print("Enter the number:");
                            contact.setPhoneNumber(bufferedReader.readLine());
                            contactList.add(contact);

                            contactList.add(contact);

                            System.out.println("The record created!");

                            break;
                    }


                    System.out.println();

                    break;

                case "remove":
                    if (contactList.isEmpty()) {
                        System.out.println("No records to remove!");
                    } else {

                        for (int i = 0; i < contactList.size(); i++) {
                            System.out.println((i + 1) + ". " + contactList.get(i).getInfo());
                        }

                        try {
                            System.out.print("Select a record: ");
                            contactList.remove(Integer.parseInt(bufferedReader.readLine().trim()) - 1);
                        } catch (Exception ex) {
                            System.out.println("Something wrong with removing contacts");
                        }

                    }
                    System.out.println();

                    break;

                case "edit":
                    if (contactList.isEmpty()) {
                        System.out.println("No records to edit!");
                    } else {

                        for (int i = 0; i < contactList.size(); i++) {
                            System.out.println((i + 1) + ". " + contactList.get(i).getInfo());
                        }

                        int index = -1;
                        try {
                            System.out.print("Select a record: ");
                            index = Integer.parseInt(bufferedReader.readLine().trim()) - 1;
                            Contact contactToEdit = contactList.get(index);
                            if(contactToEdit instanceof Person) {
                                System.out.println("Select a field (name, surname, birth, gender, number): ");

                                switch (bufferedReader.readLine()) {
                                    case "name":
                                        System.out.print("Enter name: ");
                                        ((Person) contactToEdit).setName(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "surname":
                                        System.out.print("Enter surname: ");
                                        ((Person) contactToEdit).setSurname(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "birth":
                                        System.out.print("Enter birth date: ");
                                        ((Person) contactToEdit).setBirthdate(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "gender":
                                        System.out.print("Enter gender: ");
                                        ((Person) contactToEdit).setGender(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "number":
                                        System.out.print("Enter number: ");
                                        contactList.get(index).setPhoneNumber(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                }
                            }
                            else {
                                System.out.print("Select a field (name, address, number): ");

                                switch (bufferedReader.readLine()) {
                                    case "name":
                                        System.out.print("Enter name: ");
                                        ((Organization) contactToEdit).setOrganizationName(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "address":
                                        System.out.print("Enter address: ");
                                        ((Organization) contactToEdit).setAddress(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                    case "number":
                                        System.out.print("Enter number: ");
                                        contactList.get(index).setPhoneNumber(bufferedReader.readLine());
                                        contactToEdit.setLastEditDate(LocalDateTime.now());
                                        break;
                                }
                            }

                            System.out.println("The record updated!");
                            System.out.println();

                        } catch (Exception ex) {
                            System.out.println("Something wrong with editing contacts");
                            break;
                        }


                    }
                    break;
                case "info":

                    for (int i = 0; i < contactList.size(); i++) {

                        System.out.println((i + 1) + ". " + contactList.get(i).getInfo());
                    }

                    try {
                        System.out.print("Select a record:");
                        System.out.println(contactList.get(Integer.parseInt(bufferedReader.readLine().trim()) - 1));
                    } catch (Exception ex) {
                        System.out.println("Something wrong with displaying information");
                    }
                    System.out.println();

                    break;


            }

            System.out.println("Enter action (add, remove, edit, count, info, exit):");

        }


    }
}
