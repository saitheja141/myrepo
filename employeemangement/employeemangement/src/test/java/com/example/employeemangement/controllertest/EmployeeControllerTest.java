package com.example.employeemangement.controllertest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.mockito.BDDMockito.given;

import com.example.employeemangement.controller.EmployeesController;
import com.example.employeemangement.model.Department;
import com.example.employeemangement.model.Employee;
import com.example.employeemangement.model.Language;
import com.example.employeemangement.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;

@WebMvcTest(controllers = EmployeesController.class)
public class EmployeeControllerTest {

	 @Autowired                           
	 private MockMvc mockMvc;
	 
	 @MockBean                           
	 private EmployeeService employeeService;
	 
	 
	 private List<Employee> employeesList;
	 
	 private Employee employee;
	 
	 private Department department;
	 
	 @Autowired
	 private ObjectMapper objectMapper;

	 
	 @BeforeEach
	 void setup()
	 {
		 this.employeesList=new ArrayList<>();
		 List<Language> languages=new ArrayList<>();
		 Language langOne=new Language(1, "Algorthims", "Al");
		 Language langTwo=new Language(2, "Data Structures", "DS");
		 languages.add(langOne);
		 languages.add(langTwo);
		 Department department=new Department(1,11,true,LocalDateTime.now(),languages);
		 this.employeesList.add(new Employee(1,department,"saitheja","macharla"));
		 this.employeesList.add(new Employee(2,department,"jayanth","macharla"));
		 employee=new Employee(1,department,"jayanth","macharla");
	 }
	 
	 
	 @Test
	 void getAllEmployees() throws Exception
	 {
		 given(employeeService.getAllEmployees()).willReturn(employeesList);
		 this.mockMvc.perform(get("/employees").with(user("user").password("password")))
		             .andExpect(status().isOk())
		             .andExpect(jsonPath("$.size()",is(employeesList.size())));
		    
	 }
	 
	 @Test
	 void getAllEmployeeById() throws Exception
	 {
		 final int employeeId=1;
//		 List<Language> languages=new ArrayList<>();
//		 Language langOne=new Language(1, "Algorthims", "Al");
//		 Language langTwo=new Language(2, "Data Structures", "DS");
//		 languages.add(langOne);
//		 languages.add(langTwo);
//		 Department department=new Department(1,11,true,LocalDateTime.now(),languages);
//		 final Employee employee = new Employee(1, department,"saitheja","macharla");
		 
		 
		 given(employeeService.getEmployee(employeeId)).willReturn(employee);
		 
		 this.mockMvc.perform(get("/employees/{employeeId}",employeeId).with(user("user").password("password")))
		             .andExpect(status().isOk())
		             .andExpect(jsonPath("$.firstName",is(employee.getFirstName())))
		             .andExpect(jsonPath("$.lastName",is(employee.getLastName())));
		    
	 }
	 
	 @Test
	 @WithMockUser(username = "admin", password = "password", roles = {"ADMIN"})
	 void saveEmployee() throws Exception
	 {		 
		 given(employeeService.saveEmployee(any(Employee.class))).willAnswer((invocation) -> invocation.getArgument(0));
		 
		 this.employee= new Employee(0, department, "saitheja", "macharla");
		 this.mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON_UTF8)
				     .content(objectMapper.writeValueAsString(employee)))
		             .andExpect(status().isCreated())
		             .andExpect(jsonPath("$.firstName",is(employee.getFirstName())))
		             .andExpect(jsonPath("$.lastName",is(employee.getLastName())));
		    
	 }
	 
	/** @Test
	    void shouldReturn404WhenFindUserById() throws Exception {
		    final int employeeId=1;
		    
		    given(employeeService.getEmployee(employeeId));

	        this.mockMvc.perform(get("/employees/{employeeId}",employeeId))
	                .andExpect(status().isNotFound());
	    }**/
	 

	 @Test
	 @WithMockUser(username = "admin", password = "password", roles = {"ADMIN"})
	 void deleteEmployee() throws Exception
	 {
		 final int employeeId=1;
		 
		 given(employeeService.getEmployee(employeeId)).willReturn(employee);
		 doReturn(true).when(employeeService).deleteEmployee(employee.getEmployeeId());

	        this.mockMvc.perform(delete("/employees/{employeeId}", employee.getEmployeeId()))
	                .andExpect(status().isOk())
	                .andExpect(content().string("true"));
		    
	 }
	
}
