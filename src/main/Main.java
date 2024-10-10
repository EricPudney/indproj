package main;
import characters.Enemy;
import characters.Hero;
import dungeons.Dungeon;
import dungeons.Location;
import items.Item;
import items.armour.Helmet;
import items.foods.Apple;
import items.foods.Cake;
import items.weapons.FireSword;
import items.weapons.Sword;
import java.util.Random;

public class Main {
    public static final Random rand = new Random();

    public static void main(String[] args) {

        // generates dungeon, player and enemy, set current location
        Dungeon dungeon = new Dungeon(3, 3);
        Hero player = new Hero("Bob");
        Location loc = dungeon.locations[0][0];
        Enemy enemy = new Enemy("Obnoxious Librarian");

        // generate a random item, add to enemy inventory, print
        Item loot = RandomGeneration.generateRandomItem();
        enemy.inventory.add(loot);
        System.out.println(enemy);

        // enemy drops item, which is now in the location inventory
        enemy.dropItem(loot, loc);
        System.out.println(loc);

        // generate random sword...
        Sword sword = new Sword(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        // ...which cannot be dropped by someone who doesn't have it
        enemy.dropItem(sword, loc);

        // player adds sword to inventory without equipping - attack = 0
        if (player.inventory.add(sword)) {
            System.out.println(player + ", attack: " + player.getAttack());
        }

        // item equipped and removed from inventory, attack = sword.attack
        if (player.equip(sword)) {
            System.out.println(player+ ", attack:  " + player.getAttack());
        }

        // generate some cakes and apples. In inventory they stack up to max stack size
        Apple apple = new Apple(8);
        Apple anotherApple = new Apple(8);
        Cake cake = new Cake(3);
        Cake moreCake = new Cake(3);
        player.inventory.add(apple);
        player.inventory.add(anotherApple);
        player.inventory.add(cake);
        player.inventory.add(moreCake);
        System.out.println(player);

        // swords are not edible...
        if (player.eat(sword)) {
            System.out.println("Oops, I ate a sword.");
        }

        // ...but apples are
        player.eat(apple);

        // generate more equipment, swap swords, put on a helmet
        FireSword magicSword = new FireSword(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        player.inventory.add(magicSword);
        Helmet helm = new Helmet(RandomGeneration.generateRandomQuality(), RandomGeneration.generateRandomMaterial());
        player.inventory.add(helm);

        // return values are not really needed, could have these as void methods too
        // but it can be handy to have a boolean sometimes
        if (player.unEquip(sword)) {
            System.out.println(player);
        }
        if (player.equip(magicSword)) {
            System.out.println(player);
        }
        if (player.equip(helm)) {
            System.out.println(player);
        }
        // can't equip another item of the same type
        if (player.equip(sword)) {
            System.out.println(player);
        }
        // no logic specifically to prevent a player trying to equip
        // an item that is already equipped, but it won't work anyway
        if (player.equip(helm)) {
            System.out.println(player);
        }

        // Apples cannot be equipped of course
        player.equip(apple);

        // but any character, player or enemy, can drop them at a location
        player.dropItem(apple, loc);
        System.out.println(loc);

        // cake restores 5 health but only up to maxHealth
        System.out.println(player);
        player.eat(cake);
        System.out.println(player);

        // Apple tooManyApples = new Apple(25);
        // commented out because this will throw an illegal argument exception.
        // I thought the simplest way to stop players picking up items with a quantity
        // higher than maxQuantity would be to prevent them from being created.
        // Could also have dealt with this in the add() method of course, or just
        // reduced the quantity to max in the constructor, but this seemed better to me.
    }
}