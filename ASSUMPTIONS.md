
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
