package com.spike.cloud.drive;

import java.util.List;

/**
 * 对象存储（Object Storage）是一种现代的云存储方式，如 AWS S3、阿里云 OSS 或 Google Cloud Storage。它不像传统文件系统那样有严格的目录结构，而是使用“键”（key）来标识对象，键可以模拟目录（通过前缀）。这个类提供了上传、下载、删除和列出对象的操作，适合处理大规模、非结构化数据存储。
 * (Adaptee)
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class ObjectStorageSdk {
    public void put(String key, byte[] data) {
        ;
    }

    public byte[] get(String key) {
        ;
        return null;
    }

    public void deleteObject(String key) {
        ;
    }

    public List<String> listKeys(String dir) {
        ;
        return null;
    }
}
