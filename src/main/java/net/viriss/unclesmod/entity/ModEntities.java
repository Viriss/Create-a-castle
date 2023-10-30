package net.viriss.unclesmod.entity;

import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.entity.custom.GathererGolemEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UnclesMod.MOD_ID);


    public static final RegistryObject<EntityType<GathererGolemEntity>> GATHERER_GOLEM =
            ENTITY_TYPES.register("gatherer_golem", () -> EntityType.Builder.of(GathererGolemEntity::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gatherer_golem"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
