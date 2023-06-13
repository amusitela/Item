package com.ruoyi.web.getdata;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GetMinio {
    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeyException, IOException, MinioException {

        // 使用Minio服务器的URL，Access Key和Secret Key创建Minio客户端对象
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("YOUR-ACCESSKEYID", "YOUR-SECRETACCESSKEY")
                        .build();

        // 检查存储桶是否存在
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket("my-bucket").build());
        if (found) {
            System.out.println("my-bucket exists.");
        } else {
            System.out.println("my-bucket does not exist.");
        }
    }
}
