package com.paargav.spring_boot_task.user;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;

    private String name;
    private int age;
    private String address;
    private String profession;

    @Transient
    public ArrayList<String>professionValues = new ArrayList<>() {{
        add("Frontend Developer");
        add("Backend Developer");
        add("UI/UX Designer");
        add("Tester");
    }};




    public User(String name, int age, String address, String profession) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.profession = profession;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
