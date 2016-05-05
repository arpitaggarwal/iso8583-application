package com.test.reader;

import java.io.FileInputStream;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;
import com.test.util.DefaultMessageFactory;

/**
 * Class <code>BinaryFileReader</code> is responsible for reading ISO Message
 * from a binary file format.
 * 
 * @author ArpitAggarwal
 *
 */
public class BinaryFileReader {

	/**
	 * Read ISO Message from a binary file.
	 * 
	 * @param configFile
	 *            ISO Message Configuration file.
	 * @param fileName
	 *            File to be read.
	 * @param isoHeader
	 *            ISO Message header
	 * @return {@link IsoMessage} ISO Message
	 * @throws Exception
	 */
	public static IsoMessage read(final String configFile,
			final String fileName, final int isoHeader) throws Exception {
		byte[] buf = new byte[2];
		try (FileInputStream fin = new FileInputStream(fileName)) {
			fin.read(buf);
			final int len = ((buf[0] & 0xff) << 4) | (buf[1] & 0xff);
			buf = new byte[len];
			fin.read(buf);
		}

		final MessageFactory messageFactory = DefaultMessageFactory
				.getMesssageFactory();

		// Read Binary File set to true.
		messageFactory.setUseBinaryMessages(true);

		final IsoMessage message = messageFactory.parseMessage(buf,
				messageFactory.getIsoHeader(isoHeader).length());
		return message;
	}

}
