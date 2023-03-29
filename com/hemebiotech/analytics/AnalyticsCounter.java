package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/*
	 * Constructor of AnalyticsCounter
	 * 
	 * @param reader file reader
	 * 
	 * @param writer file writer
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/*
	 * Read a file and return a list of String
	 *
	 * @return list of symptoms
	 */

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/*
	 * Count how many times a symptoms from the list appear and put it in a
	 * dictionnary with the quantity of it
	 *
	 * @param symptoms list of symptoms to count
	 * 
	 * @return dictionary with symptoms as key and quantity of symptoms as value
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
		if (symptoms != null) {
			for (String s : symptoms) {
				mapSymptoms.merge(s, 1, Integer::sum);
			}
		} else {
			System.out.println("La liste est vide !!");
		}
		return mapSymptoms;
	}

	/*
	 * Sort symptoms in alphabetical order
	 *
	 * @param symptoms dictionary of symptoms to sort them in alphabetical order
	 * 
	 * @return sorted dictionary
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(symptoms);
		return sortMap;
	}

	/*
	 * 
	 * Write in a file the symptoms with their quantity
	 *
	 * @param symptoms write symptoms and number of symptoms in a file
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}