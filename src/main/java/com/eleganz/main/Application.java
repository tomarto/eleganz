package com.eleganz.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Application class. Startup of the application.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@SpringBootApplication
/**	For war deployment, uncomment the following:*/
//public class Application extends SpringBootServletInitializer {
public class Application {

	/**
	 * <p>
	 * Starts the application.
	 * </p>
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

/**	For war deployment, uncomment the following:*/
//	/** {@inheritDoc} */
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
}
