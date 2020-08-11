package contacts.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Pattern;

public class Contact {

    private LocalDateTime creationDate;
    private LocalDateTime lastEditDate;

    private String phoneNumber;

    public Contact() {
        creationDate = LocalDateTime.now();
        lastEditDate = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        if (phoneNumber.equals("")) {
            return "[no number]";
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {


        String[] split = phoneNumber.split("[- ]+");
        if (phoneNumber.length() >= 1 && phoneNumber.contains("+") && !phoneNumber.startsWith("+")) {
            this.phoneNumber = "";
            System.out.println("Wrong number format!");
            return;
        }

        int countleft = 0;
        int countright = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) == '(') {
                countleft++;
            } else if (phoneNumber.charAt(i) == ')') {
                countright++;
            }
        }

        if (countleft > 1 || countright > 1) {
            this.phoneNumber = "";
            System.out.println("Wrong number format!");
            return;
        }
        if (split.length == 1) {
            String group = split[0];
            group = group.replace("+", "");
            group = group.replace("(", "");
            group = group.replace(")", "");
            if (group.length() > 0) {
                // ok
                if (!Pattern.matches("[0-9A-Za-z]+", group)) {
                    this.phoneNumber = "";
                    System.out.println("Wrong number format!");
                    return;
                }
            } else {
                this.phoneNumber = "";
                System.out.println("Wrong number format!");
                return;
            }
        } else {
            if (split.length > 2) {
                for (int i = 2; i < split.length; i++) {
                    if (split[i].contains("(") || split[i].contains(")")) {
                        this.phoneNumber = "";
                        System.out.println("Wrong number format!");
                        return;
                    }
                }
            }

            for (int i = 0; i < split.length; i++) {
                String group = split[i];
                if (
                        (group.contains("(") && !group.contains(")"))
                                ||
                                (!group.contains("(") && group.contains(")"))) {
                    this.phoneNumber = "";
                    System.out.println("Wrong number format!");
                    return;
                }
                group = group.replace("(", "");
                group = group.replace(")", "");
                group = group.replace("+", "");
                if ((i > 0) && (group.length() < 2)) {
                    this.phoneNumber = "";
                    System.out.println("Wrong number format!");
                    return;
                }
                if (!Pattern.matches("[0-9A-Za-z]+", group)) {
                    this.phoneNumber = "";
                    System.out.println("Wrong number format!");
                    return;
                }
            }
        }

        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @Override
    public String toString() {
        return
                "\nNumber: " + getPhoneNumber() +
                        "\nTime created: " + getCreationDate() +
                        "\nTime last edit: " + getLastEditDate();
    }

    public String getInfo() {
        return "";
    }
}