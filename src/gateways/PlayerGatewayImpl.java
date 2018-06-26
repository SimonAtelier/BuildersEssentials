package gateways;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerGatewayImpl implements PlayerGateway {

	@Override
	public boolean isPlayerFlying(UUID uniquePlayerId) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		return player.isFlying();
	}

	@Override
	public boolean isNightVisionEnabled(UUID uniquePlayerId) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		return player.hasPotionEffect(PotionEffectType.NIGHT_VISION);
	}

	@Override
	public void enableNightVisionOfPlayer(UUID uniquePlayerId) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
	}

	@Override
	public void disableNightVisionOfPlayer(UUID uniquePlayerId) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.removePotionEffect(PotionEffectType.NIGHT_VISION);
	}

	@Override
	public void setFlySpeed(UUID uniquePlayerId, float flySpeed) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.setFlySpeed(flySpeed);
	}

	@Override
	public void setWalkSpeed(UUID uniquePlayerId, float walkSpeed) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.setWalkSpeed(walkSpeed);
	}

}
