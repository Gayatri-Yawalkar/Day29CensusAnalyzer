package com.bridgelabz.junit;
//Uc2
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bridgelabz.censusanalyzer.CensusAnalyserException;
import com.bridgelabz.censusanalyzer.CensusAnalyzer;
public class CensusAnalyzerTest {
	public static final String CSV_FILE_NAME="abc.csv";
	public static final String WRONG_CSV_FILE_NAME="abcd.csv";
	public static final String WRONG_HEADER_CSV_FILE_NAME="IndiaCensus.csv";
	public static final String WRONG_DILIMITER_CSV_FILE_NAME="wrongHeader.csv";
	@Test
	public void givenStateCensusFile_checkEntries_shouldReturnNumOfEntries() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readData(CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateCensusFile_ifIncorrectCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readData(WRONG_CSV_FILE_NAME);
			assertEquals(1,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateCensusFile_ifWrongHeaderCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readData(WRONG_HEADER_CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.HEADER_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateCensusFile_ifWrongDilimitorCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readData(WRONG_DILIMITER_CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
		}
	}
	@Test
	public void givenCensusFile_checkEntries_shouldReturnNumOfEntries() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readStateData(CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateFile_ifIncorrectCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readStateData(WRONG_CSV_FILE_NAME);
			assertEquals(1,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateFile_ifWrongHeaderCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readStateData(WRONG_HEADER_CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.HEADER_PROBLEM,e.type);
		}
	}
	@Test
	public void givenStateFile_ifWrongDilimitorCsvFile_shouldThrowException() {
		CensusAnalyzer census=new CensusAnalyzer();
		int actualResult=0;
		try {
			actualResult=census.readStateData(WRONG_DILIMITER_CSV_FILE_NAME);
			assertEquals(2,actualResult);
		} catch(CensusAnalyserException e) {
			System.out.println(e.type);
			assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
		}
	}
}
