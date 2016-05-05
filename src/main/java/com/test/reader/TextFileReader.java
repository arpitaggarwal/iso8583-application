package com.test.reader;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import com.solab.iso8583.IsoMessage;
import com.test.util.DefaultMessageFactory;
import com.test.util.OutputPrinter;

/**
 * Class <code>TextFileReader</code> is responsible for reading ISO Message from
 * a text file format.
 * 
 * @author ArpitAggarwal
 *
 */
public class TextFileReader {

	/**
	 * Read ISO Message from a text file.
	 * 
	 * @param configFile
	 *            ISO Message Configuration file.
	 * @param fileName
	 *            File to be read.
	 * @throws Exception
	 */
	public static void read(final String configFile, final String fileName)
			throws Exception {
		final LineNumberReader reader = new LineNumberReader(
				new InputStreamReader(TextFileReader.class.getClassLoader()
						.getResourceAsStream(fileName)));
		String line = reader.readLine();
		while (line != null && line.length() > 0) {
			final IsoMessage isoMessage = DefaultMessageFactory
					.getMesssageFactory().parseMessage(line.getBytes(), 12);
			OutputPrinter.printMessageOnConsole(isoMessage);
			line = reader.readLine();
		}
		reader.close();
	}
}
