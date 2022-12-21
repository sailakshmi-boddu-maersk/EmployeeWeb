package com.slb;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/")
public class EmployeeControllerSevlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EmployeeServiceImpl empServiceImpl;
	
	public void init() {
		
		empServiceImpl= new EmployeeServiceImpl();
		empServiceImpl.connectionDb();
	}
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/insertAddress":
				insertAddress(request,response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Employee> listEmployee = empServiceImpl.selectEmpRecords();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("newEmployeeForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = empServiceImpl.selectEmp(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployeeForm.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		Employee newEmp = new Employee(id,firstName,lastName,salary,addressId);
		boolean isAddExists=empServiceImpl.addressExists(newEmp.addressId);
		if(isAddExists){
			empServiceImpl.createEmpRecord(newEmp);
			response.sendRedirect("list");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("employee",newEmp );
			session.setAttribute("action","insertNewEmp");
			response.sendRedirect("newAddressForm.jsp");
		}
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		Employee emp = new Employee(id,firstName,lastName,salary,addressId);
		
		boolean isAddExists=empServiceImpl.addressExists(emp.addressId);
		if(isAddExists) {
			empServiceImpl.updateEmp(emp);
			response.sendRedirect("list");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("employee",emp );
			session.setAttribute("action","updateExisingEmp");
			response.sendRedirect("newAddressForm.jsp");
		}		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empServiceImpl.deleteEmpRecord(id);
		response.sendRedirect("list");

	}
	private void insertAddress(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		int addressId=Integer.parseInt(request.getParameter("addressId"));
		String address=request.getParameter("address");
		empServiceImpl.insertAddressRecord(addressId, address);
		HttpSession session=request.getSession();
		Employee emp =new Employee();
		emp=(Employee) session.getAttribute("employee");
		String action=(String) session.getAttribute("action");
		if(action=="insertNewEmp")
		empServiceImpl.createEmpRecord(emp);
		else
	    empServiceImpl.updateEmp(emp);
		response.sendRedirect("list");
		
	}
		
	}


