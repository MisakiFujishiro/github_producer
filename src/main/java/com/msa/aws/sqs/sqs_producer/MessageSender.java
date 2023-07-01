package com.msa.aws.sqs.sqs_producer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageSender {
    @Autowired
    private AmazonSQS amazonSQSClient;

    @Value("${aws.sqs.url}")
    private String url;

    public void sendMessage(){

        // 送信するデータの作成
        Random rand = new Random();
        int num = rand.nextInt(9) ;
        num = num+1;
        String message = String.valueOf(num);

        // メッセージ送信
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message)
                .withDelaySeconds(5);
        amazonSQSClient.sendMessage(request);
    }
}
