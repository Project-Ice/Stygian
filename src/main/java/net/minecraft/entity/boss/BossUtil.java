package net.minecraft.entity.boss;

import net.minecraft.util.*;

public class BossUtil
{
	public static void attackDragonFrom(EntityDragon dragon, DamageSource source, float damage)
	{
		dragon.func_82195_e(source, damage);
	}
}
