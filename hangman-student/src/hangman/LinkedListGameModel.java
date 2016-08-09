package hangman;

public class LinkedListGameModel implements GameModel {
	private String theWord;
	LLCharacterNode theString;
	LLCharacterNode word;
	LLCharacterNode wordsGuessed;
	private int numGuesses=0;
	private int state;
	public LinkedListGameModel(String guessWord){
		theWord=guessWord;
		for(int i=0;i<theWord.length();i++){
		LLCharacterNode	newNode=new LLCharacterNode(theWord.charAt(i));
			newNode.setLink(word);
			word=newNode;
		}
		state=STARTING_STATE;
		for(int j=0;j<theWord.length();j++){
			LLCharacterNode node=new LLCharacterNode('_');
			node.setLink(theString);
			theString=node;
		}
	}
	
	//LLCharacterNode word=new LLCharacterNode('c');
	
	@Override
	public boolean isPriorGuess(char guess) {
		LLCharacterNode node=wordsGuessed;
		while(node!=null){
			if(node.getInfo()==guess)
				return true;
			else node=node.getLink();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numberOfGuesses() {
	/*	LLCharacterNode node=wordsGuessed;
		while(node!=null){
			numGuesses++;
			node=node.getLink();
		}*/
		return numGuesses;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		if(!isPriorGuess(guess)){
			LLCharacterNode node=word;
			while(node!=null){
				if(node.getInfo()==guess)
					return true;
					else node=node.getLink();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove(char guess) {
		if(isPriorGuess(guess)){
			return false;
		}
		else if(!isCorrectGuess(guess)){
			state++;
			numGuesses++;
			LLCharacterNode	newNode=new LLCharacterNode(guess);
			newNode.setLink(wordsGuessed);
			wordsGuessed=newNode;
			return false;
		}
		else{
			numGuesses++;
			LLCharacterNode	newNode=new LLCharacterNode(guess);
			newNode.setLink(wordsGuessed);
			wordsGuessed=newNode;
			LLCharacterNode node=theString;
			LLCharacterNode node1=word;
			while(node!=null){
				if(guess==node1.getInfo())
					node.setInfo(guess);
			node=node.getLink();
			node1=node1.getLink();
			}
			return true;
			
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean inWinningState() {
		int count=0;
		LLCharacterNode currNode=wordsGuessed;
		while(currNode!=null){
			for(int i=0;i<theWord.length();i++)
			{
			if(theWord.charAt(i)==currNode.getInfo())
				count++;
			}
				currNode=currNode.getLink();
		}
		// TODO Auto-generated method stub
		return count==theWord.length();
	}

	@Override
	public boolean inLosingState() {
		// TODO Auto-generated method stub
		return state==10;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String previousGuessString() {
		String s="";
	   String s1="";
	   String s2="";
	  // String s3="";
	   String s4="";
	if(numGuesses==0){
			s="[]";
			return s;
		}
	else{
		LLCharacterNode currNode=wordsGuessed;
			while(currNode!=null){
				s1+=currNode.getInfo();
				currNode=currNode.getLink();
				//s+=currNode.getInfo()+", ";
		}
		//System.out.println(s.substring(0,s.length()-2));
		//s3=s1.substring(0,s1.length()-1);
		for(int h=s1.length()-1;h>=0;h--){
			s2+=s1.charAt(h)+", ";
		}
		s4=s2.substring(0,s2.length()-2);
		//System.out.println(""+s3+"");
			return "["+s4+"]";
	}
	}
		// TODO Auto-generated method stub

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return theWord;
	}

	@Override
	public String toString() {
	String s="";
	String s1="";
	LLCharacterNode node=theString;
	while(node!=null){
		s+=node.getInfo()+" ";
		node=node.getLink();
	}
	for(int h=s.length()-1;h>=0;h--){
		s1+=s.charAt(h);
	}
		return s1.substring(1,s1.length());
	}
	

}

