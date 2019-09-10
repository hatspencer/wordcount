import static org.junit.Assert.*;


import org.junit.Test;

public class WordCountApplicationTest {

    @Test
    public void callWithOnlyLettersContained() {
        String input = "Just letters inside";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(3, numberOfWords);
    }

    @Test
    public void callWithOnlyNumbers() {
        String input = "11 11 11";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(0, numberOfWords);
    }

    @Test
    public void callWithEmptyInput() {
        String input = "";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(0, numberOfWords);
    }

    @Test
    public void callWithOneWord() {
        String input = "JustOneWord";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(1, numberOfWords);
    }

    @Test
    public void callWithWordsContainsInvalidCharacters() {
        String input = "1nvalid character in sentence";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(3, numberOfWords);
    }

    @Test
    public void callWithOtherDelimiterContained(){
        String input = "1nvalid.character in sentence";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(2, numberOfWords);
    }

    @Test
    public void callWithInvalidCharacterAndNumbers(){
        String input = "$nvalid character11 in sentence";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(2, numberOfWords);
    }

    @Test
    public void callWithInputContainsInvalidWordListenInFile(){
        String input = "A character11 on sentence the";
        int numberOfWords = WordCountApplication.countWordsInText(input);
        assertEquals(1, numberOfWords);
    }

    @Test
    public void stopwordsDoesntExists(){
        String[] invalidWords = WordCountApplication.getInvalidWords("stringwords.txt");
        assertEquals(0,invalidWords.length);
    }
    @Test
    public void stopwordsExists(){
        String[] invalidWords = WordCountApplication.getInvalidWords("stopwords.txt");
        assertEquals(4,invalidWords.length);
    }

}