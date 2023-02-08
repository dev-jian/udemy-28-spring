package me.devjian.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationDataService {
	
	private DataService dataService;

	public BusinessCalculationDataService(@Qualifier("mysqlDBDataService") DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
