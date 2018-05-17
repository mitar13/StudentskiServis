package service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import dto.StudentDTO;



import repository.StudentRepository;
import service.interfaces.IStudentService;

/**
Created By Marko
*/

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDTO create(StudentDTO studentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO update(StudentDTO studentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentDTO> getListStudents() {
		
		return studentRepository.findAll().stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
	}
	
}
