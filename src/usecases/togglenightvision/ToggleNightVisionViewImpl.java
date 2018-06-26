package usecases.togglenightvision;

import java.util.UUID;

import context.Context;
import view.MessageView;

public class ToggleNightVisionViewImpl implements ToggleNightVisionView {

	private UUID viewer;

	public ToggleNightVisionViewImpl(UUID viewer) {
		this.viewer = viewer;
	}
	
	private void displayMessage(String message) {
		MessageView messageView = Context.messageView;
		messageView.displayMessage(viewer, message);
	}

	@Override
	public void displayNoPermission() {
		displayMessage(ToggleNightVisionViewMessages.TOGGLE_NIGHTVISION_NO_PERMISSION);
	}

	@Override
	public void displayNightVisionEnabled() {
		displayMessage(ToggleNightVisionViewMessages.TOGGLE_NIGHTVISION_ENABLED);
	}

	@Override
	public void displayNightVisionDisabled() {
		displayMessage(ToggleNightVisionViewMessages.TOGGLE_NIGHTVISION_DISABLED);
	}
	
}
