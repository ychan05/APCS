// Yatlongstan :: Yat Long, Gabriel, Weichen 

/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	/**
	 * The clue to determine the celebrity
	 */
	protected String _clue;

	/**
	 * The answer or name of the celebrity.
	 */
	protected String _answer;

	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
            _answer = answer;
            _clue   = clue;
	}

	public Celebrity(String answer)
	{
	    _answer = answer;
            _clue   = "N/A good luck lol";
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _answer;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_answer = answer;
	}
	
	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return _answer;
	}
	
	public static void main(String[] args) {
		Celebrity harrisonFord = new Celebrity("Harrison Ford", "Played Indiana Jones and Han Solo");
		System.out.println("Name: " + harrisonFord);
		System.out.println("Answer: " + harrisonFord.getAnswer() + "\nClue: " + harrisonFord.getClue());
		harrisonFord.setAnswer("Will Smith");
		harrisonFord.setClue("Played the Fresh Prince of Bel Air, and punched Chris Rock on stage");
                System.out.println("Name: " + harrisonFord);
                System.out.println("Answer: " + harrisonFord.getAnswer() + "\nClue: " + harrisonFord.getClue());
	}

}
