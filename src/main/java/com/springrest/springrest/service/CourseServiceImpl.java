package com.springrest.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	public CourseServiceImpl() {
	}

	@Override
	public List<Course> getCourses() {
		// Returns all instances of the type Course
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		/* getOne(Long) is deprecated
		 * return courseDao.getOne(courseId); */
		return courseDao.findById(courseId).orElse(null);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		// list.remove(courseId);
		Course entity = courseDao.findById(courseId).orElse(null);
		if(entity != null)
			courseDao.delete(entity);
		
	}

}


/*
 
 @Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java Course", "this contains basics of java"));
		list.add(new Course(123, "Spring Boot", "how to create rest api using spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;

		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}

		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		Course c = null;

		for (Course c1 : list) {
			if (c1.getId() == course.getId()) {
				c1.setTitle(course.getTitle());
				c1.setDescription(course.getDescription());
				c = c1;
				break;
			}
		}
		return c;
	}

	@Override
	public void deleteCourse(long courseId) {
		// list.remove(courseId);
		list = this.list.stream().filter(e->e.getId() != courseId).collect
				(Collectors.toList());
		
	}

}
 
 
 * */
