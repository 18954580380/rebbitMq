package producerDemo.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "testQueue")
public class receiveMsg {
	    @RabbitHandler
	    public void process(String hello) {
	        System.out.println("Receiver  : " + hello);
	    }
}
