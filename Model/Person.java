package Model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private Pattern pattern;
    private Matcher matcher;
    private String name;
    private String Age;
    private String gender;

    public Person() {

    }

    public Person(String name, String Age, String gender) {
        this.name = name;
        this.Age = Age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getAge() {
        return Age;
    }

    public String setAge(String age) {
        this.Age = age;
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void EnterInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter name: ");
        this.name = scanner.nextLine();
        System.out.print("\nEnter Age: ");
        this.Age =scanner.nextLine();
        System.out.print("\nEnter gender: ");
        this.gender = scanner.nextLine();
    }

    public void ShowInfo() {
        System.out.print("\nName: " + this.name + "\nAge: " + this.Age + "\nGender: " + this.gender);
    }
}
