package com.flight.info.display;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.flight.info.display.controller.FlightController;



@SpringBootTest
@AutoConfigureMockMvc
class FlightinfoDisplayApplicationTests {
	
	@Autowired
	private FlightController flightController;
	@Autowired
	private MockMvc mockMvc;

	
	  @Test 
	  void contextLoads() { 
		  assertNotNull(flightController); 
	  }
	 
	
	
	  @Test 
	  void getFlightServices_InvalidDateFormat_ReturnNoDetails() throws Exception {
		  MvcResult result = this.mockMvc.perform(get("/flights?date=")).andExpect(status().isOk()).andReturn();
		  assertEquals("nodetails", result.getModelAndView().getViewName());
	  }
	  
	  @Test 
	  void getInput_ReturnInput() throws Exception {
		  MvcResult result = this.mockMvc.perform(get("/input")).andExpect(status().isOk()).andReturn();
		  assertEquals("input", result.getModelAndView().getViewName());
	  }
	 
	  	
	@Test
	void getFlightServices_ValidDate_ReturnFlightDetails() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/flights?date=2021-10-12")).andExpect(status().isOk()).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
		assertEquals("flightdetails", result.getModelAndView().getViewName());
	}

}
