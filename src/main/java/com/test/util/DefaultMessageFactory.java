package com.test.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.solab.iso8583.MessageFactory;

/**
 * Class <code> DefaultMessageFactory </code> creates a message factory out of a
 * XML config.
 * 
 * @author ArpitAggarwal
 */

public class DefaultMessageFactory {

	private static MessageFactory messageFactory;

	/**
	 * Private Constructor to avoid making instance of
	 * <code>DefaultMessageFactory</code> explicitly.
	 */
	private DefaultMessageFactory() {

	}

	/**
	 * Creates a message factory out of a XML config file.
	 * 
	 * @param configFile
	 *            ISO Message Configuration file.
	 * @return {@link MessageFactory}
	 */
	public static synchronized MessageFactory getMesssageFactory() {
		if (messageFactory == null) {
			try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml")) {
				messageFactory = (MessageFactory) context
						.getBean("isoMessageFactory");
			}
		}
		return messageFactory;
	}
}
