#!/usr/bin/env python

import sys

current_word = None
current_docs = set()

# Input comes from STDIN (standard input)
for line in sys.stdin:
    # Remove leading and trailing whitespace
    line = line.strip()
    # Split the line into word and document IDs
    word, docs = line.split('\t', 1)
    docs = docs.split()
    # If the word is the same as the current word, add document IDs to the set
    if current_word == word:
        current_docs.update(docs)
    # Otherwise, if it's a new word, output the inverted index for the current word
    else:
        if current_word:
            print(f"{current_word}\t{' '.join(sorted(current_docs))}")
        current_word = word
        current_docs = set(docs)

# Output the inverted index for the last word
if current_word:
    print(f"{current_word}\t{' '.join(sorted(current_docs))}")
