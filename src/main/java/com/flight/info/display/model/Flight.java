package com.flight.info.display.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
	private LocalTime deptTime;
	private String destination;
	private String destIata;
	private String flightNo;
	private String daysOfService;
		
	
	public Flight() {
		
	}
	
	public Flight(LocalTime deptTime, String destination, String destIata, String flightNo, String daysOfService) {
		super();
		this.deptTime = deptTime;
		this.destination = destination;
		this.destIata = destIata;
		this.flightNo = flightNo;
		this.daysOfService = daysOfService;
	}


	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestIata() {
		return destIata;
	}

	public void setDestIata(String destIata) {
		this.destIata = destIata;
	}

	public String getDaysOfService() {
		return daysOfService;
	}

	public void setDaysOfService(String daysOfService) {
		this.daysOfService = daysOfService;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public LocalTime getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(LocalTime deptTime) {
		this.deptTime = deptTime;
	}

	@Override
	public String toString() {
		return "Flight [destination=" + destination + ", destIata=" + destIata + ", daysOfService=" + daysOfService
				+ ", flightNo=" + flightNo + ", deptTime=" + deptTime + "]";
	}
	

}
