package producerDemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
	//声明队列  不涉及到交换机，采用默认
	@Bean
    public Queue queueMessages() {
        return new Queue("testQueue");
    }
	//声明队列 测试订阅模式
	@Bean
	public Queue queueMessagesExchange() {
		return new Queue("testQueueExchange");
	}
	//声明队列  topicExchang交换机测试使用
	@Bean
	public Queue queueMessagesExchangeByKey() {
		return new Queue("testQueueExchangeByKey");
	}
	//声明交换机  广播模式，只要绑定到此交换机上的队列都能收到消息
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("testExchange");
	}
	//声明交换机 可以根据routing_key自由的绑定不同的队列
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("testTopicExchange");
	}
	//将队列绑定交换机上
	@Bean
	public Binding binddingTestExchange() {
		 return BindingBuilder.bind(queueMessagesExchange()).to(fanoutExchange());
	}
	//将队列绑定交换机上,使用路由key
	@Bean
	public Binding binddingTestExchangeOrderKey() {
		return  BindingBuilder.bind(queueMessagesExchangeByKey()).to(topicExchange()).with("test_key");
	}
}
