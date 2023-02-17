package servicefactory;

import service.IstudentService;
import service.IstudentServiceImpl;

public class Studentservicefactory {
private Studentservicefactory() {
}
private static IstudentService studentservice=null;
public static IstudentService getstudentservice() {
	if(studentservice==null) {
		
		studentservice=new IstudentServiceImpl();
	}
	return studentservice;
	
}

}
