package main;
import characters.Hero;
import dungeon.Location;
import items.armour.Helmet;
import items.foods.Apple;
import items.weapons.FireSword;
import items.weapons.Sword;
import java.util.Random;

public class Main {
    public static final Random rand = new Random();

    public static void main(String[] args) {
        Hero player = new Hero("Bob");
        Location loc = new Location();

        /*Sword sword = new Sword(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        System.out.println(sword);
        System.out.println(player);

        if (player.inventory.add(sword)) {
            System.out.println(player);
        }
        if (player.equip(sword)) {
            sword.applyEffect(player);
            System.out.println(player);
        }*/
        Apple apple = new Apple();
        for (int i = 0; i < 30; i++) {
            apple = new Apple();
            player.inventory.add(apple);
        }
    /*    System.out.println(player);
        if (player.eat(sword)) {
            System.out.println("Oops, I ate a sword.");
        }
        if (player.eat(apple)) {
            System.out.println(player);
        }
        Location loc = new Location();
        System.out.println(loc);
        if (loc.enemy != null) {
            System.out.println(loc.enemy);
        }
        FireSword magicSword = new FireSword(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        player.inventory.add(magicSword);
        Helmet helm = new Helmet(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        player.inventory.add(helm);
        if (player.unEquip(sword)) {
            sword.removeEffect(player);
            System.out.println(player);
            if (player.equip(magicSword)) {
                magicSword.applyEffect(player);
                System.out.println(player);
            }
        }
        if (player.equip(helm)) {
            System.out.println(player);
        }*/

        player.dropItem(apple, loc);
        System.out.println(loc);
        System.out.println(player);
    }
}