package com.cg.associate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.associate.controller.EmployeeController;
import com.cg.associate.entity.Address;
import com.cg.associate.entity.Employee;
import com.cg.associate.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EmployeeService employeeService;

	@Test
	public void viewEmployeeTest1() throws Exception {
		mockMvc.perform(get("/viewEmployee")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json("[]"));
	}

	@Test
	public void deleteEmployee1() throws Exception {
		mockMvc.perform(delete("/deleteEmployee/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Address address = new Address(20, "delhi", "india");
		Employee employee = new Employee(11, "rajesh", 23, 91, address);
		String exampleEmployeeJson = "{       \"empName\" : \"Pradeep M.\",\r\n" + "        \"empAge\" : 23,\r\n"
				+ "        \"countryCode\" : 91,\r\n" + "        \"address\":{\r\n"
				+ "          \"city\" :\"Noida\",\r\n" + "          \"country\": \"India\"\r\n" + "         }\r\n"
				+ "}";
		Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(employee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addEmployee").accept(MediaType.APPLICATION_JSON)
				.content(exampleEmployeeJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	public void deleteTest2() throws Exception {
		String mockResult = "Employee record deleted";
		Mockito.when(employeeService.deleteEmployee(Mockito.anyLong())).thenReturn(mockResult);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteEmployee/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
}
