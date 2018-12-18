package at.egit.wordcount;

class InputValidation {

    private final static String LETTERS_CHECK = "^[A-Za-z ]+$";

    boolean validate(String input) {
        return input.matches(LETTERS_CHECK);
    }
}
