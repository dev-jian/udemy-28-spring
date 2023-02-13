package me.devjian.learnspringframework.examples.c1;

import org.springframework.stereotype.Repository;

@Repository(value = "mysqlDBDataService")
public class MysqlDBDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3,4,5};
	}
}
