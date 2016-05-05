package com.test.reader;

import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.test.util.DefaultMessageFactory;

public class DefaultCSVReader {

	private static IsoMessage isoMessage;

	public static String createISOMessageFromCSV(final String inputFile,
			final String messageType) throws IOException {

		try (CSVReader reader = new CSVReader(new InputStreamReader(
				DefaultCSVReader.class.getClassLoader().getResourceAsStream(
						inputFile)))) {
			String[] row = null;
			while ((row = reader.readNext()) != null) {
				if (row[0].equals(messageType)) {
					isoMessage = DefaultMessageFactory.getMesssageFactory()
							.newMessage(Integer.decode(messageType));
					reader.readNext();
					while ((row = reader.readNext()) != null) {
						if (row.length < 4) {
							break;
						} else {
							isoMessage.setValue(Integer.valueOf(row[0]),
									row[1], IsoType.valueOf(row[2]),
									Integer.valueOf(row[3]));
						}
					}
				}
			}
		}
		if (isoMessage != null) {
			return isoMessage.debugString();
		}
		return "";
	}
}