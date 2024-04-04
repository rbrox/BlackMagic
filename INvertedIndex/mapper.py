#!/usr/bin/env python

import sys
import re

# Initialize a dictionary to store the inverted index
inverted_index = {}

# Input comes from STDIN (standard input)
for line in sys.stdin:
    # Remove leading and trailing whitespace
    line = line.strip()
    # Split the line into words
    words = re.findall(r'\b\w+\b', line)
    # Get the document ID from the first word
    doc_id = words[0]
    # Update the inverted index with words and their document IDs
    for word in words[1:]:
        if word not in inverted_index:
            inverted_index[word] = set()
        inverted_index[word].add(doc_id)

# Output the inverted index
for word, doc_ids in inverted_index.items():
    print(f"{word}\t{' '.join(doc_ids)}")
