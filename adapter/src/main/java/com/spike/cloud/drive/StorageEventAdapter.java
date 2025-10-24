package com.spike.cloud.drive;

/**
 * 默认适配器（抽象类）
 *
 * @author Ayanami
 * @date 2025/10/24
 */
public abstract class StorageEventAdapter implements StorageEventListener {
    @Override
    public void onUploadStart(String path) {

    }

    @Override
    public void onUploadSuccess(String path) {

    }

    @Override
    public void onUploadFailure(String path, Throwable t) {
    }

    @Override
    public void onDownload(String path) {

    }

    @Override
    public void onDelete(String path) {

    }

    @Override
    public void onList(String dir) {

    }
}
