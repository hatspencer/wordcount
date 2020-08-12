package wordcount.wordcounter.input;

public class InputFactory {

    public static Input getInput(String filename) {
        if (filename == null || filename.isEmpty()) {
            ManuallyInput manuallyInput = new ManuallyInput();
            return manuallyInput;
        } else {
            FileInput fileInput = new FileInput(filename);
            return fileInput;
        }
    }
}
