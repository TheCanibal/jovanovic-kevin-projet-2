package com.hemebiotech.analytics;

//import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath = "result.out";

	public void writeSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> treeMap = new TreeMap<String, Integer>(symptoms);
		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false));
				for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
					writer.write(entry.getKey() + " : " + entry.getValue());
					writer.newLine();
				}
				writer.close();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}