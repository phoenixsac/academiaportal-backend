package com.miniproject.courseupdationdeletion.Service;

import com.miniproject.courseupdationdeletion.Exception.CourseNotFoundException;
import com.miniproject.courseupdationdeletion.RequestBody.CourseReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miniproject.courseupdationdeletion.ResponseBody.CourseResponse;
import com.miniproject.courseupdationdeletion.Entities.Courses;
import com.miniproject.courseupdationdeletion.Repository.CoursesRepository;

import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class CourseServiceImpl {

    private final CoursesRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CoursesRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseResponse> getAllCourses() {
        List<Courses> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::mapToResponseModel)
                .collect(Collectors.toList());
    }

    public CourseResponse getCourseById(int courseId) {
        Courses course = new Courses();
        course = courseRepository.findCourseById(courseId);
        if(course==null)
            throw new CourseNotFoundException("Course not found in database");
        else
            return mapToResponseModel(course);
    }


    public Courses createCourse(CourseReqBody courseReqBody) {
        Courses course = new Courses();
        course.setCourseCode(courseReqBody.getCourseCode());
        course.setName(courseReqBody.getCourseName());
        course.setCapacity(courseReqBody.getCourseCapacity());
        course.setCredits(courseReqBody.getCourseCredits());
        course.setDescription(courseReqBody.getCourseDescription());
        course.setTerm(courseReqBody.getCourseTerm());
        course.setYear(courseReqBody.getCourseYear());
        course.setFacultyId(courseReqBody.getCourseFacultyId());
       return courseRepository.save(course);
    }

    public Courses modifyCourse(int courseId, CourseReqBody courseReqBody) {
        Courses course = new Courses();
        course=courseRepository.findCourseById(courseId);

        course.setCourseCode(courseReqBody.getCourseCode());
        course.setName(courseReqBody.getCourseName());
        course.setCapacity(courseReqBody.getCourseCapacity());
        course.setCredits(courseReqBody.getCourseCredits());
        course.setDescription(courseReqBody.getCourseDescription());
        course.setTerm(courseReqBody.getCourseTerm());
        course.setYear(courseReqBody.getCourseYear());
        course.setFacultyId(courseReqBody.getCourseFacultyId());

        return courseRepository.save(course);
    }

    public boolean deleteCourse(int courseId) {

        Optional<Courses> optionalCourse = Optional.ofNullable(courseRepository.findCourseByIdOptionalWrapper(courseId));

        if (optionalCourse.isPresent()) {
            Courses courseToDelete = optionalCourse.get();
            courseRepository.delete(courseToDelete);
            return true;
        } else {
            // Course not found
            return false;
        }
    }


    public CourseResponse mapToResponseModel(Courses course) {
       CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseName(course.getName());
        response.setCourseCode(course.getCourseCode());
        response.setCourseCapacity(course.getCapacity());
        response.setCourseDesc(course.getDescription());
        response.setCourseTerm(course.getTerm());
        response.setCourseYear(course.getYear());

       // Map other properties if needed
        return response;
   }
}
