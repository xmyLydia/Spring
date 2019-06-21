package com.practice.spring;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	List<String> list = new ArrayList<>();
	@Override
	public String getFortune() {
      try {
		Files.lines(Paths.get("test.txt"), StandardCharsets.UTF_8).forEach(line->list.add(line));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        Random random = new Random();
        int inx = random.nextInt(list.size());
        return list.get(inx);
    
	}

}
