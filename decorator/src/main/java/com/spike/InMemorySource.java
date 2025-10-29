package com.spike;

/**
 * 具体组件，是抽象组件的具体实现类，复杂实现最基本的核心功能（普通存储），装饰器在此基础上扩展即可
 *
 * @author Ayanami
 * @date 2025/10/29
 */
public class InMemorySource implements DataSource {
    private String data;

    @Override
    public void write(String data) {
        this.data = data;
    }


    @Override
    public String read() {
        return this.data;
    }
}
