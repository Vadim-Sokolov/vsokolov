package ru.job4j.professions;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
	
	/**
	* Method treats a patient.
	* @param patient
	*/
	public void treat(Patient patient) {
		System.out.println("Doctor " + this.name + " is treating patient" + patient.getName() + ".");
	}
	
	/**
	* Method returns a diagnosis for a patient
	* @param patient
	*/
	public Diagnosis diagnose(Patient patient) {
		return new Diagnosis("Too late...");
	}
}