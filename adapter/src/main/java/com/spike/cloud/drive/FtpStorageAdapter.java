package com.spike.cloud.drive;

import java.util.List;
import java.util.Objects;

/**
 * (Adapter)
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class FtpStorageAdapter implements UnifiedStorage {
    private final LegacyFtpClient ftpClient;

    public FtpStorageAdapter(LegacyFtpClient ftpClient) {
        this.ftpClient = Objects.requireNonNull(ftpClient);
    }

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
}
