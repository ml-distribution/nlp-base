package zx.soft.nlp.base.standardization;


public class Element {

	public char name;
	public int len = 1;

	public Element(char name) {
		this.name = name;
	}


	public void len() {
		len++;
	}

	@Override
	public String toString() {
		return String.valueOf(name) ;
	}


}
