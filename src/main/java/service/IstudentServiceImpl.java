package service;

import java.io.IOException;
import java.sql.SQLException;

import daofactory.Studentdaofactory;
import dto.Student;
import persistance.IstudentDao;

public class IstudentServiceImpl implements IstudentService{
private IstudentDao stdao=null;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) throws ClassNotFoundException, SQLException, IOException {
		stdao=Studentdaofactory.getstudentDao();
		return stdao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) throws ClassNotFoundException, SQLException, IOException {
		stdao=Studentdaofactory.getstudentDao();
		return stdao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) throws ClassNotFoundException, SQLException, IOException {
		stdao=Studentdaofactory.getstudentDao();
		return stdao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) throws ClassNotFoundException, IOException {
		stdao=Studentdaofactory.getstudentDao();
		
		return stdao.deleteStudent(sid);
	}

}
