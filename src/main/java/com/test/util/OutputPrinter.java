package com.test.util;

import com.solab.iso8583.IsoMessage;

/**
 * Class <code>OutputPrinter</code> is responsible for printing ISO Message.
 * 
 * @author ArpitAggarwal
 *
 */
public class OutputPrinter {
	/**
	 * Private Constructor to avoid making instance of
	 * <code>OutputPrinter</code> explicitly.
	 */
	private OutputPrinter() {

	}

	/**
	 * Prints ISO MEssage on console.
	 * 
	 * @param isoMessage
	 *            IsoMessage to be printed.
	 */
	public static void printMessageOnConsole(final IsoMessage isoMessage) {
		System.out.printf("Message Type: %04x\n", isoMessage.getType());
		for (int i = 2; i < 128; i++) {
			if (isoMessage.hasField(i)) {
				System.out.printf("Data Field %3d(%s): %s -> '%s'\n", i,
						isoMessage.getField(i).getType(), isoMessage
								.getObjectValue(i), isoMessage.getField(i)
								.toString());
			}
		}
	}
}
