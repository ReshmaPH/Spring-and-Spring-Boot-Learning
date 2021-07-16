package com.sample.spring.project.Learnspringframework.sample.enterprise.flow.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.project.Learnspringframework.sample.enterprise.flow.business.BusniessServive;


@RestController
public class Controller {
	@Autowired
	private BusniessServive businessService;
	@GetMapping("/sum")
	public long displaySum() {
	return businessService.calculateSum();
}
}

