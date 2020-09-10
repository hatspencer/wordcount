
# Iteration 1

* Words are stretches of characters containing characters a-z, A-Z
* Words are separated by any whitespace character.
* Words containing any character not mentioned above are considered invalid and should not be counted.

Examples:

1. `word`

    count: 1

2. `word word word`

    count: 3

3. `word word        word      word`

    count: 4

4. `word, word. word!`

    count: 0

5. `word1word 2word word5`

    count: 0

6. `$word wor%d word&`

    count: 0

# Iteration 2

* Collection of stop-words provided by a file which is a part of the application (should reside in resources directory).
* Stop-words should not be counted.
* All provided stop-words are valid, it is not necessary to validate those.

# Iteration 3

* A file containing words to count can be provided as a program argument. In that case program should count words in a file.
* If no file is provided application will read for text from console.
* If non-existing or inaccessible file is provided application will print an error message and will fall back to reading text from console.  
    This additional assumption is based on my (vkuzel) question during interview.

# Iteration 4

* The application will count number of unique words from those words counted normally.
* **Change of assumptions from iteration 1**. Following set of characters will split words `-.,:;_?!"(){}[]` and whitespace character.
