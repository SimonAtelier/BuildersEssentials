package usecases.togglenightvision;

import java.util.UUID;

import gateways.PermissionGateway;
import gateways.PlayerGateway;
import permissions.Permissions;

public class ToggleNightVisionUseCase implements ToggleNightVision {

	private PermissionGateway permissionGateway;
	private PlayerGateway playerGateway;
	
	@Override
	public void execute(UUID uniquePlayerId, ToggleNightVisionResponse response) {
		if (!permissionGateway.hasPermission(uniquePlayerId, Permissions.NIGHTVISION)) {
			response.onNoPermission();
			return;
		}
		
		if (playerGateway.isNightVisionEnabled(uniquePlayerId)) {
			playerGateway.disableNightVisionOfPlayer(uniquePlayerId);
			response.onNightVisionDisabled();
			return;
		} else {
			playerGateway.enableNightVisionOfPlayer(uniquePlayerId);
			response.onNightVisionEnabled();
			return;
		}
	}
	
	@Override
	public void setPermissionGateway(PermissionGateway permissionGateway) {
		this.permissionGateway = permissionGateway;
	}

	@Override
	public void setPlayerGateway(PlayerGateway playerGateway) {
		this.playerGateway = playerGateway;
	}

}
