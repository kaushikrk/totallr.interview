package com.totallr.demo.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class User {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 4
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    Integer id;
    String name;
    Integer age;
    String address;
    String profession;

    @Transient
    public ArrayList<String>professions = new ArrayList<>() {{
        add("Web Developer");
        add("Data Scientist");
        add("Designer");
        add("App Developer");
    }};

    public void setName (String _name) {
        this.name = _name;
    }

    public void setAge (Integer _age) {
        this.age = _age;
    }

    public void setAddress (String _address) {
        this.address = _address;
    }

    public  void setProfession (String _profession) {
        this.profession = _profession;
    }

    public String getName () {
        return this.name;
    }

    public Integer getAge () {
        return  this.age;
    }

    public String getAddress () {
        return this.address;
    }

    public String getProfession () {
        return this.profession;
    }

    @Override
    public String toString() {
        return "User Details : \nName: "+getName()+"\nAge: "+getAge()+"\nAddress: "+getAddress()+"\nProfession: "+getProfession()+"\n";
    }
}
