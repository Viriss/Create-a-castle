package net.viriss.unclesmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.entity.ModEntities;
import net.viriss.unclesmod.entity.client.GathererGolemModel;
import net.viriss.unclesmod.entity.client.ModModelLayers;
import net.viriss.unclesmod.entity.custom.GathererGolemEntity;

@Mod.EventBusSubscriber(modid = UnclesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GATHERER_GOLEM.get(), GathererGolemEntity.createAttributes().build());
    }
}
