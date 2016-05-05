package com.test.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solab.iso8583.IsoMessage;
import com.test.reader.BinaryFileReader;
import com.test.reader.DefaultCSVReader;
import com.test.reader.TextFileReader;
import com.test.util.OutputPrinter;
import com.test.writer.BinaryFileWriter;

/**
 * Class <code>Main</code> reads the text and binary input files.
 * 
 * @author ArpitAggarwal
 *
 */
public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {

		LOGGER.info("Reading and Creating ISO Message from CSV File ********************************");
		String isoMessageString = DefaultCSVReader.createISOMessageFromCSV(
				"data.csv", "0x800");
		System.out.println(isoMessageString);
	}

	/**
	 * Method read iso message text file and prints it on console.
	 * 
	 * @throws Exception
	 */
	public static void readAndPrintTextFileWith0800() throws Exception {
		TextFileReader.read("config.xml", "write0800.txt");

	}

	/**
	 * Method read iso message text file and prints it on console.
	 * 
	 * @throws Exception
	 */
	public static void readAndPrintTextFile() throws Exception {
		TextFileReader.read("config.xml", "parse.txt");
	}

	/**
	 * Method writes iso message to binary file.
	 */
	public static void writeMessageToBinaryFile() {
		BinaryFileWriter.write(0x200, "iso.bin");

	}

	/**
	 * Method read iso message binary file and prints it on console.
	 * 
	 * @throws Exception
	 */
	public static void readAndPrintBinaryFile() throws Exception {
		IsoMessage message = BinaryFileReader.read("config.xml", "iso.bin",
				0x200);
		OutputPrinter.printMessageOnConsole(message);
	}

}