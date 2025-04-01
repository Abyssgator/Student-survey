/* 
<!-- Team Members
 Name: Ashrith Bhooka Ravinandan
 Gno. G01455956

 Name:Rishith Reddy Pendli
 Gno. G01411978

 Name: Sathwik Reddy Bojja
 Gno. G01461462 
 
 This is CORS configuration file which allows local host to access backend
 -->
*/

package com.swesurvey.surveybackend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8081") // Add the origin of your Angular application
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
