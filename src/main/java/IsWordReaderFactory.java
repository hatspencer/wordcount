import wordreader.WordReader;

public interface IsWordReaderFactory {

    WordReader getReader(String[] args);

}
