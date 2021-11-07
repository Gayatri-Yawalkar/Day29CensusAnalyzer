package com.bridgelabz.censusanalyzer;
public class IndiaStateCode {
	String stateName;
	String stateCode;
	Integer population;
	public IndiaStateCode(String stateName,String stateCode,int population) {
		this.stateName=stateName;
		this.stateCode=stateCode;
		this.population=population;
	}
	public String getStateName() {
		return stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public int getpopulation() {
		return population;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public void setpopulation(int population) {
		this.population=population;
	}
}
