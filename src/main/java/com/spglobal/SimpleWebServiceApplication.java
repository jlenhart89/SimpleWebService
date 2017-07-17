package com.spglobal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spglobal.entity.Message;

@RestController
@SpringBootApplication
public class SimpleWebServiceApplication {

	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleWebServiceApplication.class, args);
	}
	
    @RequestMapping(method=RequestMethod.GET, value="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public Message home() {
        return new Message(String.format("%s: %s", LocalDateTime.now().format(df), "Hello World Docker!"));
    }
}
