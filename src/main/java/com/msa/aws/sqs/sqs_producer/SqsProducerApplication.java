package com.msa.aws.sqs.sqs_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SqsProducerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SqsProducerApplication.class, args);
        for (int i = 0; i < 2; i++){
            MessageSender sender = context.getBean(MessageSender.class);
            sender.sendMessage();
        }
    }

}
