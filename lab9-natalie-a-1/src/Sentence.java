import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sentence {

	private List<Word> _sentence = new ArrayList<Word>();
	private int _pos;
	private String _sentenceStr;
	private Map<Word, Integer> _wordFreq = new HashMap<Word, Integer>();
	
	public Sentence(String sentence, int pos) {
		if(sentence == null) {
			throw new NullPointerException();
		}
		if (pos < 0) {
			throw new IllegalArgumentException();
		}
		this._sentenceStr = sentence;
		this._pos = pos;
		String[] temp = _sentenceStr.split(" ");
		for (int i = 0; i < temp.length; i++) {
			_sentence.add(new Word(temp[i], i));
		}
	}
	
	public int length() {
		return _sentenceStr.split(" ").length;
	}
	
	public String toString() {
		return _sentenceStr;
	}
	
	public int position() {
		return _pos;
	}
	
	public Word get(int idx) {
		for(String word: _sentenceStr.split("\\.")) {
			_sentence.add(new Word(word.toLowerCase(), word.length()));
		}
		return _sentence.get(idx);
	}
	
	public List<Integer> getWordIndices(Word w) {
		if (w == null) {
			throw new NullPointerException();
		}
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < _sentence.size(); i++) {
			if (_sentence.get(i).equals(w)) {
				temp.add(i);
			}
		}
		return temp;
	}
	
	public Map<Word, Integer> wordFrequency() {
		for (Word w: _sentence) {
			if (_wordFreq.containsKey(w)) {
				_wordFreq.put(w, _wordFreq.get(w) +1);
			} else {
				_wordFreq.put(w, 1);
			}
		}
		return _wordFreq;
	}
	
	public Word mostFrequent() {
		
		Word[] temp = new Word[_sentence.size()];
		for (int i = 0; i < _sentence.size(); i++) {
			temp[i] = _sentence.get(i);
		}
		int largest = wordFrequency().get(_sentence.get(0));
		int place = 0;
		for (int i = 0; i < temp.length; i++) {
			if (wordFrequency().get(temp[i]) > largest) {
				largest = wordFrequency().get(temp[i]);
				place = i;
			}
		}
		return temp[place];

	}
	
}
