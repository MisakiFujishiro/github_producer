package com.msa.aws.sqs.sqs_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SqsProducerApplication {

    public static void main(String[] args) {
        int executionCount = 10;

        if (args.length>0){
            executionCount = Integer.parseInt(args[0]);
        }

        ApplicationContext context = SpringApplication.run(SqsProducerApplication.class, args);
        for (int i = 0; i < executionCount; i++){
            MessageSender sender = context.getBean(MessageSender.class);
            sender.sendMessage();
        }
    }

}
