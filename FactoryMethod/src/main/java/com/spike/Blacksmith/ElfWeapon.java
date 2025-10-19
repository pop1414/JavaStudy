package com.spike.Blacksmith;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/19
 */
public class ElfWeapon implements Weapon {
    // 枚举类为final
    private final WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public WeaponType weaponType() {
        return weaponType;
    }

    // TODO 待实现toString()
}
