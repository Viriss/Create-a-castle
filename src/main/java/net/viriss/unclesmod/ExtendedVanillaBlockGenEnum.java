package net.viriss.unclesmod;

import net.minecraft.world.level.block.*;

public enum ExtendedVanillaBlockGenEnum {
    red_wool(Blocks.RED_WOOL, "full"),
    orange_wool(Blocks.ORANGE_WOOL, "full"),
    yellow_wool(Blocks.YELLOW_WOOL, "full"),
    lime_wool(Blocks.LIME_WOOL, "full"),
    green_wool(Blocks.GREEN_WOOL, "full"),
    cyan_wool(Blocks.CYAN_WOOL, "full"),
    light_blue_wool(Blocks.LIGHT_BLUE_WOOL, "full"),
    blue_wool(Blocks.BLUE_WOOL, "full"),
    purple_wool(Blocks.PURPLE_WOOL, "full"),
    magenta_wool(Blocks.MAGENTA_WOOL, "full"),
    pink_wool(Blocks.PINK_WOOL, "full"),
    brown_wool(Blocks.BROWN_WOOL, "full"),
    black_wool(Blocks.BLACK_WOOL, "full"),
    gray_wool(Blocks.GRAY_WOOL, "full"),
    light_gray_wool(Blocks.LIGHT_GRAY_WOOL, "full"),
    white_wool(Blocks.WHITE_WOOL, "full"),

    red_concrete(Blocks.RED_CONCRETE, "full"),
    orange_concrete(Blocks.ORANGE_CONCRETE, "full"),
    yellow_concrete(Blocks.YELLOW_CONCRETE, "full"),
    lime_concrete(Blocks.LIME_CONCRETE, "full"),
    green_concrete(Blocks.GREEN_CONCRETE, "full"),
    cyan_concrete(Blocks.CYAN_CONCRETE, "full"),
    light_blue_concrete(Blocks.LIGHT_BLUE_CONCRETE, "full"),
    blue_concrete(Blocks.BLUE_CONCRETE, "full"),
    purple_concrete(Blocks.PURPLE_CONCRETE, "full"),
    magenta_concrete(Blocks.MAGENTA_CONCRETE, "full"),
    pink_concrete(Blocks.PINK_CONCRETE, "full"),
    brown_concrete(Blocks.BROWN_CONCRETE, "full"),
    black_concrete(Blocks.BLACK_CONCRETE, "full"),
    gray_concrete(Blocks.GRAY_CONCRETE, "full"),
    light_gray_concrete(Blocks.LIGHT_GRAY_CONCRETE, "full"),
    white_concrete(Blocks.WHITE_CONCRETE, "full"),

    terracotta(Blocks.TERRACOTTA, "full"),
    red_terracotta(Blocks.RED_TERRACOTTA, "full"),
    orange_terracotta(Blocks.ORANGE_TERRACOTTA, "full"),
    yellow_terracotta(Blocks.YELLOW_TERRACOTTA, "full"),
    lime_terracotta(Blocks.LIME_TERRACOTTA, "full"),
    green_terracotta(Blocks.GREEN_TERRACOTTA, "full"),
    cyan_terracotta(Blocks.CYAN_TERRACOTTA, "full"),
    light_blue_terracotta(Blocks.LIGHT_BLUE_TERRACOTTA, "full"),
    blue_terracotta(Blocks.BLUE_TERRACOTTA, "full"),
    purple_terracotta(Blocks.PURPLE_TERRACOTTA, "full"),
    magenta_terracotta(Blocks.MAGENTA_TERRACOTTA, "full"),
    pink_terracotta(Blocks.PINK_TERRACOTTA, "full"),
    brown_terracotta(Blocks.BROWN_TERRACOTTA, "full"),
    black_terracotta(Blocks.BLACK_TERRACOTTA, "full"),
    gray_terracotta(Blocks.GRAY_TERRACOTTA, "full"),
    light_gray_terracotta(Blocks.LIGHT_GRAY_TERRACOTTA, "full"),
    white_terracotta(Blocks.WHITE_TERRACOTTA, "full"),

    gold_block(Blocks.GOLD_BLOCK, "stairs,slab")
    ;

    public final Block BaseBlock;
    public final String BlockTypes;

    private ExtendedVanillaBlockGenEnum(Block baseBlock, String blockTypes){
        this.BaseBlock = baseBlock;
        this.BlockTypes = blockTypes;
    }

    public boolean isStairs() {
        return (this.BlockTypes.equals("full") || this.BlockTypes.contains("stairs"));
    }
    public boolean isSlab() {
        return (this.BlockTypes.equals("full") || this.BlockTypes.contains("slab"));
    }
    public boolean isWall() {
        return (this.BlockTypes.equals("full") || this.BlockTypes.contains("wall"));
    }
}
