package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class MyController {

	/*
	 * We want Spring to create object for CourseService class. Spring will create
	 * object for CourseServiceImp class and would inject in courseService according
	 * to the dependency injection
	 */
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome To Courses Application.";
	}

	// get the course
	@GetMapping("/courses")
	public List<Course> getCourses() {
		// Controller would contact Service Layer!
		return this.courseService.getCourses();
	}

	// to get a single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {

		return this.courseService.getCourse(Long.parseLong(courseId));
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	// updating course using PUT request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

	// delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
/*
 * { "id": 145, "title": "Java Course", "description":
 * "this contains basics of java" }
 * 
 */
