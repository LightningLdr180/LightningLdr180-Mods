package com.michaelwada.proxy;

import com.michaelwada.alphabetblocks.TileEntityBlockAlphabetFlat;
import com.michaelwada.render.tileentity.TileEntityRenderAlphabetBlock2;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerProxies(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockAlphabetFlat.class, new TileEntityRenderAlphabetBlock2());
		
	}
	
}
