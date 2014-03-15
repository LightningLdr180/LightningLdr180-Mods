package com.michaelwada.alphabetblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAlphabetFlat extends BlockContainer{

	protected BlockAlphabetFlat(Material material) {
		super(material);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int rotation = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		switch(rotation){
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.00F, 1.0F, 1.0F, 0.01F);
			break;
		case 1:
			this.setBlockBounds(0.99F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, 0.99F, 1.0F, 1.0F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.01F, 1.0F, 1.0F);
			break;
		case 4:
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 5:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			break;
		}

	}

	@Override
	public int getRenderType(){
		return -1;
	}

	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityBlockAlphabetFlat();
	}

//	private boolean func_top_place(World world, int x, int y, int z)
//	{
//		System.out.println("func_top_place");
//		if (World.doesBlockHaveSolidTopSurface(world, x, y, z))
//		{
//			return true;
//		}
//		else
//		{
//			Block block = world.getBlock(x, y, z);
//			return block.canPlaceTorchOnTop(world, x, y, z);
//		}
//	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		int m = world.getBlockMetadata(x, y, z);
//		System.out.println("canPlaceBlockAT");
		switch(m){
			case 0:
				return world.isBlockNormalCubeDefault(x, y, z - 1, true); 
			case 1:
				return world.isBlockNormalCubeDefault(x + 1, y, z, true);
			case 2: 
				return world.isBlockNormalCubeDefault(x, y, z+1, true);
			case 3:
				return world.isBlockNormalCubeDefault(x - 1, y, z, true);


		}
		return true;
	}


//	@Override
//	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitx, float hity, float hitz, int metadata){
//		return metadata;
//	}

//	/**
//	 * Ticks the block if it's been scheduled
//	 */
//	 @Override
//	public void updateTick(World world, int x, int y, int z, Random random)
//	{
//		 super.updateTick(world, x, y, z, random);
//
//		 if (world.getBlockMetadata(x, y, z) == 0)
//		 {
//			 this.onBlockAdded(world, x, y, z);
//		 }
//	}
//

	@Override
	public void onBlockAdded(World world, int x, int y, int z){
	
	}

	 /**
	  * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	  * their own) Args: x, y, z, neighbor Block
	  */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	 {
		 this.can_block_stay(world, x, y, z, block);
	 }

	 protected boolean can_block_stay(World world, int x, int y, int z, Block block)
	 {
		 int l = world.getBlockMetadata(x, y, z);
//		 System.out.println("---CanBlockStay?");
		 if (!this.func_drop_block(world, x, y, z)){

//			 System.out.println("func_drop_block " + l);
			 boolean cantstay = false;
//			 if (!world.isSideSolid(x - 1, y, z, EAST, true) && l == 0){
//				 System.out.println("EAST " + l);
//				 cantstay = true;
//			 }
//			 if (!world.isSideSolid(x + 1, y, z, WEST, true) && l == 3){
//				 System.out.println("WEST " + l);
//				 cantstay = true;
//			 }
//			 if (!world.isSideSolid(x, y, z - 1, SOUTH, true) && l == 0){
//				 System.out.println("SOUTH " + l);
//				 cantstay = true;
//			 }
//			 if (!world.isSideSolid(x, y, z + 1, NORTH, true) && l == 0){
//				 System.out.println("NORTH " + l);
//				 cantstay = true;
//			 }
//			 if (!this.func_top_place(world, x, y - 1, z) && l == 5){
//				 cantstay = true;
//			 }
			 if (cantstay){
				 //this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
//				 System.out.println("Block Removed by Can Blcok Stay!!!!");
				 world.setBlockToAir(x, y, z);
				 return true;
			 }else{
				 return false;
			 }
		 }else{
//			 System.out.println("YES!!!");
			 return true;
		 }
	 }
	 
	 protected boolean func_drop_block(World world, int x, int y, int z){
		 System.out.println("func_drop_block");
		 if (!this.canPlaceBlockAt(world, x, y, z)){
			 if (world.getBlock(x, y, z) == this){
				 //this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				 world.setBlockToAir(x, y, z);
//				 System.out.println("Block Removed!!!!");
			 }
//			 System.out.println("BLOCK CANNOT STAY");
			 return false;
		 }else{
//			 System.out.println("BLOCK CAN STAY!");
			 return true;
		 }
	 }
	 
		@Override
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float fx, float fy, float fz){
			TileEntity tE = world.getTileEntity(x, y, z);

			if (player.isSneaking()){
				System.out.println("Sneaking!");
				((TileEntityBlockAlphabetFlat)tE).incrementBlockColor();
			}else{
				System.out.println("Not Sneaking!");
				((TileEntityBlockAlphabetFlat)tE).incrementCharacter();
			}
			System.out.println(tE);
			world.markBlockForUpdate(x, y, z);
			return true;
			
		}
}
