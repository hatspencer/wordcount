package at.flwal.erste.test;

public class TestData {

	public static final String NOT_A_WORD = "Fo0o";
	public static final String ALSO_NOT_A_WORD = "Ba$r";
	public static final String TWO_WORDS = "Ba r ";
	public static final String TWO_WORDS_WITH_MORE_SPACES = "Ba  r  ";
	public static final String MORE_WORDS = " abba  BABBA cdfg jKL   ";
	public static final String UMLAUTS_ARE_NOT_A_PART = " abba   cdfg jKLö   ";

	public static final String TWO_WORDS_AND_ONE_DESIGNATED_STOPWORD = "he the idea";
	public static final String TWO_WORDS_AND_SAME_STOPWORD_TWICE = " he the  the  idea ";
	public static final String TWO_WORDS_WITH_TWO_DESIGNATED_STOPWORDs = " he the  has  a ";

	public static final String TEST_RESOURCES_PATH = "src/test/resources";
	public static final String TEST_INPUT_FILE_PATH = TEST_RESOURCES_PATH + "/mytext.txt";
	public static final String TEST_STOPWORDS_PATH = TEST_RESOURCES_PATH + "/stopwords.txt";

}
