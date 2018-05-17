package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import dto.StudentDTO;
import service.interfaces.IStudentService;





	@Controller
	@RequestMapping("/student")
	public class StudentController {
		
		@Autowired
		IStudentService studentService;
		
		@RequestMapping("/all")
		public ModelAndView taxies() {
			ModelAndView mav= new ModelAndView("student/students");
			mav.addObject("students",studentService.getListStudents());
			return mav;
		}
		@RequestMapping("/save")
		public ModelAndView save() {
			ModelAndView mav = new ModelAndView("student/saveStudent");
			mav.addObject("student", new StudentDTO());
			return mav;
		}
		/*@RequestMapping(path = "/save", method = RequestMethod.POST)
		public View save(@ModelAttribute("driver") StudentDTO studentDTO) {
			studentService.save(studentDTO);
			return new RedirectView("all");
		}*/
		
	}


