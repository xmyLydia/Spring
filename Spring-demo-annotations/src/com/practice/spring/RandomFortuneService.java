package com.practice.spring;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data = {"str1","str2","str3"};
	private Random random = new Random();
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index];
	}
	@PostConstruct
	public void readFile() {
		String fileName = "src/applicationContext.xml";
		 try {
	            Stream<String> lines = Files.lines(Paths.get(fileName));
	            System.out.println("<!-----Read all lines as a Stream-----!>");
	            lines.forEach(System.out :: println);
	            lines.close();
	        } catch(IOException io) {
	            io.printStackTrace();
	        }
	} 
}
