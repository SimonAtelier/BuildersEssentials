package usecases.changespeed;

import java.util.List;
import java.util.UUID;

import context.Context;
import entities.command.AbstractCommand;
import usecases.changespeed.ChangeSpeed.ChangeSpeedResponse;

public class ChangeSpeedCommand extends AbstractCommand {
	
	@Override
	public void execute(UUID player, List<String> arguments) {
		ChangeSpeedView view = new ChangeSpeedViewImpl(player);
		ChangeSpeedResponse presenter = new ChangeSpeedPresenter(view);
		ChangeSpeed useCase = new ChangeSpeedUseCase();
		ChangeSpeedRequestModel requestModel = new ChangeSpeedRequestModel();
		requestModel.setUniquePlayerId(player);
		requestModel.setValue(arguments.get(0));
		useCase.setPermissionGateway(Context.permissionGateway);
		useCase.setPlayerGateway(Context.playerGateway);
		useCase.execute(requestModel, presenter);
	}

	@Override
	public String getName() {
		return "speed";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {"value"};
	}
	
}
