package com.minecraftabnormals.buzzier_bees.core.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

@Mixin(BeehiveBlock.class)
public class BeehiveBlockMixin extends Block{
	
	public BeehiveBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(BeehiveBlock.FACING, rot.rotate(state.get(BeehiveBlock.FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.toRotation(state.get(BeehiveBlock.FACING)));
	}
}
