package net.condorcraft110.stygian.block;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.registry.*;

public class BlockFocusNode extends Block
{
	public final int focusID;
	
	public BlockFocusNode(int focusID)
	{
		super(Material.rock);
		
		this.focusID = focusID;
	}
	
	public Item getItemDropped(int i, Random random, int j)
	{
		return Stygian.itemNode;
	}
	
	public int damageDropped(int i)
	{
		return focusID;
	}
}
