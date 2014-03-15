package com.michaelwada.render.tileentity;

import org.lwjgl.opengl.GL11;

import com.michaelwada.alphabetblocks.AlphabetBlocks;
import com.michaelwada.alphabetblocks.Textures;
import com.michaelwada.alphabetblocks.TileEntityBlockAlphabetFlat;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderAlphabetBlock2 extends TileEntitySpecialRenderer{

	private int textureWidth = 32;
	private int textrueHeight = 32;
	private String letterTexture;
	private String blockTexture;

	public TileEntityRenderAlphabetBlock2() {
//		for (int i=0; i<25; i++){
//			texture = Textures.path+Textures.color+Textures.arrayTextures[i]+Textures.ext;
//		}
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int rotation = tileentity.getBlockMetadata();
		
		TileEntityBlockAlphabetFlat tE = (TileEntityBlockAlphabetFlat) tileentity;
		int charactertE = tE.character;
		int blockColorTE = tE.blockColor;
		
		letterTexture = Textures.path+Textures.textcolor+Textures.arrayLetters[charactertE]+Textures.ext;
		blockTexture = Textures.path+Textures.blockPrefix+Textures.arrayBlockColors[blockColorTE]+Textures.ext;

		//System.out.println(blockTexture);
		GL11.glPushMatrix();
			
			switch(rotation){
			case 0:
				GL11.glTranslatef((float)x+1, (float)y, (float)z+1);
				GL11.glRotatef(180, 0, 1, 0);
				break;
			case 1:
				GL11.glTranslatef((float)x, (float)y, (float)z+1);
				GL11.glRotatef(90, 0, 1, 0);
				break;
			case 2:
				GL11.glTranslatef((float)x, (float)y, (float)z);
				break;
			case 3:
				GL11.glTranslatef((float)x+1, (float)y, (float)z);
				GL11.glRotatef(270, 0, 1, 0);
				break;
			
			}

			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(new ResourceLocation(AlphabetBlocks.MODID, letterTexture));
			tessellator.startDrawingQuads(); // Starts Tessellator
			{
				tessellator.addVertexWithUV(0, 1, .98, 1, 0);
				tessellator.addVertexWithUV(1, 1, .98, 0, 0);
				tessellator.addVertexWithUV(1, 0, .98, 0, 1);
				tessellator.addVertexWithUV(0, 0, .98, 1, 1);
			}
			tessellator.draw(); // Ends Tessellator		
			
//			Tessellator tessellator2 = Tessellator.instance;
			this.bindTexture(new ResourceLocation(AlphabetBlocks.MODID, blockTexture));
			tessellator.startDrawingQuads(); // Starts Tessellator
			{
				tessellator.addVertexWithUV(0, 1, .99, 1, 0);
				tessellator.addVertexWithUV(1, 1, .99, 0, 0);
				tessellator.addVertexWithUV(1, 0, .99, 0, 1);
				tessellator.addVertexWithUV(0, 0, .99, 1, 1);
			}
			tessellator.draw(); // Ends Tessellator		
			
		GL11.glPopMatrix();
	}

}
