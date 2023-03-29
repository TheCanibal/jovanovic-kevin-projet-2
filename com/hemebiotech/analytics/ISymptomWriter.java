package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {

	/**
	 * 
	 * @param symptoms is a dictionary of symptoms and their quantity to write and
	 *                 put in alphabetical order
	 */

	void writeSymptoms(Map<String, Integer> symptoms);
}