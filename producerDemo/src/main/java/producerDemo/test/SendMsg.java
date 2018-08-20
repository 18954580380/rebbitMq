package producerDemo.test;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SendMsg {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private FanoutExchange fanoutExchange;
    @Autowired
    private TopicExchange topicExchange;
    @RequestMapping("/sendMsg")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("testQueue", context);
    }
    @RequestMapping("/sendMsgByExchange")
    public void sendMsg() {
    	String context = "使用fanoutExchange发送信息";
    	this.rabbitTemplate.convertAndSend(fanoutExchange.getName(),"",context);
    }
    @RequestMapping("/sendMsgByTopicExchange")
    public void sendMsgByTopic() {
    	String context = "使用TopicExchange发送信息";
    	this.rabbitTemplate.convertAndSend(topicExchange.getName(),"test_key",context);
    }
}
