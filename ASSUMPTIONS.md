
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

# Iteration 5

* Words separated by hypen are not considered to be two words.

# Iteration 6

* Average word length will be calculated and result will be formated to two decimal places.
* Average word length is calculated from all words.

# Iteration 7

* An index (set of unique words) is printed if an argument `-index` is provided.

# Iteration 8

* A dictionary is provided as a file. Words not found in the dictionary will be marked with a star in the index.

# Iteration 9

* If an input is read from console, user should be allowed to enter several texts. Application will analyze each text 
    like it is executed several times. 
