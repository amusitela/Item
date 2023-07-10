package com.ruoyi.Logistics.utils.getdata;

import com.sun.javaws.exceptions.InvalidArgumentException;
import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.MinioException;
import io.minio.errors.RegionConflictException;



import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GetMinio {
    public static String getMinio(String endpoint,String access_key,String secret_key,String bucket_name,String object_name,String filepath ) throws InvalidKeyException, InvalidArgumentException {
        try {
            // 创建MinioClient对象
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)  // MinIO服务器的URL
                    .credentials(access_key, secret_key)  // MinIO访问凭证
                    .build();

            // 检查存储桶是否存在，如果不存在则创建
            String bucketName = bucket_name;  // 存储桶名称
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                System.out.println("存储桶创建成功！");
            } else {
                System.out.println("存储桶已存在！");
            }

            // 获取文件并保存到本地
            String objectName = object_name;  // 对象名称（文件路径）
            String filePath = filepath;  // 本地保存文件的路径和文件名

            minioClient.downloadObject(
                    DownloadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(filePath)
                            .build()
            );
            System.out.println("文件下载成功！");
            return filePath;
        } catch (ErrorResponseException e) {
            System.out.println("发生错误响应：" + e.getMessage());
            return "发生错误响应：" + e.getMessage();
        } catch (RegionConflictException e) {
            System.out.println("存储桶位置冲突：" + e.getMessage());
            return "存储桶位置冲突：" + e.getMessage();
        } catch (MinioException e) {
            System.out.println("发生MinIO异常：" + e.getMessage());
            return "发生MinIO异常：" + e.getMessage();
        } catch (IOException e) {
            System.out.println("发生IO异常：" + e.getMessage());
            return "发生IO异常：" + e.getMessage();
        } catch (InvalidKeyException e) {
            System.out.println("无效的访问凭证：" + e.getMessage());
            return "无效的访问凭证：" + e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("不支持的访问凭证算法：" + e.getMessage());
            return "不支持的访问凭证算法：" + e.getMessage();
        }
    }
}
