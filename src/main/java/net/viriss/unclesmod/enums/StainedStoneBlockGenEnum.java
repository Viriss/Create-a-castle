package net.viriss.unclesmod.enums;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum StainedStoneBlockGenEnum {

    bloodstone(Items.RED_DYE, "all"),
    warmstone(Items.ORANGE_DYE,"all"),
    sunstone(Items.YELLOW_DYE,"all"),
    lifestone(Items.LIME_DYE,"all"),
    gardenstone(Items.GREEN_DYE,"all"),
    timestone(Items.CYAN_DYE,"all"),
    skystone(Items.LIGHT_BLUE_DYE,"all"),
    waterstone(Items.BLUE_DYE,"all"),
    rosestone(Items.MAGENTA_DYE,"all"),
    royalstone(Items.PURPLE_DYE,"all"),
    pinkstone(Items.PINK_DYE,"all"),
    umberstone(Items.BROWN_DYE,"all"),
    purestone(Items.WHITE_DYE,"all"),
    oldstone(Items.LIGHT_GRAY_DYE,"all"),
    ashstone(Items.GRAY_DYE,"all"),
    inkstone(Items.BLACK_DYE,"all")
/*
    bloodstone_bricks(Items.RED_DYE),
    warmstone_bricks(Items.ORANGE_DYE),
    sunstone_bricks(Items.YELLOW_DYE),
    lifestone_bricks(Items.LIME_DYE),
    gardenstone_bricks(Items.GREEN_DYE),
    timestone_bricks(Items.CYAN_DYE),
    skystone_bricks(Items.LIGHT_BLUE_DYE),
    waterstone_bricks(Items.BLUE_DYE),
    rosestone_bricks(Items.MAGENTA_DYE),
    royalstone_bricks(Items.PURPLE_DYE),
    pinkstone_bricks(Items.PINK_DYE),
    umberstone_bricks(Items.BROWN_DYE),
    purestone_bricks(Items.WHITE_DYE),
    oldstone_bricks(Items.LIGHT_GRAY_DYE),
    ashstone_bricks(Items.GRAY_DYE),
    inkstone_bricks(Items.BLACK_DYE),

    gilded_bloodstone(Items.RED_DYE),
    gilded_warmstone(Items.ORANGE_DYE),
    gilded_sunstone(Items.YELLOW_DYE),
    gilded_lifestone(Items.LIME_DYE),
    gilded_gardenstone(Items.GREEN_DYE),
    gilded_timestone(Items.CYAN_DYE),
    gilded_skystone(Items.LIGHT_BLUE_DYE),
    gilded_waterstone(Items.BLUE_DYE),
    gilded_rosestone(Items.MAGENTA_DYE),
    gilded_royalstone(Items.PURPLE_DYE),
    gilded_pinkstone(Items.PINK_DYE),
    gilded_umberstone(Items.BROWN_DYE),
    gilded_purestone(Items.WHITE_DYE),
    gilded_oldstone(Items.LIGHT_GRAY_DYE),
    gilded_ashstone(Items.GRAY_DYE),
    gilded_inkstone(Items.BLACK_DYE)
*/
            ;

    public final Item Dye;
    public final String BlockTypes;

    private StainedStoneBlockGenEnum(Item dyeItem, String blockTypes){
        this.Dye = dyeItem;
        this.BlockTypes = blockTypes;
    }

    public boolean isChiseled() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("chiseled"));
    }
    public boolean isFence() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("fence"));
    }
    public boolean isGate() {
        return (this.BlockTypes.equals("all") || this.BlockTypes.contains("gate"));
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

}
