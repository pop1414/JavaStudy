package com.spike.cloud.drive;

/**
 * 具体的业务实现，继承默认适配器即可
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class FtpOnlyOnSuccess extends StorageEventAdapter {
    @Override
    public void onUploadSuccess(String path) {
        System.out.println("[Ftp] uploaded: " + path);
    }
}
