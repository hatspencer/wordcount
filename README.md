# Assignment

https://ccd-school.de/coding-dojo/agility-katas/word-count-i/

# Assumptions

- Words are strings of characters [a-zA-Z] of length >= 1 separated by whitespace characters (defined by RegExp).
- Invalid character combinations, e.g. "wo2rd", are ignored.
- CLI file name argument is a absolute or relative file path.
- Files (stopwords.txt and the optional text input file) can be correctly read using UTF-8 encoding.
- Errors (e.g. if file does not exist) are handled by simply throwing runtime exceptions and letting the JRE print the stacktrace. I assume this is good enough for now.
- Unique word count ignores word casing.