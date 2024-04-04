/opt/homebrew/bin/hadoop jar /opt/homebrew/Cellar/hadoop/3.3.1/libexec/share/hadoop/tools/lib/hadoop-streaming.jar \
-input /input/path \
-output /output/path \
-mapper /path/to/mapper.py \
-reducer /path/to/reducer.py \
-file /path/to/mapper.py \
-file /path/to/reducer.py

- Find the Hadoop streaming jar file in the Hadoop installation directory. The path may vary depending on your Hadoop version and installation method. (use 'whereis hadoop' or 'echo $HADOOP_HOME' to find the path)

- Specify the input and output paths for your MapReduce job.

- prep sh file 'chmod +x run_hadoop_job.sh'

- Run the Hadoop job using the following command:
  ```
  ./run_hadoop_job.sh
  ```
