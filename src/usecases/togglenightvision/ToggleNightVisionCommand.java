package usecases.togglenightvision;

import java.util.List;
import java.util.UUID;

import context.Context;
import entities.command.AbstractCommand;
import usecases.togglenightvision.ToggleNightVision.ToggleNightVisionResponse;

public class ToggleNightVisionCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		ToggleNightVisionView view = new ToggleNightVisionViewImpl(player);
		ToggleNightVisionResponse presenter = new ToggleNightVisionPresenter(view);
		ToggleNightVision useCase = new ToggleNightVisionUseCase();
		useCase.setPermissionGateway(Context.permissionGateway);
		useCase.setPlayerGateway(Context.playerGateway);
		useCase.execute(player, presenter);
	}

	@Override
	public String getName() {
		return "nv";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {};
	}

}
