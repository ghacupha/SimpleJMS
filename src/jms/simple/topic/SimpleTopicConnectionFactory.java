package jms.simple.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

import jms.simple.SimpleConnectionFactory;

public class SimpleTopicConnectionFactory extends SimpleConnectionFactory implements TopicConnectionFactory {

	@Override
	public Connection createConnection() throws JMSException {
		return new SimpleTopicConnection();
	}

	@Override
	public Connection createConnection(String arg0, String arg1) throws JMSException {
		return new SimpleTopicConnection();
	}

	@Override
	public TopicConnection createTopicConnection() throws JMSException {
		return new SimpleTopicConnection();
	}

	@Override
	public TopicConnection createTopicConnection(String arg0, String arg1) throws JMSException {
		return new SimpleTopicConnection();
	}

}
