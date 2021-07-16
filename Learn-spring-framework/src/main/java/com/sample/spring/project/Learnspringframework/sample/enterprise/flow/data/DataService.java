
//Data
package com.sample.spring.project.Learnspringframework.sample.enterprise.flow.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataService {
	public List<Integer> retrieveData (){
		int [] list= {12,34,56,67,89,90};
		List<Integer> numbers=new ArrayList<>();
		for(int num:list) {
			numbers.add(num);
		}
		return numbers;
		
	}
}