import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException,
            InterruptedException {
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

