package customerDemo.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queues="testQueueExchange")
public class receiveMsgByExchange {
	@RabbitHandler
    public void process(String hello) {
       System.out.println("使用fanoutExchange:"+hello);
    }
}
