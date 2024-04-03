import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text word = new Text();
    private Text docId = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] parts = line.split("\t"); // Assuming tab-separated input
        if (parts.length >= 2) {
            String docId = parts[0];
            String[] words = parts[1].split(" "); // Assuming words are separated by space
            for (String word : words) {
                this.word.set(word);
                this.docId.set(docId);
                context.write(this.word, this.docId);
            }
        }
    }
}

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuilder docList = new StringBuilder();
        for (Text docId : values) {
            if (docList.length() > 0) {
                docList.append(", ");
            }
            docList.append(docId.toString());
        }
        context.write(key, new Text(docList.toString()));
    }
}

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvertedIndex {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: InvertedIndex <input path> <output path>");
            System.exit(-1);
        }
        Job job = new Job();
        job.setJarByClass(InvertedIndex.class);
        job.setJobName("Inverted Index");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(InvertedIndexMapper.class);
        job.setReducerClass(InvertedIndexReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
