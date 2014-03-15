package com.michaelwada.alphabetblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAlphabet1 extends Block{

	protected BlockAlphabet1(Material material) {
		super(material);
		
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}
}
