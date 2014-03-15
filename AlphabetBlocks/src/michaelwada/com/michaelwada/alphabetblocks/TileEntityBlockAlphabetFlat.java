package com.michaelwada.alphabetblocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockAlphabetFlat extends TileEntity {

	// Character on Block
	public int character;
	
	// Color of Block
	public int blockColor;
	
	// Color of Text
	public int textColor;


	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   System.out.println("writeToNBT");
	   par1.setInteger("Character", this.character);
	   par1.setInteger("Block Color", this.blockColor);
	   NBTTagList list = new NBTTagList();
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   System.out.println("readToNBT");
	   this.character = par1.getInteger("Character");
	   this.blockColor = par1.getInteger("Block Color");
	}
	
	
	public void incrementCharacter(){
		System.out.println(this.character);
		if(!worldObj.isRemote){
			if (this.character < 25){
				this.character++;
			}else{
				this.character = 0;
			}
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, AlphabetBlocks.blockAlphabetFlat, 1, 0);
			System.out.println("Remote:" + this.character);
		}	
	}
	
	public void incrementBlockColor(){
		System.out.println(this.blockColor);
		if(!worldObj.isRemote){
			if (this.blockColor < 9){
				this.blockColor++;
			}else{
				this.blockColor = 0;
			}
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, AlphabetBlocks.blockAlphabetFlat, 1, 0);
			System.out.println("Remote:" + this.blockColor);
		}	
	}
	
	@Override
	public boolean receiveClientEvent(int id, int value){
		if (worldObj.isRemote && id == 1){
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			System.out.println(xCoord + " " + yCoord + " " +zCoord);			
			System.out.println("Client Event Received!");
		}
		return true;
	}
	
	@Override
	public void updateEntity(){
		super.updateEntity();
	
	}
	
	@Override
	public Packet getDescriptionPacket() {
	NBTTagCompound tag = new NBTTagCompound();
	this.writeToNBT(tag);
	return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
		
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
	readFromNBT(packet.func_148857_g());
	}
}
