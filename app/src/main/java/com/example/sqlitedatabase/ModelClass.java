package com.example.sqlitedatabase;

public class ModelClass {
    String name,surname,marks,id;

    public ModelClass(String name, String surname, String marks, String id) {
        this.name = name;
        this.surname = surname;
        this.marks = marks;
        this.id = id;
    }

    public ModelClass() {
    }

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

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
