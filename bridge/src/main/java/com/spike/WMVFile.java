package com.spike;

/**
 * 具体实现类
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public class WMVFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("  [WMV ] 正在解码文件：" + fileName);
    }
}
