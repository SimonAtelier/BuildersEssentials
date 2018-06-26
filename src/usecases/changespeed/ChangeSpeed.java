package usecases.changespeed;

import java.util.UUID;

import gateways.PermissionGateway;
import gateways.PlayerGateway;

public interface ChangeSpeed {

	void execute(ChangeSpeedRequest request, ChangeSpeedResponse response);
	
	void setPermissionGateway(PermissionGateway permissionGateway);
	
	void setPlayerGateway(PlayerGateway playerGateway);
	
	public interface ChangeSpeedRequest {
		
		String getValue();
		
		UUID getUniquePlayerId();
		
	}
	
	public interface ChangeSpeedResponse {
		
		void onNoPermission();
		
		void onValueNotValid(String value);
		
		void onValueOutOfRange(int value, int minValue, int maxValue);
		
		void onFlySpeedChanged(int value);
		
		void onWalkSpeedChanged(int value);
		
		void onResetFlySpeed();
		
		void onResetWalkSpeed();
		
	}
	
}
