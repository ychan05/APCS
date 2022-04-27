// Yatlongstan :: Yat Long, Gabriel, Weichen 

import java.util.ArrayList;

public class SportsCelebrity extends Celebrity {
    private ArrayList<String> clueList;

    public SportsCelebrity(String answer, String clues)
	{
		super(answer, clues);
		splitClues();
	}
	
    private void splitClues()
	{
		String [] clues = super.getClue().split(",");
		clueList = new ArrayList<String>();
		for (String currentClue : clues)
		{
			clueList.add(currentClue);
		}
	}

    public String getClue()
	{
		if (clueList.size() == 0)
		{
			splitClues();
		}
		
		return clueList.remove(0);
	}
	
    public String toString() {
        return "This is the Sports Celebrity: " + super._answer;
    }
}