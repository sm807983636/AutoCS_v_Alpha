package com.joc.dao;

import com.joc.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao extends BaseDao<Course> {
    private final String GET_COURSE_BY_COURSEMAJOR = "from Course c where c.courseMajor = ?";

    public List<Course> getCourseByCourseMajor(String courseMajor){
        List<Course> courses = (List<Course>)find(GET_COURSE_BY_COURSEMAJOR, courseMajor);
        if (courses.size() == 0) {
            return null;
        }else{
            return courses;
        }
    }
}
