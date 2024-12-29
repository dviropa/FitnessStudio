package gym.customers.person;

import gym.DateUtils;

import java.util.List;

public class Person {
    private static int counter = 1111;
    private String dateOfBirth;
    private String name;
    private Balance money;
    private Gender gender;
    private Integer id;
    private int age;

    private List<String> notifictionsList;

    public List<String> getNotifictionsList() {
        return notifictionsList;
    }

    public Person(String name, int x, Gender gender, String dateOfBirth) {
        this.name = name;
        this.money = new Balance(x);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        setid();
    }

    private void setid() {
        id = counter++;
    }

    public Person(Person person) {
        this.name = person.getName();
        this.money = person.money;
        this.gender = person.getGender();
        this.dateOfBirth = person.dateOfBirth;
        this.id = person.getid();
    }

    public int getid() {
        return id;
    }

    public boolean equals(Person person) {
        return this.id == person.getid();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money.getBalance();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getage() {
        age();
        return age;
    }

    private void age() {
        age = DateUtils.calculateAge(this.getDateOfBirth());
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
//            LocalDate birthDate = LocalDate.parse(this.getDateOfBirth(), formatter);
//            LocalDate currentDate = LocalDate.now();
//             age= Period.between(birthDate, currentDate).getYears();
//        } catch (DateTimeParseException e) {
//            System.out.println("Invalid date format: " + this.getDateOfBirth());
//        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id.equals(person.id); // השוואה לפי ת"ז
    }

    public void setMoney(int x) {
        money.setBalance(x);
    }
}

