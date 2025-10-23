package com.spike;


import lombok.Getter;
import lombok.Setter;

/**
 * 样式类，用于描述便利贴的视觉风格。
 *
 * <p>该类的字段均为不可变类型（字符串），因此可通过浅拷贝安全复制。</p>
 *
 * <ul>
 *     <li>bgColor — 背景颜色</li>
 *     <li>textColor — 字体颜色</li>
 *     <li>fontFamily — 字体样式</li>
 * </ul>
 *
 * @author Ayanami
 * @date 2025/10/22
 */
@Getter
@Setter
public class Style implements Cloneable {
    private String bgColor;
    private String textColor;
    private String fontFamily;

    Style(String bgColor, String textColor, String fontFamily) {
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.fontFamily = fontFamily;
    }

    // 字段全是不可变字符串，浅拷贝即可
    // 新的Style类的地址内存与旧的不一样，但是因为是浅拷贝，所以两者的字段的地址内存是一样的
    @Override
    public Style clone() throws CloneNotSupportedException {
        return (Style) super.clone();
    }

    @Override
    public String toString() {
        return "Style{" + bgColor + ", " + textColor + ", " + fontFamily + "}";
    }
}
