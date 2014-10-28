package net.condorcraft110.stygian.potion;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.condorcraft110.stygian.core.*;

public class PotionTimeSickness extends Potion
{
	public PotionTimeSickness(int id)
	{
		super(id, true, 0);
	}
	
	public void performEffect(EntityLivingBase entity, int amplifier)
	{
		entity.attackEntityFrom(Stygian.damageSourceTime, (float)(amplifier >> 1));
	}
}
