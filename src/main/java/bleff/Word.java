package bleff;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
	@Id
    private String word;
	private String meaning;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
