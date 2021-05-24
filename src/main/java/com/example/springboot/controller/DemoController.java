package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class DemoController {

	private EmployeeService employeeService;
	
	@Autowired
	public DemoController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/date")
	public String theDate(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		
		return "the-date";
	}
	
	@GetMapping("/list")
	public String listUser(Model theModel) {
		
		//get list user from db
		List<Employee> listUser = employeeService.findAll();
		theModel.addAttribute("list", listUser);
		
		return "list-user";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String theId) {
		employeeService.deleteById(theId);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("id") String theId, Model model) {
		Employee employee = employeeService.findById(theId);
		
		model.addAttribute("employee", employee);
		
		return "form-update";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormRegistration")
	public String showFormRegistraion(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute(employee);
		
		return "form-registration";
	}
	
}
