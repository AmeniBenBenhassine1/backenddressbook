package projet.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
public class Projet1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
		
	}

    @Bean
    CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        
	       
	        config.addAllowedOrigin("http://localhost:4200");
	        
	      
	        config.addAllowedMethod("*");
	        
	    
	        config.addAllowedHeader("*");
	        
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
  

}
