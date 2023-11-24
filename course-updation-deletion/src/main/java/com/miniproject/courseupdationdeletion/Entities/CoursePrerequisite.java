package com.miniproject.courseupdationdeletion.Entities;

import jakarta.persistence.*;
import com.miniproject.courseupdationdeletion.Entities.Courses;

@Entity
@Table(name="course_prerequisite")
public class CoursePrerequisite {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="course_prereq_id", nullable=false, unique=true)
    private int id;

//    @OneToOne
//    @Column(name="course_id")
//        private int courseId;


    @OneToOne
    @JoinColumn(name = "course_id")  // Specify the name of the foreign key column
    private Courses course;

//    @Column(name="prerequisite_course_id")
//    private int prereqCourseId;

    @OneToOne
    @JoinColumn(name = "prereq_course_id")  // Specify the name of the foreign key column
    private Courses prereqCourse;

    @Column(name="prereq_description")
    private String prereqDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Courses getCourseId() {
        return course;
    }

    public void setCourseId(Courses course) {
        this.course = course;
    }

    public Courses getPrereqCourseId() {
        return prereqCourse;
    }

    public void setPrereqCourseId(int prereqCourseId) {
        this.prereqCourse = prereqCourse;
    }

    public String getPrereqDescription() {
        return prereqDescription;
    }

    public void setPrereqDescription(String prereqDescription) {
        this.prereqDescription = prereqDescription;
    }

}


//    create table course_prerequisite(
//        course__prereq_id INT PRIMARY KEY,
//        course_id smallint,
//        prerequisite_course_id smallint,
//        prereq_description varchar(50)
//);
