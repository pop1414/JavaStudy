package com.spike.cloud.drive;

import java.util.List;
import java.util.Objects;

/**
 * (Adapter)
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class ObjectStorageAdapter implements UnifiedStorage {
    private final ObjectStorageSdk oss;

    public ObjectStorageAdapter(ObjectStorageSdk oss) {
        this.oss = Objects.requireNonNull(oss);
    }

    @Override
    public void upload(String path, byte[] data) {
        oss.put(path, data);
    }

    @Override
    public byte[] download(String path) {
        return oss.get(path);
    }

    @Override
    public void delete(String path) {
        oss.deleteObject(path);
    }

    @Override
    public List<String> list(String dir) {
        return oss.listKeys(dir);
    }
}
