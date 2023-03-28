package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
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
	 * @return list of symptoms
	 */

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/*
	 * @param symptoms list of symptoms to count
	 * 
	 * @return dictionary with symptoms as key and number of symptoms as value
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
	 * @param symptoms dictionary of symptoms to sort them in alphabetical order
	 * 
	 * @return sorted dictionary
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(symptoms);
		return sortMap;
	}

	/*
	 * @param symptoms write symptoms and number of symptoms in a file
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0; // counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			} else if (line.equals("rush")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}