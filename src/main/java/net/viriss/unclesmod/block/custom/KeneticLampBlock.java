package net.viriss.unclesmod.block.custom;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class KeneticLampBlock extends DirectionalKineticBlock implements IRotate {

    public KeneticLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return null;
    }
}
