package com.bridgelabz.censusanalyzer;
import com.opencsv.bean.CsvBindByName;
public class CsvStateCensus {
	@CsvBindByName(column = "stateName")
	String stateName;
	@CsvBindByName(column = "stateCode")
	String stateCode;
	@CsvBindByName(column = "population")
	int population;
	@Override
	public String toString() {
		return "StateName="+stateName+",StateCode="+stateCode+",Popoulation="+population;
	}
}
