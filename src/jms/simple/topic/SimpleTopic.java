package jms.simple.topic;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class SimpleTopic implements Topic {

	Map<TopicSubscriber, Queue<Message>> postOffice;

	public SimpleTopic() {
		postOffice = new HashMap<TopicSubscriber, Queue<Message>>();
	}

	@Override
	public String getTopicName() throws JMSException {
		return "Simple Topic";
	}

	public void subscribe(TopicSubscriber subscriber) {
		if (!postOffice.containsKey(subscriber)) {
			postOffice.put(subscriber, new ArrayBlockingQueue<Message>(100));
		}
	}

	public void publish(Message m) {
		for (TopicSubscriber subscriber : postOffice.keySet()) {
			postOffice.get(subscriber).add(m);
		}
	}

	public Message receive(TopicSubscriber subscriber) {
		return postOffice.get(subscriber).remove();
	}
}
