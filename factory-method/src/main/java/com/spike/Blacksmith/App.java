package com.spike.Blacksmith;

/**
 * Main application class to demonstrate the Blacksmith and Weapon system.
 *
 * @author Ayanami
 * @date 2025/10/19
 */
public class App {
    public static void main(String[] args) {
        // Demonstrate OrcBlacksmith
        Blacksmith orcBlacksmith = new OrcBlacksmith();
        System.out.println("Using " + orcBlacksmith + ":");

        Weapon orcSpear = orcBlacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println("Manufactured: " + orcSpear);

        Weapon orcAxe = orcBlacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println("Manufactured: " + orcAxe);

        Weapon orcShortSword = orcBlacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
        System.out.println("Manufactured: " + orcShortSword);

        // Demonstrate ElfBlacksmith
        Blacksmith elfBlacksmith = new ElfBlacksmith();
        System.out.println("\nUsing " + elfBlacksmith + ":");

        Weapon elfSpear = elfBlacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println("Manufactured: " + elfSpear);

        Weapon elfAxe = elfBlacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println("Manufactured: " + elfAxe);

        Weapon elfShortSword = elfBlacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
        System.out.println("Manufactured: " + elfShortSword);

        // Handle undefined weapon type
        Weapon undefined = orcBlacksmith.manufactureWeapon(WeaponType.UNDEFINED);
        System.out.println("\nManufactured undefined: " + undefined);
    }
}