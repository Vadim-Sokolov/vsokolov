package ru.job4j.condition;

/**
 *@author vsokolov
 *@version $Id$
 *@since 0.1
 */
public class DummyBot {
	/**
	 * Answers questions.
	 * @param question User question.
	 * @return Answer.
	 */
	public String answer(String question) {
		String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
		if ("Привет, Бот.".equals(question)) {
			rsl = "Привет, умник.";
		} else if ("Пока.".equals(question)) {
			rsl = "До скорой встречи.";
		}
		return rsl;
	}
}