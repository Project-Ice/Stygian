package net.condorcraft110.stygian.item;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.util.*;

public class ItemResonanceStar extends Item
{
	public ItemResonanceStar()
	{
		
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if(StygianConfig.showDescriptions)
		{
			list.add(StatCollector.translateToLocal("info.resonanceStar"));
		}
	}
}
