#!/bin/bash

# Set input and output paths
INPUT_PATH="./input"
OUTPUT_PATH="./output"

# Path to Hadoop Streaming JAR
HADOOP_STREAMING_JAR="/opt/homebrew/Cellar/hadoop/3.3.6/libexec/share/hadoop/tools/lib/hadoop-streaming-3.3.6.jar"

# Path to mapper and reducer scripts
MAPPER_SCRIPT="./mapper.py"
REDUCER_SCRIPT="./reducer.py"

# Run Hadoop Streaming job
/opt/homebrew/bin/hadoop jar "$HADOOP_STREAMING_JAR" \
-input "$INPUT_PATH" \
-output "$OUTPUT_PATH" \
-mapper "$MAPPER_SCRIPT" \
-reducer "$REDUCER_SCRIPT" \
-file "$MAPPER_SCRIPT" \
-file "$REDUCER_SCRIPT"
