package jms.simple.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class SimpleTopicSubscriber implements TopicSubscriber {

	private SimpleTopic topic;

	public SimpleTopicSubscriber(Topic topic) {
		if (topic instanceof SimpleTopic) {
			this.topic = (SimpleTopic) topic;
		}
	}

	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub

	}

	@Override
	public MessageListener getMessageListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageSelector() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receive() throws JMSException {
		return topic.receive(this);
	}

	@Override
	public Message receive(long arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receiveNoWait() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageListener(MessageListener arg0) throws JMSException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getNoLocal() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Topic getTopic() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
