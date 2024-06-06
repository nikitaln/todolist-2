package main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  Класс для отображения статических ресурсов-контента НЕ из приложения
 */


@Configuration
public class MvcConfig implements WebMvcConfigurer {

//    @Value("${upload.path}")
//    private String uploadPath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("hello from MVC");
        registry.addResourceHandler("/todo-images/**").addResourceLocations("file:///C:/Users/admin/Desktop/todo-images/");
        //registry.addResourceHandler("/todolist-img/**").addResourceLocations("file:///C:/Users/lukanin_ns/Desktop/todolist-img/");
    }
}
