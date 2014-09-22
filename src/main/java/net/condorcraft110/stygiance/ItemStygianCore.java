package net.condorcraft110.stygiance;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygiance.focus.*;

public class ItemStygianCore extends Item
{
	private int focusID;
	
	public ItemStygianCore(int focusID)
	{
		setUnlocalizedName("stygianCore");
		setTextureName("stygian:focusCore");
		this.focusID = focusID;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if(stack.getItemDamage() > 0)
		{
			list.add(FocusRegistry.getLocalFocusName(stack.getTagCompound().getInteger("FocusID")));
		}
		else
		{
			list.add("Empty");
		}
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return stack.getItemDamage() != 0;
	}
	
	public ICoreFocus getFocus()
	{
		return FocusRegistry.getFocus(focusID);
	}
	
	public String getLocalFocusName()
	{
		return FocusRegistry.getLocalFocusName(focusID);
	}
}
