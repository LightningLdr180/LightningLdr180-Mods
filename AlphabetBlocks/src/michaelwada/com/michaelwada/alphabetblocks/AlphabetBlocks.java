package com.michaelwada.alphabetblocks;

import com.michaelwada.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AlphabetBlocks.MODID, version = AlphabetBlocks.VERSION)
public class AlphabetBlocks
{
    public static final String MODID = "alphabetblocks";
    public static final String VERSION = "0.1";
    
    public static Item itemAlphabet1;
    
    public static Block blockAlphabet1;
    public static Block blockAlphabetFlat;
    
    @SidedProxy(clientSide="com.michaelwada.proxy.ClientProxy", serverSide="net.michaelwada.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs alphabetTab = new CreativeTabs("alphabetblocksTab"){
    	public Item getTabIconItem(){
    		return Items.blaze_powder;
    	}
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	itemAlphabet1 = new ItemAlphabet1().setUnlocalizedName("itemAlphabet1").setCreativeTab(alphabetTab).setTextureName(MODID + ":" + "letter_block_icon");
    	GameRegistry.registerItem(itemAlphabet1, "itemAlphabet1");
    	
    	blockAlphabet1 = new BlockAlphabet1(Material.rock).setBlockName("blockAlphabet1").setCreativeTab(alphabetTab).setBlockTextureName(MODID + ":" + "letter_block_icon");
    	GameRegistry.registerBlock(blockAlphabet1, "blockAlphabet1");

    	blockAlphabetFlat = new BlockAlphabetFlat(Material.rock).setBlockName("blockAlphabetFlat").setBlockTextureName(MODID + ":" + "letter_block_icon");
    	GameRegistry.registerBlock(blockAlphabetFlat, "blockAlphabetFlat");
    
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerTileEntity(TileEntityBlockAlphabetFlat.class, "Alphabet2TE");
    	proxy.registerProxies();
    }

    
}
