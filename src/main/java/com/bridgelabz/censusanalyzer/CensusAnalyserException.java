package com.bridgelabz.censusanalyzer;
public class CensusAnalyserException extends Exception {
	public enum ExceptionType {
		CENSUS_FILE_PROBLEM,WRONG_DELIMITER,HEADER_PROBLEM;
	}
	public ExceptionType type;
	public CensusAnalyserException(String message,ExceptionType type) {
		super(message);
		this.type=type;
	}
	public CensusAnalyserException(String message,ExceptionType type,Throwable cause) {
		super(message,cause);
		this.type=type;
	}
}
