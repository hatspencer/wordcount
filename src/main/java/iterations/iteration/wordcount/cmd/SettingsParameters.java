package iterations.iteration.wordcount.cmd;

public class SettingsParameters {
	
	private static final String INDEX_FLAG = "-index";
	private static final String DICT_PARAM = "-dictionary=";

	private static final String STOP_WORDS_DEFAULT_LOCATION = "stopwords.txt";

	private boolean index;
	
	private String inputFileName = "";
	
	private String stopWordsFileName = STOP_WORDS_DEFAULT_LOCATION;
	
	private String dictFileName = "";
	
	public static SettingsParameters parse(String[] args) {
		SettingsParameters parameters = new SettingsParameters();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				if (INDEX_FLAG.equals(args[i])) {
					parameters.index = true;
				}
				else if (args[i].startsWith(DICT_PARAM)) {
					parameters.dictFileName = args[i].substring(DICT_PARAM.length());
				}
			}
			else {
				parameters.inputFileName = args[i];
			}
		}
		return parameters;
	}
	
	private SettingsParameters() {
		
	}

	public boolean isIndex() {
		return index;
	}

	public void setIndex(boolean index) {
		this.index = index;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getStopWordsFileName() {
		return stopWordsFileName;
	}

	public void setStopWordsFileName(String stopWordsFileName) {
		this.stopWordsFileName = stopWordsFileName;
	}

	public String getDictFileName() {
		return dictFileName;
	}

	public void setDictFileName(String dictFileName) {
		this.dictFileName = dictFileName;
	}
	
}
