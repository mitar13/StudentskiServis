package service.interfaces;

import java.util.List;

import dto.StudentDTO;

/**
Created By Marko
*/

public interface IStudentService {
	
	StudentDTO create(StudentDTO studentDto);
	
	StudentDTO update(StudentDTO studentDto);
	
	List<StudentDTO> getListStudents();
	
	boolean delete(int id);
	

}
