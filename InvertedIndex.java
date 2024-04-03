import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndex {
    
    public static class TokenizerMapper extends Mapper<LongWritable, Text, Text, Text>{
        private Text word = new Text();
        private Text docId = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] parts = line.split("\t"); // Assuming tab-separated input
            if (parts.length >= 2) {
                String docId = parts[0];
                docId.set(docId);
                String[] words = parts[1].split(" "); // Assuming words are separated by space
                for (String word : words) {
                    this.word.set(word);
                    context.write(this.word, this.docId);
                }
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
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

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "inverted index");
        job.setJarByClass(InvertedIndex.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
