# Assignment

https://ccd-school.de/coding-dojo/agility-katas/word-count-i/

# Assumptions

- Words are strings of characters [a-zA-Z] of length >= 1 separated by whitespace characters (defined by RegExp).
- Invalid character combinations, e.g. "wo2rd", are ignored.
- CLI file name argument is a absolute or relative file path.
- Files (stopwords.txt and the optional text input file) can be correctly read using UTF-8 encoding.
- Errors (e.g. if file does not exist) are handled by simply throwing runtime exceptions and letting the JRE print the stacktrace. I assume this is good enough for now.
- Unique word count ignores word casing and only counts valid words.
- Average word length is calculated on list of all valid words (not the unique words.)
- Average word length decimal separator uses JVM's current locale. On a German system, this will output a comma instead of a period. (Use JVM options -Duser.country=US -Duser.language=en override JVM locale.)
- Word index should be based on list of all words (not the unique words.)
- Word index should output words in Locale-specific alphabetical order.
- CLI argument order is not relevant, i.e. "... -index input.txt" and "... input.txt -index" are allowed.