package me.devjian.learnspringframework.examples.d1;

import org.springframework.stereotype.Component;

@Component(value = "mysqlDBDataService")
public class MysqlDBDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3,4,5};
	}
}
