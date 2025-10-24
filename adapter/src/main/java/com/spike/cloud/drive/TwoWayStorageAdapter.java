package com.spike.cloud.drive;

import java.util.List;
import java.util.Objects;

/**
 * 双向适配器，同时实现两个接口，同时有两个类（既是Target也是Adaptee）
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class TwoWayStorageAdapter implements UnifiedStorage, LegacyFileOps {

    private final LegacyFtpClient ftpClient;
    private final UnifiedStorage target;

    public TwoWayStorageAdapter(UnifiedStorage target, LegacyFtpClient ftpClient) {
        this.target = Objects.requireNonNull(target);
        this.ftpClient = Objects.requireNonNull(ftpClient);
    }

    // 适配LegacyFtpClient
    @Override
    public void upload(String path, byte[] data) {
        ftpClient.putFile(path, data);
    }

    @Override
    public byte[] download(String path) {
        return ftpClient.getFile(path);
    }

    @Override
    public void delete(String path) {
        ftpClient.remove(path);
    }

    @Override
    public List<String> list(String dir) {
        return ftpClient.listFiles(dir);
    }

    // 适配target
    @Override
    public void putFile(String remotePath, byte[] data) {
        target.upload(remotePath, data);
    }

    @Override
    public byte[] getFile(String remotePath) {
        return target.download(remotePath);
    }

    @Override
    public void remove(String remotePath) {
        target.delete(remotePath);
    }

    @Override
    public List<String> listFiles(String dir) {
        return target.list(dir);
    }
}
