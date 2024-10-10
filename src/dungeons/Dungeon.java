package dungeons;

import java.util.Arrays;

public class Dungeon {
    public final Location[][] locations;

    public Dungeon(int height, int width) {
        locations = new Location[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    @Override
    public String toString() {
        return "Dungeon: \n" + Arrays.deepToString(locations);
    }
}
