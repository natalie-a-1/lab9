
public class Word {

	private String _word;
	private int _pos;
	
	public Word(String word, int pos) {
		if (word == null) {
			throw new NullPointerException();
		} else if (pos < 0) {
			throw new IllegalArgumentException();
		}
		_word = word;
		_pos = pos;
	}
	
	public int length() {
		return _word.split("").length;
		
	}
	
	public String toString() {
		return _word;
	}
	
	public Word toLowerCase() {
		return new Word(_word.toLowerCase(), _word.length());
	}
	
	public int position() {
		return _pos;
	}
	
	//Recieved help from Keon on UniqueChar method
	public int uniqueChars() {
		String temp = _word.toLowerCase();
		char tempo;
		String arr = "";
		for (int i = 0; i < temp.length(); i++) {
			tempo = temp.charAt(i);
			if (arr.indexOf(tempo) == -1) {
				arr = arr + Character.toString(tempo);
			}
			
		}
		return arr.length();
	}
	
	public int hashCode() {
		return _word.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Word temp = (Word) obj;
		if (_word.toLowerCase().equals(temp.toString().toLowerCase())) {
			return true;
		} else {
			return false;
		}
		
		}
}
