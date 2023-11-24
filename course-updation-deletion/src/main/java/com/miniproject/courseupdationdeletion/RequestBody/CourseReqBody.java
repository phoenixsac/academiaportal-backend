package com.miniproject.courseupdationdeletion.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@NoArgsConstructor
@AllArgsConstructor

public class CourseReqBody {

    @JsonProperty("course_code")
    private String courseCode;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_description")
    private String courseDescription;

    @JsonProperty("course_year")
    private int courseYear;

    @JsonProperty("course_term")
    private String courseTerm;

    @JsonProperty("course_credits")
    private int courseCredits;

    @JsonProperty("course_capacity")
    private int courseCapacity;

    @JsonProperty("course_faculty_id")
    private int courseFacultyId;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public int getCourseFacultyId() {
        return courseFacultyId;
    }

    public void setCourseFacultyId(int courseFacultyId) {
        this.courseFacultyId = courseFacultyId;
    }


}





//    {
//        course_code:"SS-002",
//                course_name:"ESD",
//            course_description:"Full Stack development",
//            course_year:2023,
//            course_term:"6 months"
//        course_credits:5,
//                course_capacity:25,
//            course_faculty_id:3
//    }

