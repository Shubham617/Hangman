package hangman;

/**
 * The Array implementation of the GameModel interface.
 */
public class ArrayGameModel implements GameModel {
	/** The number of characters (lower/upper). */
	private static final int ALPHABET_COUNT = 26*2;
	
	/** hung state */
	private int		state;
	private String word;
	private char[] arrword;
	private char[] wordsguessed=new char[ALPHABET_COUNT];
	private int numGuesses= 0;
	/**
	 * Creates a new ArrayGameModel object.
	 * 
	 *  guessWord the word to guess
	 */
	public ArrayGameModel(String guessWord) {
		// TODO (1)
		word=guessWord;
		arrword=new char[word.length()];
		for(int i=0;i<word.length();i++)
		{
			arrword[i]=word.charAt(i);
		}
		
		state = STARTING_STATE;
		
	}
		
	public boolean isPriorGuess(char guess) {
		for(int i=0;i<wordsguessed.length;i++){
			if(wordsguessed[i]==guess){
				return true;
		
		}
		}
		
		
		return false;
	}
	
	public int numberOfGuesses() {
		// TODO (3)
		return numGuesses;
    }
	
	public boolean isCorrectGuess(char guess) {
		// TODO (4)
		if(!isPriorGuess(guess))
		{
			for(int i=0;i<arrword.length;i++){
				if(arrword[i]==guess)
					return true;
				
			}
		
		}	
		return false;
		}
	
	
	public boolean doMove(char guess) {
		if(isPriorGuess(guess)){
			return false;
		}
		
		else if(!isCorrectGuess(guess)){
			state++;
			numGuesses++; 
			wordsguessed[numGuesses-1] = guess; 
			return false; 
		}
		else {
			numGuesses++; 
			wordsguessed[numGuesses-1] = guess; 
			return true; 
			
	     

	 } 
	 }

	public boolean inWinningState() {
	int count = 0;
		for(int i = 0; i < wordsguessed.length; i++){
			for(int j = 0; j < word.length(); j++){
				if(word.charAt(j) == wordsguessed[i]){
					count++;
				}
			}
		}
		return count == word.length(); 
	}

	public boolean inLosingState() {
		return state == 10; 
	}
	
	public String toString() {
		String s="";
		String[] s2=new String[arrword.length];
		for(int h=0;h<s2.length;h++){
			s2[h]="_ ";
		}
		int i=0;
		while(i<=numGuesses)
		{
			for(int j=0;j<arrword.length;j++){
				if(wordsguessed[i]==arrword[j])
					s2[j]=arrword[j]+" ";
				}
			i++;
		}

		
		for(int k=0;k<s2.length;k++)
		{
			s+=s2[k];
		}
		return s.substring(0, s.length()-1);
	}

	public String previousGuessString() {
		String s = "[";
		//String s1="[";
		if(numGuesses==0)
		{
			s+="]";
			return s; 
		}
		for(int i=0;i<numGuesses;i++)
		{
			s +=wordsguessed[i]+", ";
	
			
		}

		return s.substring(0, s.length() -2) + "]";
		
	}
	
	public int getState() {
		return state;
	}

	public String getWord() {                
		return word;
	}
  
}
