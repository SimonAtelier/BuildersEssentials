package usecases.changespeed;

import java.util.UUID;

import usecases.changespeed.ChangeSpeed.ChangeSpeedRequest;

public class ChangeSpeedRequestModel implements ChangeSpeedRequest {
	
	private String value;
	private UUID uniquePlayerId;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public UUID getUniquePlayerId() {
		return uniquePlayerId;
	}
	
	public void setUniquePlayerId(UUID uniquePlayerId) {
		this.uniquePlayerId = uniquePlayerId;
	}
	
}
