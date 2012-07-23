package tests;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import jms.simple.queue.SimpleQueue;
import jms.simple.queue.SimpleQueueConnectionFactory;
import jms.simple.topic.SimpleTopic;
import jms.simple.topic.SimpleTopicConnectionFactory;
import junit.framework.Assert;

import org.junit.Test;

public class SimpleTester {

	@Test
	public void testSimpleQueue() throws JMSException {

		ConnectionFactory connectionFactory = new SimpleQueueConnectionFactory();
		Connection connection = connectionFactory.createConnection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		TextMessage textMessage = session.createTextMessage();
		textMessage.setText("TEXT MESSAGE");

		Destination destination = new SimpleQueue();

		MessageProducer producer = session.createProducer(destination);
		producer.send(textMessage);

		MessageConsumer consumer = session.createConsumer(destination);
		Message m = consumer.receive();

		if (m instanceof TextMessage) {
			String text = ((TextMessage) m).getText();
			Assert.assertEquals(text, "TEXT MESSAGE");
		} else {
			Assert.fail("Incorrect message type");
		}
	}

	@Test
	public void testTopic() throws JMSException {
		TopicConnectionFactory connectionFactory = new SimpleTopicConnectionFactory();

		TopicConnection connection = connectionFactory.createTopicConnection();

		TopicSession publisherSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		TopicSession subscriberSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = new SimpleTopic();

		TopicPublisher publisher = publisherSession.createPublisher(topic);
		TopicSubscriber subscriber1 = subscriberSession.createSubscriber(topic);
		TopicSubscriber subscriber2 = subscriberSession.createSubscriber(topic);

		TextMessage textMessage = publisherSession.createTextMessage();
		textMessage.setText("TEXT MESSAGE");

		publisher.publish(textMessage);

		Message m1 = subscriber1.receive();

		if (m1 instanceof TextMessage) {
			String text = ((TextMessage) m1).getText();
			Assert.assertEquals(text, "TEXT MESSAGE");
		} else {
			Assert.fail("Incorrect message type");
		}

		Message m2 = subscriber2.receive();

		if (m2 instanceof TextMessage) {
			String text = ((TextMessage) m2).getText();
			Assert.assertEquals(text, "TEXT MESSAGE");
		} else {
			Assert.fail("Incorrect message type");
		}
	}
}
