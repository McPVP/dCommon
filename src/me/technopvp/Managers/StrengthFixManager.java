package me.technopvp.Managers;

import me.technopvp.clash.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StrengthFixManager extends Main {
	
	@EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
      if ((event.getDamager() instanceof Player))
      {
        Player player = (Player)event.getDamager();
        if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
        {
          for (PotionEffect Effect : player.getActivePotionEffects())
          {
            if (Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE))
            {
              double DamagePercentage = (Effect.getAmplifier() + 1) * 1.3D + 1.0D;
              int NewDamage;
              if (event.getDamage() / DamagePercentage <= 1.0D)
              {
                NewDamage = (Effect.getAmplifier() + 1) * 3 + 1;
              }
              else
              {
                NewDamage = (int)(event.getDamage() / DamagePercentage) + (Effect.getAmplifier() + 1) * 3;
              }
              event.setDamage(NewDamage);
              break;
            }
          }
        }
      }
    }

}
