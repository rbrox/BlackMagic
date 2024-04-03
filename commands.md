Sure, here are more Hadoop commands for various tasks:

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

8. **Set Replication Factor for a File in HDFS**:

   ```
   hdfs dfs -setrep -w replication_factor /path/to/file
   ```

9. **Check Disk Usage in HDFS**:

   ```
   hdfs dfs -du -h /path/to/directory
   ```

10. **Show File Block Locations**:

    ```
    hdfs fsck /path/to/file -files -blocks -locations
    ```

11. **Check HDFS Health**:

    ```
    hdfs dfsadmin -report
    ```

12. **Run a MapReduce Job**:

    ```
    hadoop jar <JAR_FILE> <MAIN_CLASS> <INPUT_PATH> <OUTPUT_PATH>
    ```

13. **View MapReduce Job History**:

    ```
    mapred job -history <JOB_ID>
    ```

14. **Kill a MapReduce Job**:

    ```
    mapred job -kill <JOB_ID>
    ```

15. **Format Namenode**:

    ```
    hdfs namenode -format
    ```

16. **Start Hadoop Services**:

    ```
    start-all.sh
    ```

17. **Stop Hadoop Services**:

    ```
    stop-all.sh
    ```

18. **Check Hadoop Version**:

    ```
    hadoop version
    ```

19. **View Hadoop Configuration**:

    ```
    hadoop conf
    ```

20. **List Available Commands**:

    ```
    hadoop
    ```

21. **Check Hadoop Cluster Summary**:

    ```
    yarn cluster --list
    ```

22. **View Hadoop Cluster Nodes**:

    ```
    yarn node -list
    ```

23. **View Hadoop Cluster Applications**:
    ```
    yarn application -list
    ```

These commands cover a wide range of tasks related to managing HDFS, running MapReduce jobs, checking Hadoop cluster status, and more. You can use them to interact with your Hadoop cluster efficiently.
