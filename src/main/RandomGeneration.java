package main;

import items.Item;
import items.Material;
import items.Quality;
import items.armour.Helmet;
import items.foods.Apple;
import items.foods.Cake;
import items.weapons.Sword;

import static main.Main.rand;

public abstract class RandomGeneration {
    public static Quality generateRandomQuality() {
        Quality quality = Quality.POOR;
        switch (rand.nextInt(1,6)) {
            case 1:
                quality = Quality.GOOD;
                break;
            case 2:
                quality = Quality.FAIR;
                break;
            case 3:
                quality = Quality.EXCELLENT;
                break;
            default:
                break;
        }
        return quality;
    }

    public static Material generateRandomMaterial() {
        Material material = Material.LEATHER;
        switch (rand.nextInt(1, 6)) {
            case 1:
                material = Material.IRON;
                break;
            case 2:
                material = Material.STEEL;
                break;
            default:
                break;
        }
        return material;
    }

    public static Item generateRandomItem() {
        return switch (rand.nextInt(1, 6)) {
            case 1 -> new Sword(generateRandomQuality(), generateRandomMaterial());
            case 2 -> new Helmet(generateRandomQuality(), generateRandomMaterial());
            case 3, 4 -> new Cake();
            default -> new Apple();
        };
    }
}
