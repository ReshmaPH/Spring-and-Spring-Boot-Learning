//Business Logic
package com.sample.spring.project.Learnspringframework.sample.enterprise.flow.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.spring.project.Learnspringframework.sample.enterprise.flow.data.DataService;



@Component
public class BusniessServive{
	@Autowired
	private DataService dataService;

	public long calculateSum() {
		List<Integer> data=dataService.retrieveData();
		return (data.stream().reduce(0,(x,y)->x+y));
		
	}
}