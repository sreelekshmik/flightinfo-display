package com.flight.info.display.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.flight.info.display.model.Flight;

/*
 * Utility class to read the input CSV file
 * 
 */
public class CSVReader {
	@Autowired
	ResourceLoader resouceLoader;
	
	/*
	 * Reads the input CSV file present in the resources folder
	 * and returns a list of Flight objects
	 */
	public List<Flight> readCSVInput() {
		List<Flight> flightInfo = new ArrayList<Flight>();
		try {
			Resource resource = new ClassPathResource("flights.csv");
			if(resource != null) {
				InputStream inputStream = resource.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				CSVParser csvParser = new CSVParser(reader, 
								CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
				Iterable<CSVRecord> csvRecords = csvParser.getRecords();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				for (CSVRecord csvRecord : csvRecords) {
					Flight flight = new Flight();
					flight.setDeptTime(LocalTime.parse(csvRecord.get("Departure Time"),formatter));
					flight.setDestination(csvRecord.get("Destination"));
					flight.setDestIata(csvRecord.get("Destination Airport IATA"));
					flight.setFlightNo(csvRecord.get("Flight No"));
					StringJoiner stringJoiner = new StringJoiner(",");
					if(!csvRecord.get("Sunday").isEmpty())
						stringJoiner.add("Sunday");
					if(!csvRecord.get("Monday").isEmpty())
						stringJoiner.add("Monday");
					if(!csvRecord.get("Tuesday").isEmpty())
						stringJoiner.add("Tuesday");
					if(!csvRecord.get("Wednesday").isEmpty())
						stringJoiner.add("Wednesday");
					if(!csvRecord.get("Thursday").isEmpty())
						stringJoiner.add("Thursday");
					if(!csvRecord.get("Friday").isEmpty())
						stringJoiner.add("Friday");
					if(!csvRecord.get("Saturday").isEmpty())
						stringJoiner.add("Saturday");
					flight.setDaysOfService(stringJoiner.toString());
					flightInfo.add(flight);
				}
				csvParser.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flightInfo;	
	}
}
