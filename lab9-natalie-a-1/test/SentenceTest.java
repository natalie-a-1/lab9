import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class SentenceTest {

	@Test
	void testConstructor() {
		try {
			Sentence s1 = new Sentence(null, 0);
			fail();
		}catch(NullPointerException e) {
			
		}
		
		try {
			Sentence s1 = new Sentence("This should fail", -2);
			fail();
		}catch(IllegalArgumentException e) {
			
		}
		
		Sentence s2 = new Sentence("Java Collections provides implementations of different data structures and algorithms", 0);
	}
	
	@Test
	void testFields() {
		Sentence s1 = new Sentence("Java Collections provides implementations of different data structures and algorithms", 2);
		assertEquals(s1.toString(),"Java Collections provides implementations of different data structures and algorithms" );	
		assertEquals(s1.position(), 2);
		assertEquals(s1.length(), 10);
		
		
		Sentence s2 = new Sentence("A HashMap implements the Map interface", 3);
		assertEquals(s2.toString(), "A HashMap implements the Map interface");
		assertEquals(s2.position(), 3);
		assertEquals(s2.length(), 6);
		
	}

	@Test
	void testWordFrequency() {
		
		
		Sentence s1 = new Sentence("In the Collections class you can find numerous methods to facilitate working with collections in Java", 0);
		Map<Word, Integer> freq1 = s1.wordFrequency();
		assertEquals(freq1.get(s1.get(13)), 2 );
		assertEquals(freq1.get(s1.get(1)), 1);
		
		Sentence s2 = new Sentence("One should choose the appropriate data structure for the specific application", 1);
		Map<Word, Integer> freq2 = s2.wordFrequency();
		assertEquals(freq2.get(s2.get(3)), 2 );
		assertEquals(freq2.get(s2.get(8)), 2);
		assertEquals(freq2.get(s2.get(0).toLowerCase()), 1);
	}
	
	
	@Test
	void testWordIndices() {
		
		Sentence s1 = new Sentence("The ArrayList class implements the List interface", 0);
		assertArrayEquals(new int[] {0, 4}, s1.getWordIndices(s1.get(0)).stream().mapToInt(i -> i).toArray());
		assertArrayEquals(new int[] {5}, s1.getWordIndices(s1.get(5)).stream().mapToInt(i -> i).toArray());
		assertArrayEquals(new int[] {}, s1.getWordIndices(new Word("Hello", 3)).stream().mapToInt(i->i).toArray());
		
		
		Sentence s2 = new Sentence("A set cannot store duplicate values", 0);
		assertArrayEquals(new int[] {0}, s2.getWordIndices(s2.get(0)).stream().mapToInt(i -> i).toArray());
		assertArrayEquals(new int[] {1}, s2.getWordIndices(s2.get(1)).stream().mapToInt(i -> i).toArray());
		assertArrayEquals(new int[] {}, s2.getWordIndices(new Word("Interface", 2)).stream().mapToInt(i->i).toArray());

	}
	
	@Test
	void testMostFrequent() {
		
		Sentence s1 = new Sentence("Overriding equals() and hashcode() methods for a class that is used as a key in a HashMap is necessary to ensure correct key comparison", 4);
		Word mostFrequent = s1.mostFrequent();
		assertEquals("a", mostFrequent.toString());
		
		Sentence s2 = new Sentence("The HashMap entryset() method returns a set view of all entries in that hashmap", 4);
		Word mostFrequent2 = s2.mostFrequent();
		assertEquals("hashmap", mostFrequent2.toString());
		
	}
}
