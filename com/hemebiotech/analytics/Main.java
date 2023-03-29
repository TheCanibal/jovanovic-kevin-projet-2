package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	/**
	 * main method that read a file of symptoms, count them, sort them and write
	 * them in a new file
	 *
	 * @param args The command line arguments.
	 */

	public static void main(String[] args) {
		String filepath = "symptoms.txt";
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

		List<String> listSymptoms = analytics.getSymptoms();
		Map<String, Integer> mapSymptoms = analytics.countSymptoms(listSymptoms);
		Map<String, Integer> mapSymptomsSorted = analytics.sortSymptoms(mapSymptoms);
		analytics.writeSymptoms(mapSymptomsSorted);
	}
}