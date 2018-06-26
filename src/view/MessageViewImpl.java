package view;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MessageViewImpl implements MessageView {

	private static final String PREFIX = "[CreativeCrewEssentials]";
	
	@Override
	public void displayMessage(UUID uniquePlayerId, String message) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.sendMessage(ChatColor.YELLOW + PREFIX + " " + ChatColor.GRAY + message);
	}

}
