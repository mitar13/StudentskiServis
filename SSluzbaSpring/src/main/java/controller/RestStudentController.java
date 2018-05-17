package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.StudentDTO;
import service.interfaces.IStudentService;

/**
Created By Marko
*/

@RestController
@RequestMapping("/api/student")
public class RestStudentController {
	
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("/all")
	public List<StudentDTO> getStudents() {
		
		return studentService.getListStudents();
		
	}

}
