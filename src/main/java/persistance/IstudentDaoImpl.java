package persistance;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.jdbcUtil;
import dto.Student;

public class IstudentDaoImpl implements IstudentDao {

	@Override
	public String addStudent(String sname, Integer sage, String saddress) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection connection=jdbcUtil.jdbcconnection();
		String Query="insert into student(sname,sage,saddress) values(?,?,?)";
		PreparedStatement pst=connection.prepareStatement(Query);
		pst.setString(1, sname);
		pst.setInt(2, sage);
		pst.setString(3,saddress);
		int row=pst.executeUpdate();
		if(row==1) {
			return "success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public Student searchStudent(Integer sid) throws ClassNotFoundException, IOException {
		Connection connection = null;
		Student std=null;
		try {
			connection = jdbcUtil.jdbcconnection();
	
	
	String Query="select sid,sname,sage,saddress from student where sid=?";
	PreparedStatement pst = null;
	
		pst = connection.prepareStatement(Query);
	pst.setInt(1, sid);
	
	ResultSet result =pst.executeQuery();
	
		if(std==null) {
		if(result.next()) {
			 std=new Student();
			 std.setSid(result.getInt(1));
			std.setSname(result.getString(2));
			std.setSage(result.getInt(3));
			std.setSaddress(result.getString(4));
			System.out.println(std.getSadress());
			return std;
		}
		}
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return std;
	
	}

	@Override
	public String updateStudent(Student student) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		String message=null;
		Connection connection =null;
		connection = jdbcUtil.jdbcconnection();
		try {
			String Query="update student set sname=?,sage=?,saddress=? where sid=?";
			PreparedStatement pst=connection.prepareStatement(Query);
			pst.setString(1, student.getSname());
			pst.setInt(2, student.getSage());
			pst.setString(3, student.getSadress());
			pst.setInt(4, student.getSid());
			int num=pst.executeUpdate();
			if (num==1) {
				message="success";
			}
			else {
				message="failed";
			}	
		}
catch(Exception e) {		
	e.printStackTrace();
}
		return message;
	}

	@Override
	public String deleteStudent(Integer sid) throws ClassNotFoundException, IOException {
		Connection connection = null;
	int result = 0;
		try {
			connection = jdbcUtil.jdbcconnection();
	
	
	String Query="delete from student where sid=?";
	PreparedStatement pst = null;
	
		pst = connection.prepareStatement(Query);
	pst.setInt(1, sid);
	
	 result =pst.executeUpdate();
			}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if(result==1) {
			return "success"; 
				
		}
		else {
			return "failure";
		}

	
	
	}

}
