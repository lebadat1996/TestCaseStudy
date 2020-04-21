package Model;

import java.util.Scanner;

public class Employee extends Person {
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String salary;
    private String dateOfBirth;

    public Employee() {

    }

    public Employee( String Address, String PhoneNumber, String Email, String salary, String dateOfBirth) {
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public String setAddress(String address) {
        this.Address = address;
        return address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String setEmail(String email) {
        Email = email;
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String setSalary(String salary) {
        this.salary = salary;
        return salary;
    }

    public void EnterInfo() {
        Scanner scanner = new Scanner(System.in);
        super.EnterInfo();
        System.out.print("\nEnter Address: ");
        this.Address = scanner.nextLine();
        System.out.print("\nEnter DateOfBirth: ");
        this.dateOfBirth = scanner.nextLine();
        System.out.print("\nEnter PhoneNumber: ");
        this.PhoneNumber = scanner.nextLine();
        System.out.print("\nEnter Email: ");
        this.Email = scanner.nextLine();
        System.out.print("\nEnter salary: ");
        this.salary = scanner.nextLine();
    }

    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("\nAddress: " + this.Address + "\nDatOfBirth: " + this.dateOfBirth +
                "\nPhoneNumber: " + this.PhoneNumber + "\nEmail: "
                + this.Email + "\nSalary: " + this.salary
        );
    }
}
