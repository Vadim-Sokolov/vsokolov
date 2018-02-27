package ru.job4j.tracker;

import java.util.*;
import java.lang.System;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput {
	
	Scanner scanner = new Scanner(System.in);
	
	public String ask(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
}