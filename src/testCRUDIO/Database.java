package testCRUDIO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import testCRUDIO.Employee;
import testCRUDIO.Koneksi;

public class Database {
	Connection con = null;

	public Database() {
		Koneksi kon = new Koneksi();
		try {
			con = kon.open();
		}catch (SQLException e){
			e.printStackTrace();
		} 
	}

public List<Employee> getAll(){
	List<Employee> result = new ArrayList<Employee>();

	String query ="Select * from employees";
	Statement stmt = null;
	ResultSet rs = null;
	try {
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			Employee emp =new Employee();
			emp.setEmployee_id(rs.getInt("employee_id"));
			emp.setFirst_name(rs.getString("first_name"));
			emp.setLast_name(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhone_number(rs.getString("phone_number"));
			emp.setHire_date(rs.getString("hire_date"));
			emp.setJob_id(rs.getString("job_id"));
			emp.setSalary(rs.getString("salary"));
			emp.setCommission_pct(rs.getString("commission_pct"));
			emp.setManager_id(rs.getString("manager_id"));
			emp.setDepartment_id(rs.getString("department_id"));
			
			result.add(emp);
			
		}
	}catch (SQLException e){
		e.printStackTrace();
	}

	return result;
}
}
