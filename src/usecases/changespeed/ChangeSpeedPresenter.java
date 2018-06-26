package usecases.changespeed;

import usecases.changespeed.ChangeSpeed.ChangeSpeedResponse;

public class ChangeSpeedPresenter implements ChangeSpeedResponse {

	private ChangeSpeedView view;
	
	public ChangeSpeedPresenter(ChangeSpeedView view) {
		this.view = view;
	}

	@Override
	public void onNoPermission() {
		view.displayNoPermission();
	}

	@Override
	public void onValueNotValid(String value) {
		view.displayValueNotValid(value);
	}

	@Override
	public void onValueOutOfRange(int value, int minValue, int maxValue) {
		view.displayValueOutOfRange(value, minValue, maxValue);
	}

	@Override
	public void onFlySpeedChanged(int value) {
		view.displayFlySpeedChanged(value);
	}

	@Override
	public void onWalkSpeedChanged(int value) {
		view.displayWalkSpeedChanged(value);
	}

	@Override
	public void onResetFlySpeed() {
		view.displayResetFlySpeed();
	}

	@Override
	public void onResetWalkSpeed() {
		view.displayResetWalkSpeed();
	}

}
