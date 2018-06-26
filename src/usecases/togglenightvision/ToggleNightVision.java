package usecases.togglenightvision;

import java.util.UUID;

import gateways.PermissionGateway;
import gateways.PlayerGateway;

public interface ToggleNightVision {
	
	void execute(UUID uniquePlayerId, ToggleNightVisionResponse response);
	
	void setPermissionGateway(PermissionGateway permissionGateway);
	
	void setPlayerGateway(PlayerGateway playerGateway);
	
	public interface ToggleNightVisionResponse {
		
		void onNoPermission();
		
		void onNightVisionEnabled();
		
		void onNightVisionDisabled();
		
	}
	
}
