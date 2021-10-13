package com.flight.info.display.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.info.display.model.Flight;
import com.flight.info.display.service.FlightService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/input")
	public String getInput() {
		return "input";
	}
	
	@GetMapping(path="/flights")
	public String getFlightServices(@RequestParam(name="date",required=true)String date,Model model) {
		try {
			List<Flight> flightInfo = flightService.getFlightInfo(date);
			if(flightInfo.isEmpty()) {
				return "nodetails";
			}
			model.addAttribute("flights",flightInfo);
			return "flightdetails";
		} catch (Exception ex) {
			return "error";
		}
	}
}
