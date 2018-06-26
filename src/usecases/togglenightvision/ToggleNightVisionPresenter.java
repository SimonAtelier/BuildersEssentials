package usecases.togglenightvision;

import usecases.togglenightvision.ToggleNightVision.ToggleNightVisionResponse;

public class ToggleNightVisionPresenter implements ToggleNightVisionResponse {

	private ToggleNightVisionView view;
	
	public ToggleNightVisionPresenter(ToggleNightVisionView view) {
		this.view = view;
	}

	@Override
	public void onNoPermission() {
		view.displayNoPermission();
	}

	@Override
	public void onNightVisionEnabled() {
		view.displayNightVisionEnabled();
	}

	@Override
	public void onNightVisionDisabled() {
		view.displayNightVisionDisabled();
	}

}
