package com.spike;

/**
 * 具体实现类
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class RMVBFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("  [RMVB] 正在解码文件：" + fileName);
    }
}
