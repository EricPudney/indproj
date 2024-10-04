package items;

import characters.Character;

public interface Equippable {
    boolean equip(Character character);
    boolean unEquip(Character character);
}
