package items.weapons;

public class FireSword implements FireWeapon {
    int bonusDamage = 2;

    @Override
    public int burnDamage() {
        return bonusDamage;
    }
}
