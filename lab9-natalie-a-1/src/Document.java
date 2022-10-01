<S>import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Document {

	private List<Sentence> _document = new ArrayList<Sentence>();
	private String _documentStr;
	private Map<Word, Integer> wordFreq = new HashMap<Word, Integer>();

	public Document(String document) {
		if (document == null) {
			throw new NullPointerException();
		}
		this._documentStr = document;
		String[] temp = _documentStr.split("\\.");
		for (int i = 0; i < temp.length; i++) {
			_document.add(new Sentence(temp[i], i));
		}
	}

	public int length() {
		return _document.size();
	}

	public String toString() {
		return _documentStr;
	}

	public int getNumWords() {
		int sum = 0;
		int i;
		for (i = 0; i < this._document.size(); i++) {
			sum = sum + this._document.get(i).length();
		}

		return sum;
	}

	public Sentence get(int idx) {
		String[] temp = _documentStr.split("\\.");
		if (idx > temp.length || idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		return new Sentence(temp[idx], idx);
	}

	public Map<Word, Integer> wordFrequency() {
		Map<Word, Integer> holder = new HashMap<Word, Integer>();
		for (Sentence s : _document) {
			var temp = s.wordFrequency();
			for (Entry<Word, Integer> e : temp.entrySet()) {
				
				if (holder.containsKey(e.getKey())) {
					holder.put(e.getKey(), holder.get(e.getKey()) + e.getValue());
				} else {
					holder.put(e.getKey(), e.getValue());
				}
			}
		}
		return holder;
	}

}
