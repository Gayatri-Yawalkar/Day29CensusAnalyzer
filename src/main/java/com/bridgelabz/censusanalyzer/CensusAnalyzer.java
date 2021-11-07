package com.bridgelabz.censusanalyzer;
//Uc2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.bridgelabz.censusanalyzer.CensusAnalyserException.ExceptionType;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
public class CensusAnalyzer {
	public int readData(String csvFilePath) throws CensusAnalyserException {
		int numOfEntries=0;
		try(Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));) {
			BufferedReader reader2=Files.newBufferedReader(Paths.get(csvFilePath));
			String line=reader2.readLine();
			if(!line.contains(",")) {
				throw new CensusAnalyserException("Incorrect Delimiter",ExceptionType.WRONG_DELIMITER);
			}
			String[] header=line.split(",");
			if(!header[0].equalsIgnoreCase("stateName") || !header[1].equalsIgnoreCase("stateCode") || !header[2].equalsIgnoreCase("population")) {
				throw new CensusAnalyserException("Incorrect Header",ExceptionType.HEADER_PROBLEM);
			}
			CsvToBean<CsvStateCensus> csvToBean=new CsvToBeanBuilder<CsvStateCensus>(reader)
							  .withSeparator(',')
							  .withType(CsvStateCensus.class)
							  .withIgnoreLeadingWhiteSpace(true)
							  .build();
			Iterator<CsvStateCensus> i=csvToBean.iterator();
			while(i.hasNext()) {
				numOfEntries++;
				CsvStateCensus csvState=i.next();
				System.out.println(csvState);
			}
		}catch(IOException e) {
			throw new CensusAnalyserException(e.getMessage(),ExceptionType.CENSUS_FILE_PROBLEM);
		}
		return numOfEntries;
	} 
	public int readStateData(String csvFilePath) throws CensusAnalyserException {
		int numOfEntries=0;
		try(Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));) {
			BufferedReader reader2=Files.newBufferedReader(Paths.get(csvFilePath));
			String line=reader2.readLine();
			if(!line.contains(",")) {
				throw new CensusAnalyserException("Incorrect Delimiter",ExceptionType.WRONG_DELIMITER);
			}
			String[] header=line.split(",");
			if(!header[0].equalsIgnoreCase("stateName") || !header[1].equalsIgnoreCase("stateCode")) {
				throw new CensusAnalyserException("Incorrect Header",ExceptionType.HEADER_PROBLEM);
			}
			CsvToBean<StateCsv> csvToBean=new CsvToBeanBuilder<StateCsv>(reader)
						       .withSeparator(',')
						       .withType(StateCsv.class)
						       .withIgnoreLeadingWhiteSpace(true)
						       .build();
			Iterator<StateCsv> i=csvToBean.iterator();
			while(i.hasNext()) {
				numOfEntries++;
				StateCsv csvState=i.next();
				System.out.println(csvState);
			}
		}catch(IOException e) {
			throw new CensusAnalyserException(e.getMessage(),ExceptionType.CENSUS_FILE_PROBLEM);
		}
		return numOfEntries;
	} 
}