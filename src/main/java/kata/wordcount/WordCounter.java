package kata.wordcount;

class WordCounter {

    int count(String text) {
        String[] words = text.split(" ");
        return words.length;
    }
}
