package com.example;

import jakarta.persistence.*;

@Entity//(name = "student_details") annotation is used to mark any class as Entity
//@Table(name = "myStudents")//this annotation is used to change the table properties/details.
public class Student {
    @Id//annotation for mark the column as primary key
    @Column(nullable = false)//annotation used to manipulate column properties/details and specify column mapping.
    @GeneratedValue(strategy = GenerationType.AUTO)//annotation is used to generate values of id automatically.
    private Long student_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String city;
    public Student(Long student_id, String name, String city) {
        super();
        this.student_id = student_id;
        this.name = name;
        this.city = city;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return this.student_id +" "+ this.name+" " +this.city;
    }
}
//@Transient --> it tells hibernate not to save this field.
//@Temporal --> used to tell format of date to hibernate.
//@Lob --> it tells hibernate this is large object.