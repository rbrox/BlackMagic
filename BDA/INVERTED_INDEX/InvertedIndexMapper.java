import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text word = new Text();
    private Text docId = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String[] parts = line.split("\t"); // Assuming tab-separated input
        if (parts.length >= 2) {
            String DocId = parts[0];
            docId.set(DocId);
            String[] words = parts[1].split(" "); // Assuming words are separated by space
            for (String w : words) {
                word.set(w);
                context.write(word, docId);
            }
        }
    }
}

