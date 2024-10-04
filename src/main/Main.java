package main;
import characters.Hero;
import dungeon.Location;
import items.foods.Apple;
import items.weapons.Sword;
import java.util.Random;

public class Main {
    public static Random rand = new Random();

    public static void main(String[] args) {
        Sword sword = new Sword(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        System.out.println(sword);
        Hero player =  new Hero("Bob");
        System.out.println(player);

        if (player.inventory.add(sword)) {
            System.out.println(player);
        }
        if (sword.equip(player)) {
            System.out.println(player);
        }
        Apple apple = new Apple();
        Apple apple2 = new Apple();
        player.inventory.add(apple);
        player.inventory.add(apple2);
        System.out.println(player);
        apple.consume(player);
        System.out.println(player);
        Location loc = new Location();
        System.out.println(loc);

    }
}