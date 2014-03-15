package com.michaelwada.alphabetblocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAlphabet1 extends Item{

	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player){
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2){
		if(!world.isRemote){
			

			
			//int rotation = ((MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
			System.out.println("onItemUse:" + side);
			if(world.getBlock(x, y, z).isBlockNormalCube()){
				System.out.println("NORMALCUBE");
			
				switch (side){
					case 0: //IN AIR DO NOT PLACE
							//world.setBlock(x, y-1, z, AlphabetBlocks.blockAlphabetFlat, rotation, 2);
							break;
					case 1: //ON GROUND DO NOT PLACE
							//world.setBlock(x, y+1, z, AlphabetBlocks.blockAlphabetFlat, rotation, 2);
							break;
					case 2: world.setBlock(x, y, z-1, AlphabetBlocks.blockAlphabetFlat, 2, 2);
							break;
					case 3: world.setBlock(x, y, z+1, AlphabetBlocks.blockAlphabetFlat, 0, 2);
							break;
					case 4: world.setBlock(x-1, y, z, AlphabetBlocks.blockAlphabetFlat, 1, 2);
							break;
					case 5: world.setBlock(x+1, y, z, AlphabetBlocks.blockAlphabetFlat, 3, 2);
							break;
				}
			}
			return true;
		}
		return false;
	}
	
}
