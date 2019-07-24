package hfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//autoconfig aus(dafuer muss aber wirklich vieles selbst konfiguriert werden): @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class App {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(App.class, args);
    }
}