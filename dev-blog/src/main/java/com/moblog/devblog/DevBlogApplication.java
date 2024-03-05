package com.moblog.devblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.moblog.devblog.service.BlogServiceTemplateImpl;

@SpringBootApplication
public class DevBlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DevBlogApplication.class, args);
        var bs = run.getBean(BlogServiceTemplateImpl.class);//GraalVm
    }
}// mvnw.clean
//mvnw.compile
//mvnw.cmd spring-boot:run
//to run jar file java-jar <jar-file name>
// if i want to change the jar profile the command is
//{java -jar -Dspring.profiles.active=dev dev-blog.jar}
//spring profile= provide a way to segregate parts of your application configuration and
// make it only available in certain environments.