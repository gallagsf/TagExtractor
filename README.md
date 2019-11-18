Tag Extractor
===============
## Assignment Self Assessment:
#### Reflection
[//]: <> (share your thoughts on the assignment, things you learnt and would like to remember when you look back at this assignment)


#### Self Assessment
- [ ] The program runs with no errors.
- [ ] Created a GUI application.
- [ ] The ability to select 2 files from the GUI application (one of the text, and the other of the stop words)
- [ ] Logic is sound.
- [ ] Proper usage of Git and GitHub (frequent commits, explanatory commit messages)

**Your Grade:**  /20

**Notes:**

_______

## Lab Goals:
1. Practice Java Swing GUI and text file I/O.
2. Use Abstract Data Types from the Java Collections Framework
    a. Map
    b. Set
3. Computational Linguistics
    a. Tags
    b. Stop and Noise Words.

This is a challenging multi-part assignment. None of the programming is beyond your
capability, but it has a bit more structural complexity. Read the directions carefully, don’t just
start coding. You have to plan your program first.

## Discussions:
Computational linguistics is the study of linguistics using computers. It often involves large datasets. Related areas are Natural Language Processing, text-to-speech, etc.

One way of looking at a document and comparing documents is to examine the frequency in which words occur. For instance, we would assume that an article with the word UFO in it many times is probably about UFOs… A document that does not contain the word would not be. (Early search engines used this approach to determine the documents to include in search results.)

However, many words in the document are not relevant. We call these noise words or stop words. Pronouns, adverbs, prepositions, and commonly occurring words are noise words. Examples are: a, an, the, to, is, are, etc.

After we exclude these words the remaining relevant words are called tags.

We normalize our tags by making them all the same case or ignoring case when we process the documents.

## Directions
Create a Java Swing GUI program that lest the user pick a text file and a stop/noise words file to
scan for and extract tags.
- Display the name of the file you’re extracting the tags from.
- Display the tags and their frequency in a JtextArea/Scroll Pane.
- Allow the user to save the extracted frequencies to a file.

## Scanning Process:
The program will open and scan the file and store the frequency of each word that occurs in a document. (This is exactly like the worked example in the reading section). You will remove any non-letter characters and force the words to be all lowercase. You will end up with a map that contains <String> <Integer> where String is the word as the key and where the Integer value is the number of times that the word appears in the scanned documents. That is the frequency that the word occurs within the scanned files.

However, one additional aspect is that you will implement a stop word filter. So before you add a word to the map, you first check to see if it is in the set of stop words and reject it if it is. You should load the stop word set from a local text file (File is attached with the assignment instructions. The stop words file is a text file with one word per line. it’s sorted alphabatically and are all lowercase).

Stop words are words that occur with high frequencies in a text (i.e. “The”, “a”, “is”, “are”, …). Usually these words are filtered out from the document being analyzed. If you use a TreeSet or TreeMap it will be sorted as a by-product.

## Deliverable:
A complete Java Project named TagExtractor.
* The used stop words filter.
* The text analyzed using the program (a Tale of 2 cities is attached with the assignment instructions)
    * [A Tale of Two Cities](https://it2045c.github.io/Labs/Assignments/8.Tag_Extractor/assets/aTaleOfTwoCities.txt)
    * [Stop Words](https://it2045c.github.io/Labs/Assignments/8.Tag_Extractor/assets/stopWords.txt)

* The output file of the extracted tags and their frequencies, which might look like the
following:
![example output](https://it2045c.github.io/Labs/Assignments/8.Tag_Extractor/assets/TagExtractorExample.png)

## Grading
1. The program runs with no errors.
2. Created a GUI application.
3. The ability to select 2 files from the GUI application (one of the text, and the other of the stop words)
4. Logic is sound.
5. Proper usage of Git and GitHub (frequent commits, explanatory commit messages)


## Submission:
You will be submitting a git repository with the following naming
convention, <your 6+2>-assignment8-tag-extractor, (i.e., gilanyym-assignment8-tag-extractor).