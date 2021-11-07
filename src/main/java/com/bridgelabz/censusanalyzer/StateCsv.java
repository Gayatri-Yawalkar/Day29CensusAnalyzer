package com.bridgelabz.censusanalyzer;
import com.opencsv.bean.CsvBindByName;
public class StateCsv {
	@CsvBindByName(column = "stateName")
	String stateName;
	@CsvBindByName(column = "stateCode")
	String stateCode;
	@Override
	public String toString() {
		return "StateName="+stateName+",StateCode="+stateCode;
	}
}
