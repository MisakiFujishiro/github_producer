package com.msa.aws.sqs.sqs_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//実行時に各種のアノテーションを読み込んで、DIする
@SpringBootApplication
public class SqsProducerApplication {
    //java実行時に最初に呼び出される
    public static void main(String[] args) {
        int executionCount = 10;

        if (args.length>0){
            executionCount = Integer.parseInt(args[0]);
        }
        // SQSProducerApplicationの呼び出されることで@SpringBootApplicationにより作成されたBeanなどがcontextに格納される
        ApplicationContext context = SpringApplication.run(SqsProducerApplication.class, args);
        for (int i = 0; i < executionCount; i++){
            //context内部に管理されているBeanをよびだしている
            MessageSender sender = context.getBean(MessageSender.class);
            sender.sendMessage();
        }
    }

}

