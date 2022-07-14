package com.gls.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gls.studentcrud.entity.Student;
import com.gls.studentcrud.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// add mapping for "/list"	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		// get Students from db
		List<Student> students = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", students);
		
		return "list-students";

	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model theModel) {

		// get the Student from the service
		Student student = studentService.findById(id);
		

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", student);
		
		// send over to our form
		return "student-form";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addBook(Model model) {
		// create model attribute to bind form data
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";

	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,@RequestParam("firstName") String firstName, 
								@RequestParam("lastName") String lastName,@RequestParam("course") String course,
								@RequestParam("country") String country) {
		Student student;
		if(id!=0) {
			
			student=studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
			studentService.save(student);
		}
		else {
			student=new Student(firstName, lastName, course, country);
		}
		studentService.save(student);
		return "redirect:/student/list";

}
}
