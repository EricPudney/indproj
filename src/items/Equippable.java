package items;

import characters.Character;

public interface Equippable {
    void applyEffect(Character character);
    void removeEffect(Character character);
}
