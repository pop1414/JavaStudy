package com.spike.cloud.drive;

import java.util.List;

/**
 * 旧FTP客户端（第三方遗留，不能改）:(Adaptee)
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class LegacyFtpClient implements LegacyFileOps {
    @Override
    public void putFile(String remotePath, byte[] data) {
        ;
    }

    @Override
    public byte[] getFile(String remotePath) {
        ;
        return null;
    }

    @Override
    public void remove(String remotePath) {
        ;
    }

    @Override
    public List<String> listFiles(String dir) {
        ;
        return null;
    }
}
