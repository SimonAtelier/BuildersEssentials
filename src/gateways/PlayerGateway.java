package gateways;

import java.util.UUID;

public interface PlayerGateway {
	
	boolean isPlayerFlying(UUID uniquePlayerId);
	
	boolean isNightVisionEnabled(UUID uniquePlayerId);
	
	void enableNightVisionOfPlayer(UUID uniquePlayerId);
	
	void disableNightVisionOfPlayer(UUID uniquePlayerId);
	
	void setFlySpeed(UUID uniquePlayerId, float flySpeed);
	
	void setWalkSpeed(UUID uniquePlayerId, float walkSpeed);
	
}
