package usecases.changespeed;

import java.util.UUID;

import context.Context;
import view.MessageView;

public class ChangeSpeedViewImpl implements ChangeSpeedView {

	private UUID viewer;
	
	public ChangeSpeedViewImpl(UUID viewer) {
		this.viewer = viewer;
	}
	
	private void displayMessage(String message) {
		MessageView messageView = Context.messageView;
		messageView.displayMessage(viewer, message);
	}
	
	@Override
	public void displayNoPermission() {
		displayMessage(ChangeSpeedViewMessages.CHANGE_SPEED_NO_PERMISSION);
	}

	@Override
	public void displayValueNotValid(String value) {
		String message = ChangeSpeedViewMessages.CHANGE_SPEED_VALUE_NOT_VALID;
		message = message.replace("$value$", value);
		displayMessage(message);
	}

	@Override
	public void displayValueOutOfRange(int value, int minValue, int maxValue) {
		String message = ChangeSpeedViewMessages.CHANGE_SPEED_VALUE_OUT_OF_RANGE;
		message = message.replace("$value$", value + "");
		message = message.replace("$min$", minValue + "");
		message = message.replace("$max$", maxValue + "");
		displayMessage(message);
	}
	
	@Override
	public void displayFlySpeedChanged(int value) {
		String message = ChangeSpeedViewMessages.CHANGE_SPEED_FLY_SPEED_CHANGED;
		message = message.replace("$value$", value + "");
		displayMessage(message);
	}

	@Override
	public void displayWalkSpeedChanged(int value) {
		String message = ChangeSpeedViewMessages.CHANGE_SPEED_WALK_SPEED_CHANGED;
		message = message.replace("$value$", value + "");
		displayMessage(message);
	}

	@Override
	public void displayResetFlySpeed() {
		displayMessage(ChangeSpeedViewMessages.CHANGE_SPEED_RESET_FLY_SPEED);
	}

	@Override
	public void displayResetWalkSpeed() {
		displayMessage(ChangeSpeedViewMessages.CHANGE_SPEED_RESET_WALK_SPEED);
	}

}
