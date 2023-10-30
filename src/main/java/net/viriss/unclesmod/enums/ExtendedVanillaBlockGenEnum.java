package net.viriss.unclesmod.enums;

import net.minecraft.world.level.block.*;

public enum ExtendedVanillaBlockGenEnum {
    red_wool(Blocks.RED_WOOL, "all"),
    orange_wool(Blocks.ORANGE_WOOL, "all"),
    yellow_wool(Blocks.YELLOW_WOOL, "all"),
    lime_wool(Blocks.LIME_WOOL, "all"),
    green_wool(Blocks.GREEN_WOOL, "all"),
    cyan_wool(Blocks.CYAN_WOOL, "all"),
    light_blue_wool(Blocks.LIGHT_BLUE_WOOL, "all"),
    blue_wool(Blocks.BLUE_WOOL, "all"),
    purple_wool(Blocks.PURPLE_WOOL, "all"),
    magenta_wool(Blocks.MAGENTA_WOOL, "all"),
    pink_wool(Blocks.PINK_WOOL, "all"),
    brown_wool(Blocks.BROWN_WOOL, "all"),
    black_wool(Blocks.BLACK_WOOL, "all"),
    gray_wool(Blocks.GRAY_WOOL, "all"),
    light_gray_wool(Blocks.LIGHT_GRAY_WOOL, "all"),
    white_wool(Blocks.WHITE_WOOL, "all"),

    red_concrete(Blocks.RED_CONCRETE, "all"),
    orange_concrete(Blocks.ORANGE_CONCRETE, "all"),
    yellow_concrete(Blocks.YELLOW_CONCRETE, "all"),
    lime_concrete(Blocks.LIME_CONCRETE, "all"),
    green_concrete(Blocks.GREEN_CONCRETE, "all"),
    cyan_concrete(Blocks.CYAN_CONCRETE, "all"),
    light_blue_concrete(Blocks.LIGHT_BLUE_CONCRETE, "all"),
    blue_concrete(Blocks.BLUE_CONCRETE, "all"),
    purple_concrete(Blocks.PURPLE_CONCRETE, "all"),
    magenta_concrete(Blocks.MAGENTA_CONCRETE, "all"),
    pink_concrete(Blocks.PINK_CONCRETE, "all"),
    brown_concrete(Blocks.BROWN_CONCRETE, "all"),
    black_concrete(Blocks.BLACK_CONCRETE, "all"),
    gray_concrete(Blocks.GRAY_CONCRETE, "all"),
    light_gray_concrete(Blocks.LIGHT_GRAY_CONCRETE, "all"),
    white_concrete(Blocks.WHITE_CONCRETE, "all"),

    terracotta(Blocks.TERRACOTTA, "all"),
    red_terracotta(Blocks.RED_TERRACOTTA, "all"),
    orange_terracotta(Blocks.ORANGE_TERRACOTTA, "all"),
    yellow_terracotta(Blocks.YELLOW_TERRACOTTA, "all"),
    lime_terracotta(Blocks.LIME_TERRACOTTA, "all"),
    green_terracotta(Blocks.GREEN_TERRACOTTA, "all"),
    cyan_terracotta(Blocks.CYAN_TERRACOTTA, "all"),
    light_blue_terracotta(Blocks.LIGHT_BLUE_TERRACOTTA, "all"),
    blue_terracotta(Blocks.BLUE_TERRACOTTA, "all"),
    purple_terracotta(Blocks.PURPLE_TERRACOTTA, "all"),
    magenta_terracotta(Blocks.MAGENTA_TERRACOTTA, "all"),
    pink_terracotta(Blocks.PINK_TERRACOTTA, "all"),
    brown_terracotta(Blocks.BROWN_TERRACOTTA, "all"),
    black_terracotta(Blocks.BLACK_TERRACOTTA, "all"),
    gray_terracotta(Blocks.GRAY_TERRACOTTA, "all"),
    light_gray_terracotta(Blocks.LIGHT_GRAY_TERRACOTTA, "all"),
    white_terracotta(Blocks.WHITE_TERRACOTTA, "all"),

    gold_block(Blocks.GOLD_BLOCK, "stairs,slab")
    ;

    public final Block BaseBlock;
    public final String BlockTypes;

    private ExtendedVanillaBlockGenEnum(Block baseBlock, String blockTypes){
        this.BaseBlock = baseBlock;
        this.BlockTypes = blockTypes;
    }

    public boolean isStairs() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("stairs"));
    }
    public boolean isSlab() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("slab"));
    }
    public boolean isWall() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("wall"));
    }
    public boolean isFence() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("fence"));
    }
    public boolean isGate() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("gate"));
    }
}
