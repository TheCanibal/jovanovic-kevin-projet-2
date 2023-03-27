package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything the will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {

	/**
	 * 
	 * @param symptoms is a list of symptoms to write and put in alphabetical order
	 */

	void writeSymptoms(Map<String, Integer> symptoms);
}
