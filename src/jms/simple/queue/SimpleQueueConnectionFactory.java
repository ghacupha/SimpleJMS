package jms.simple.queue;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

import jms.simple.SimpleConnectionFactory;

public class SimpleQueueConnectionFactory extends SimpleConnectionFactory implements QueueConnectionFactory {

	@Override
	public QueueConnection createQueueConnection() throws JMSException {
		return new SimpleQueueConnection();
	}

	@Override
	public QueueConnection createQueueConnection(String arg0, String arg1) throws JMSException {
		return new SimpleQueueConnection();
	}

	@Override
	public Connection createConnection() throws JMSException {
		return new SimpleQueueConnection();
	}

	@Override
	public Connection createConnection(String arg0, String arg1) throws JMSException {
		return new SimpleQueueConnection();
	}

}
