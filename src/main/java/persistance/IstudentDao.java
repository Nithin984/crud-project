package persistance;

import java.io.IOException;
import java.sql.SQLException;

import dto.Student;

public interface IstudentDao {
	public String addStudent(String sname,Integer sage,String saddress) throws ClassNotFoundException, SQLException, IOException;
	public Student searchStudent(Integer sid) throws ClassNotFoundException, SQLException, IOException;
	public String updateStudent(Student student) throws ClassNotFoundException, SQLException, IOException;
	public String deleteStudent(Integer sid) throws ClassNotFoundException, IOException;
}
