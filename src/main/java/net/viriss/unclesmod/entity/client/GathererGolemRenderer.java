package net.viriss.unclesmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.entity.custom.GathererGolemEntity;

public class GathererGolemRenderer extends MobRenderer<GathererGolemEntity, GathererGolemModel<GathererGolemEntity>> {

    public GathererGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GathererGolemModel<>(pContext.bakeLayer(ModModelLayers.GATHERER_GOLEM_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GathererGolemEntity pEntity) {
        return new ResourceLocation(UnclesMod.MOD_ID, "textures/entity/gatherer_golem.png");
    }

    @Override
    public void render(GathererGolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f , 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
