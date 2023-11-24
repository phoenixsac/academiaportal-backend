package com.miniproject.courseupdationdeletion.Repository;

import com.miniproject.courseupdationdeletion.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    @Query("SELECT c FROM Courses c where c.id=:cid")
    Courses findCourseById(@Param("cid") int cid);

    @Query("SELECT c FROM Courses c where c.id=:cid")
    Courses findCourseByIdOptionalWrapper(@Param("cid") int cid);

  //  void deleteCourseById(int courseId);
    void delete(Courses course);

    boolean existsById(int course_id);
}