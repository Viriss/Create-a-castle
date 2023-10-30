package net.viriss.unclesmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.entity.client.GathererGolemModel;
import net.viriss.unclesmod.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = UnclesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GATHERER_GOLEM_LAYER, GathererGolemModel::createBodyLayer);
    }
}
