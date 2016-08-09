package hangman;

public class LLCharacterNode {
private char info;
private LLCharacterNode link;

public LLCharacterNode(char info){
	this.info=info;
	link=null;
}
public char getInfo(){
	return info;
}
public void setLink(LLCharacterNode lk){
	link=lk;
}
public LLCharacterNode getLink(){
	return link;
}
public void setInfo(char info){
	this.info=info;
}
}
