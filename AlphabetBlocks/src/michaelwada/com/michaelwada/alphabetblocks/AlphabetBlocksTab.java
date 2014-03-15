package com.michaelwada.alphabetblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AlphabetBlocksTab extends CreativeTabs {
	
	public AlphabetBlocksTab(int par1, String par2Str) {
		super(par1, par2Str);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.bed;
	}

    public String getTranslatedTabLabel()
    {
            return "Alphabet Blocks";
    }
    
}
