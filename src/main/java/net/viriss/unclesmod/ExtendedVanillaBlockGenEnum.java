package net.viriss.unclesmod;

import net.minecraft.world.level.block.*;

public enum ExtendedVanillaBlockGenEnum {
    red_wool(Blocks.RED_WOOL),
    orange_wool(Blocks.ORANGE_WOOL),
    yellow_wool(Blocks.YELLOW_WOOL),
    lime_wool(Blocks.LIME_WOOL),
    green_wool(Blocks.GREEN_WOOL),
    cyan_wool(Blocks.CYAN_WOOL),
    light_blue_wool(Blocks.LIGHT_BLUE_WOOL),
    blue_wool(Blocks.BLUE_WOOL),
    purple_wool(Blocks.PURPLE_WOOL),
    magenta_wool(Blocks.MAGENTA_WOOL),
    pink_wool(Blocks.PINK_WOOL),
    brown_wool(Blocks.BROWN_WOOL),
    black_wool(Blocks.BLACK_WOOL),
    gray_wool(Blocks.GRAY_WOOL),
    light_gray_wool(Blocks.LIGHT_GRAY_WOOL),
    white_wool(Blocks.WHITE_WOOL),

    red_concrete(Blocks.RED_CONCRETE),
    orange_concrete(Blocks.ORANGE_CONCRETE),
    yellow_concrete(Blocks.YELLOW_CONCRETE),
    lime_concrete(Blocks.LIME_CONCRETE),
    green_concrete(Blocks.GREEN_CONCRETE),
    cyan_concrete(Blocks.CYAN_CONCRETE),
    light_blue_concrete(Blocks.LIGHT_BLUE_CONCRETE),
    blue_concrete(Blocks.BLUE_CONCRETE),
    purple_concrete(Blocks.PURPLE_CONCRETE),
    magenta_concrete(Blocks.MAGENTA_CONCRETE),
    pink_concrete(Blocks.PINK_CONCRETE),
    brown_concrete(Blocks.BROWN_CONCRETE),
    black_concrete(Blocks.BLACK_CONCRETE),
    gray_concrete(Blocks.GRAY_CONCRETE),
    light_gray_concrete(Blocks.LIGHT_GRAY_CONCRETE),
    white_concrete(Blocks.WHITE_CONCRETE),

    terracotta(Blocks.TERRACOTTA),
    red_terracotta(Blocks.RED_TERRACOTTA),
    orange_terracotta(Blocks.ORANGE_TERRACOTTA),
    yellow_terracotta(Blocks.YELLOW_TERRACOTTA),
    lime_terracotta(Blocks.LIME_TERRACOTTA),
    green_terracotta(Blocks.GREEN_TERRACOTTA),
    cyan_terracotta(Blocks.CYAN_TERRACOTTA),
    light_blue_terracotta(Blocks.LIGHT_BLUE_TERRACOTTA),
    blue_terracotta(Blocks.BLUE_TERRACOTTA),
    purple_terracotta(Blocks.PURPLE_TERRACOTTA),
    magenta_terracotta(Blocks.MAGENTA_TERRACOTTA),
    pink_terracotta(Blocks.PINK_TERRACOTTA),
    brown_terracotta(Blocks.BROWN_TERRACOTTA),
    black_terracotta(Blocks.BLACK_TERRACOTTA),
    gray_terracotta(Blocks.GRAY_TERRACOTTA),
    light_gray_terracotta(Blocks.LIGHT_GRAY_TERRACOTTA),
    white_terracotta(Blocks.WHITE_TERRACOTTA);

    public final Block BaseBlock;

    private ExtendedVanillaBlockGenEnum(Block baseBlock){
        this.BaseBlock = baseBlock;
    }

}
