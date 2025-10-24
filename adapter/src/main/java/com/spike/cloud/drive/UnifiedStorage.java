package com.spike.cloud.drive;

import java.util.List;

/**
 * 统一存储(Target)
 * 它定义了存储系统的标准操作方法，允许不同的实现类（如本地文件系统、云存储如 AWS S3 或 Google Cloud Storage）来实现这些方法，从而提供统一的 API 接口。
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public interface UnifiedStorage {

    /**
     *
     *
     * @param path 数据的存储路径
     * @param data 上传的内容
     */
    void upload(String path, byte[] data);

    /**
     *
     *
     * @param path 要下载的数据的存储路径
     * @return {@code byte[] }
     */
    byte[] download(String path);

    void delete(String path);

    /**
     *
     *
     * @param dir 要列出的目录路径
     * @return {@code List<String> }
     */
    List<String> list(String dir);
}
