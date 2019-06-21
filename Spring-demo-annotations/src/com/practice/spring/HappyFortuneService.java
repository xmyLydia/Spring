package com.practice.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{ 
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Happy";
	}
	
}
