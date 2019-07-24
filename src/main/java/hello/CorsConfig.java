package hello;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/agent/**")
                .allowedOrigins("http:localhost:4000")
                .allowedMethods("*")
                .allowCredentials(true);

    }
}
