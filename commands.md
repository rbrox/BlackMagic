Sure, here are some basic Hadoop commands:

1. **List Files in HDFS**:

   ```
   hdfs dfs -ls /path/to/directory
   ```

2. **Create a Directory in HDFS**:

   ```
   hdfs dfs -mkdir /path/to/directory
   ```

3. **Copy Files to HDFS**:

   ```
   hdfs dfs -copyFromLocal /path/to/local/file /path/in/hdfs
   ```

4. **Copy Files from HDFS to Local File System**:

   ```
   hdfs dfs -copyToLocal /path/in/hdfs /path/to/local/directory
   ```

5. **Read the Content of a File in HDFS**:

   ```
   hdfs dfs -cat /path/to/file
   ```

6. **Remove a File or Directory from HDFS**:

   ```
   hdfs dfs -rm /path/to/file
   hdfs dfs -rm -r /path/to/directory
   ```

7. **Move a File or Directory within HDFS**:

   ```
   hdfs dfs -mv /path/to/source /path/to/destination
   ```

8. **View Cluster Information**:

   ```
   hdfs dfsadmin -report
   ```

9. **Check Disk Usage in HDFS**:

   ```
   hdfs dfs -du -h /path/to/directory
   ```

10. **Set Replication Factor for a File in HDFS**:
    ```
    hdfs dfs -setrep -w replication_factor /path/to/file
    ```

These are some of the most commonly used commands for interacting with HDFS. They allow you to perform operations such as listing files, creating directories, copying files, reading file content, removing files or directories, moving files, viewing cluster information, checking disk usage, and setting replication factor.
