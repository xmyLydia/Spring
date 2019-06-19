package com.spring.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() { 
		
		List<String> arr = new ArrayList<>();
		arr.add("first: blessed day");
		arr.add("second:blessed day");
		arr.add("third: blessed day");
		Random rand = new Random();
		int index = rand.nextInt(2);
		return arr.get(index);
	}

}
