package producerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import producerDemo.Start;
@ServletComponentScan
@SpringBootApplication
public class Start {
	 public static void main( String[] args )
	    {
	        SpringApplication.run(Start.class, args);
	    }
}
