package jms.simple.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.jms.JMSException;
import javax.jms.Message;

public class SimpleQueue implements javax.jms.Queue {

	private Queue<Message> queue;

	public SimpleQueue() {
		queue = new ArrayBlockingQueue<Message>(100);
	}

	public void write(Message m) {
		queue.add(m);
	}

	public Message read() {
		return queue.remove();
	}

	@Override
	public String getQueueName() throws JMSException {
		return "Simple Queue";
	}

}
