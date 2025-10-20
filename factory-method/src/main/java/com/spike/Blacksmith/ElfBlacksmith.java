package com.spike.Blacksmith;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 *
 * @author Ayanami
 * @date 2025/10/19
 */
public class ElfBlacksmith implements Blacksmith {

    private static final Map<WeaponType, ElfWeapon> ELFARSENAL;

    static {
        ELFARSENAL = new EnumMap<>(WeaponType.class);
        Arrays.stream(WeaponType.values()).forEach(type -> ELFARSENAL.put(type, new ElfWeapon(type)));
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ELFARSENAL.get(weaponType);
    }

    @Override
    public String toString() {
        return "The orc blacksmith";
    }
}
