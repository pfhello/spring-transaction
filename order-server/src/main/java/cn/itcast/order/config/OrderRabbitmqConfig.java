package cn.itcast.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRabbitmqConfig {

    //添加选课的交换机
    public static final String EX_LEARNING_ADDCHOOSECOURSE = "ex_learning_addchoosecourse";

    //添加选课消息队列
    public static final String XC_LEARNING_ADDCHOOSECOURSE = "xc_learning_addchoosecourse";


    //完成添加选课消息队列
    public static final String XC_LEARNING_FINISHADDCHOOSECOURSE = "xc_learning_finishaddchoosecourse";

    //添加选课路由key
    public static final String XC_LEARNING_ADDCHOOSECOURSE_KEY = "addchoosecourse";

    //完成添加选课路由key
    public static final String XC_LEARNING_FINISHADDCHOOSECOURSE_KEY = "finishaddchoosecourse";


    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    //添加交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EX_LEARNING_ADDCHOOSECOURSE);
    }

    //定义选课队列
    @Bean
    public Queue finishedAddQueue(){
        return new Queue(XC_LEARNING_FINISHADDCHOOSECOURSE);
    }

    //定义完成选课的队列
    @Bean
    public Queue addCourseQueue(){
        return new Queue(XC_LEARNING_ADDCHOOSECOURSE);
    }

    //绑定队列到交换机
    @Bean
    public Binding addCourseBinding(){
        return BindingBuilder.bind(addCourseQueue()).to(topicExchange()).with(XC_LEARNING_ADDCHOOSECOURSE_KEY);
    }

    @Bean
    public Binding finishedCourseBinding(){
       return BindingBuilder.bind(finishedAddQueue()).to(topicExchange()).with(XC_LEARNING_FINISHADDCHOOSECOURSE_KEY);
    }






}
