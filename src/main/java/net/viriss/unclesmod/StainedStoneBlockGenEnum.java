package net.viriss.unclesmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum StainedStoneBlockGenEnum {
    pinkstone(Items.PINK_DYE),
    purestone(Items.WHITE_DYE)
    ;

    public final Item Dye;

    private StainedStoneBlockGenEnum(Item dyeItem){
        this.Dye = dyeItem;
    }

}
