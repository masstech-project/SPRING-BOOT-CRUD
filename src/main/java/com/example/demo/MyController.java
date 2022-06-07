package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@Autowired
	Employeedao empdao;
	@ResponseBody
	@RequestMapping("/nikkhat")

	public String welcome()
	{
		System.out.println("Hello");
		return "Hello Nikkhat";
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "index.html";
	}
	@RequestMapping("/reg")
	public String registration()
	{
		return "Registration.jsp";
	}
	@RequestMapping("/show")
	public String showName(@RequestParam("username") String username,@RequestParam("password") String password)
//	public String showName(HttpServletRequest request,HttpServletResponse response)
	{
//		String name=request.getParameter("name");
		System.out.println("Hello "+username);
		if(username.equals("admin")&&(password.equals("admin")))
		{
			return "employeehome.html";
		}
		else
		{
			return "Registration.jsp";
		}
		
	}
	
	@RequestMapping("/regdata")
	public String regData(Employee e)
//	public String regData(@RequestParam("firstname") String firstname,@RequestParam("lastname")String lastname,@RequestParam("department")String department,@RequestParam("email")String email)
	{
		System.out.println("FirstName "+e.getFirstname());
		System.out.println(e.toString());
//		System.out.println("Firstname "+firstname+" LastName "+lastname+" Department "+department+" Email "+email);
		empdao.save(e);
		System.out.println("Record Inserted Successfully");
		return "Registration.jsp";
	}

	/*
	  public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	  {
	     String fname=request.getParameter("firstname");
	  }
	  
	 */
	
	
}
