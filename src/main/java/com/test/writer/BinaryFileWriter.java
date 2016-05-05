package com.test.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.test.util.DefaultMessageFactory;

/**
 * Class <code>BinaryFileWriter</code> is responsible for writing ISO Message to
 * a binary file.
 * 
 * @author ArpitAggarwal
 *
 */
public class BinaryFileWriter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BinaryFileWriter.class);

	/**
	 * Write ISO Message to a file.
	 * 
	 * @param configFile
	 *            ISO Message Configuration file.
	 * @param messageType
	 *            Message Type.
	 * @param fileName
	 *            Name to a file where ISO Message to be written.
	 */
	public static void write(final int messageType, final String fileName) {
		final IsoMessage isoMessage = createISOMessage(messageType);
		try (FileOutputStream fout = new FileOutputStream(fileName)) {
			isoMessage.write(fout, 2);
		} catch (IOException e) {
			LOGGER.error("Error in writing message to file {}", e);
		}
	}

	/**
	 * Create ISO Message.
	 * 
	 * @param configFile
	 *            ISO Message Configuration file.
	 * @param messageType
	 *            Message Type.
	 * @return {@link IsoMessage} IsoMessage
	 */
	private static IsoMessage createISOMessage(final int messageType) {
		final IsoMessage isoMessage = DefaultMessageFactory
				.getMesssageFactory().newMessage(messageType);
		isoMessage.setBinary(true);
		isoMessage.setValue(4, new BigDecimal("501.25"), IsoType.AMOUNT, 0);
		isoMessage.setValue(12, new Date(), IsoType.TIME, 0);
		isoMessage.setValue(15, new Date(), IsoType.DATE4, 0);
		isoMessage.setValue(17, new Date(), IsoType.DATE_EXP, 0);
		isoMessage.setValue(37, 12345678, IsoType.NUMERIC, 12);
		isoMessage.setValue(41, "TEST-TERMINAL", IsoType.ALPHA, 16);
		return isoMessage;
	}
}
