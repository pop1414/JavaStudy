package com.spike.Blacksmith;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/19
 */
public enum WeaponType {
    SHORT_SWORD("short_sword"),
    SPEAR("spear"),
    AXE("axe"),
    UNDEFINED("");

    private final String title;

    private WeaponType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
