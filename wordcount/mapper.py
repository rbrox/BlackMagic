#!/usr/bin/env python

import sys

# Initialize variables
current_word = None
current_count = 0
word = None

# Input comes from STDIN (standard input)
for line in sys.stdin:
    # Remove leading and trailing whitespace
    line = line.strip()

    # Split the line into words
    words = line.split()

    # Increase counters
    for word in words:
        # Print tab-delimited word count pairs
        print(f"{word}\t1")
