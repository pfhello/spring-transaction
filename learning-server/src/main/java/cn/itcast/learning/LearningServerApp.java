package cn.itcast.learning;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableRabbit
public class LearningServerApp {
    public static void main(String[] args) {
        SpringApplication.run(LearningServerApp.class);
    }
}
