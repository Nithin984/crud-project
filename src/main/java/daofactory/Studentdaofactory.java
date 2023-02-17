package daofactory;

import persistance.IstudentDao;
import persistance.IstudentDaoImpl;

public class Studentdaofactory {
	
private Studentdaofactory() {}

private static IstudentDao studentDao=null;

public static IstudentDao getstudentDao(){
	if(studentDao==null) {
		
		studentDao=new IstudentDaoImpl();
	}
	return studentDao; 
	
}
}
