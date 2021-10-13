package com.flight.info.display.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.flight.info.display.model.Flight;
import com.flight.info.display.util.CSVReader;

@Service
public class FlightService {
	/*
	 * Returns a list of Flight objects, on the input data param
	 */
	public List<Flight> getFlightInfo(String inputDate) {
		List<Flight> flightsOnService = new ArrayList<Flight>();
		String dayOfService = dayOfWeek(inputDate);
		if (dayOfService != null) {
			CSVReader csvReader = new CSVReader();
			List<Flight> flightInfo = csvReader.readCSVInput();
			//Filter the list flightInfo to retrieve only the flights on the input date
			flightsOnService = flightInfo.stream().filter(f->f.getDaysOfService().contains(dayOfService)).collect(Collectors.toList());
			//Sort the list of flights in chronological order
			flightsOnService.sort((f1,f2)->f1.getDeptTime().compareTo(f2.getDeptTime()));
		}
		return flightsOnService;
	}
	
	/*
	 * Returns the day of the week corresponding to the input date param 
	 */
	private String dayOfWeek(String inputDate) {
		try {
			DateTimeFormatter fomater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(inputDate, fomater);
			String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			return dayOfWeek;
		} catch (DateTimeParseException e) {
			System.out.print(e.getMessage());
		}
		return null;
		
	}

}
