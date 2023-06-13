package com.ruoyi.Logistics.utils.getdata;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GetHDFS {

public static void main(String[] args) throws IOException {

    String filePath = "hdfs://<hdfs_server>:<port>/<path_to_file_on_hdfs>";
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(filePath), conf);
    FSDataInputStream in = fs.open(new Path(filePath));
    InputStream stream = in.getWrappedStream();

    byte[] buffer = new byte[1024];
    int len = stream.read(buffer);
    while (len != -1) {
        System.out.write(buffer, 0, len);
        len = stream.read(buffer);
    }
    in.close();
}

}