package contacts.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person extends Contact{

    private String name;
    private String surname;
    private char gender;
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        if((gender !='M') && (gender!='F')) {
            return "[no data]";
        }
        return gender + "";
    }

    public void setGender(String gender) {
        switch (gender) {
            case "M":
                this.gender = 'M';
                break;
            case "F":
                this.gender = 'F';
                break;
            default:
                System.out.println("Bad gender!");
        }
//        this.gender = gender;
    }

    public String getBirthdate() {
        if(birthdate == null) {
            return "[no data]";
        }
        return birthdate.toString();
    }

    public void setBirthdate(String birthdate) {
        try {

            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
            this.birthdate = date;
        }
        catch (Exception ex) {
            System.out.println("Bad birth date!");
        }

    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSurname: " + getSurname() +
                "\nBirth date: " + getBirthdate() +
                "\nGender: " + getGender() + super.toString();

    }

    @Override
    public String getInfo() {
        return getName() + " " + getSurname();
    }
}