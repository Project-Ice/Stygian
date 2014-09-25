package net.condorcraft110.stygiance;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.material.*;

public class BlockFocusNode extends Block
{
	public BlockFocusNode()
	{
		super(Material.rock);
	}
	
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			ItemStack stack = new ItemStack(item, 1);
			stack.getTagCompound().setInteger("FocusID", i);
			list.add(stack);
		}
	}
}
