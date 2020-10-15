Iteration 1

A word: characters which are enclosed between two whitespaces. 
Start and end of line can be considered as whitespace.
There are no newlines in a text.
A whitespace can be represented by the regex "\\s+";

word        1
word word   2
wo2rd       0

Iteration 2
Requirements change means tests need to be updated.
The order of the words in the stopwords file does not matter.

Iteration 3
If the file provided does not exist, an error message will be printed out.
UPDATED ASSUMPTION: There can be newlines in a text.

Iteration 4
Dashes and fullstops should be treated like a whitespace.