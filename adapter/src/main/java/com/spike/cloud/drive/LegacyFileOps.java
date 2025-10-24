package com.spike.cloud.drive;

import java.util.List;

/**
 * 在双向适配器扩展中，为Target
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public interface LegacyFileOps {

    void putFile(String remotePath, byte[] data);

    byte[] getFile(String remotePath);

    void remove(String remotePath);

    List<String> listFiles(String dir);
}