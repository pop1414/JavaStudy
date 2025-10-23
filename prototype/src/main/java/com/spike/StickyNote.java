package com.spike;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 便利贴类，作为原型模式中的“具体原型”角色，ConcretePrototype
 *
 * <p>包含文字内容、样式信息以及标签与评论列表。
 * 提供浅拷贝与深拷贝两种复制方式，用于演示共享引用与独立副本的区别。</p>*
 *
 * @author Ayanami
 * @date 2025/10/22
 */
@Getter
@Setter
// 注意是继承，因为是Prototype是抽象类，不是接口
public class StickyNote extends Prototype<StickyNote> {
    // 浅拷贝，不可变类型或值类型，因为即使共享引用也不会导致意外变更
    private String text;

    // 可变引用，根据场景选择浅or深，思考克隆对象修改这个字段的时候，是否会影响原对象
    private Style style;

    // 可变集合，深拷贝时必须复制容器（以及容器内的可变元素），集合本身可变
    private List<String> tags;
    private List<String> comments;

    StickyNote(String text, Style style, List<String> tags, List<String> comments) {
        this.text = text;
        this.style = style;
        this.tags = tags;
        this.comments = comments;
    }

    // 浅拷贝
    @Override
    public StickyNote copyShallow() throws CloneNotSupportedException {
        return super.copyShallow();
    }

    // 深拷贝
    @Override
    public StickyNote copyDeep() throws CloneNotSupportedException {
        StickyNote clone = copyShallow();

        // 实列的style若不为null，则需要深拷贝：新建一个Style对象
        clone.style = this.style != null ? clone.style.clone() : null;

        // tags与comments同理
        clone.tags = this.tags != null ? new ArrayList<>(clone.tags) : null;
        clone.comments = this.comments != null ? new ArrayList<>(clone.comments) : null;

        return clone;
    }

    @Override
    public String toString() {
        return "StickyNote{" +
                "text='" + text + '\'' +
                ", style=" + style +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }
}
