package usecases.changespeed;

import java.util.UUID;

import gateways.PermissionGateway;
import gateways.PlayerGateway;
import permissions.Permissions;

public class ChangeSpeedUseCase implements ChangeSpeed {

	private float speed;
	private PermissionGateway permissionGateway;
	private PlayerGateway playerGateway;
	
	@Override
	public void execute(ChangeSpeedRequest request, ChangeSpeedResponse response) {
		UUID uniquePlayerId = request.getUniquePlayerId();
		
		if (!permissionGateway.hasPermission(uniquePlayerId, Permissions.SPEED)) {
			response.onNoPermission();
			return;
		}
		
		int value = 0;
		
		try {
			value = Integer.parseInt(request.getValue());
		} catch (NumberFormatException e) {
			response.onValueNotValid(request.getValue());
			return;
		}
		
		if (value < 0 || value > 10) {
			response.onValueOutOfRange(value, 0, 10);
			return;
		}
		
		speed = value * 0.1f;
		 		
		if (playerGateway.isPlayerFlying(uniquePlayerId)) {
			if (speed == 0) {
				playerGateway.setFlySpeed(uniquePlayerId, 0.1f);
				response.onResetFlySpeed();
			} else {
				playerGateway.setFlySpeed(uniquePlayerId, speed);
				response.onFlySpeedChanged(value);
			}
			return;
		} else {
			if (speed == 0) {
				playerGateway.setWalkSpeed(uniquePlayerId, 0.2f);
				response.onResetWalkSpeed();
			} else {
				playerGateway.setWalkSpeed(uniquePlayerId, speed);
				response.onWalkSpeedChanged(value);
			}
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
