package main;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import context.Context;
import entities.command.ArgumentsWithLabel;
import gateways.CommandGatewayImpl;
import gateways.PermissionGatewayImpl;
import gateways.PlayerGatewayImpl;
import usecases.changespeed.ChangeSpeedCommand;
import usecases.executecommand.ExecuteCommand;
import usecases.executecommand.ExecuteCommand.ExecuteCommandResponse;
import usecases.executecommand.ExecuteCommandController;
import usecases.executecommand.ExecuteCommandPresenter;
import usecases.executecommand.ExecuteCommandUseCase;
import usecases.executecommand.ExecuteCommandView;
import usecases.executecommand.ExecuteCommandViewImpl;
import usecases.executecommand.RootCommandLabel;
import usecases.togglenightvision.ToggleNightVisionCommand;
import view.MessageViewImpl;

public class BuildersEssentials extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		createContext();
		registerCommandExecutors();
	}

	private void createContext() {
		Context.permissionGateway = new PermissionGatewayImpl();
		Context.playerGateway = new PlayerGatewayImpl();
		Context.messageView = new MessageViewImpl();
		Context.commandGateway = new CommandGatewayImpl();
	}
	
	private void registerCommandExecutors() {		
		getCommand(RootCommandLabel.ROOT_COMMAND_LABEL).setExecutor(this);
		Context.commandGateway.registerCommand(new ChangeSpeedCommand());
		Context.commandGateway.registerCommand(new ToggleNightVisionCommand());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return true;
		Player player = (Player) sender;

		ArgumentsWithLabel argumentsWithLabel = new ArgumentsWithLabel();
		handlePlayerCommand(player.getUniqueId(), argumentsWithLabel.create(label, args));

		return true;
	}

	public void handlePlayerCommand(UUID player, String[] arguments) {
		ExecuteCommand useCase = new ExecuteCommandUseCase();
		ExecuteCommandView view = new ExecuteCommandViewImpl(player);
		ExecuteCommandResponse presenter = new ExecuteCommandPresenter(view);
		ExecuteCommandController controller = new ExecuteCommandController(useCase, presenter);
		useCase.setCommandGateway(Context.commandGateway);
		controller.handleRequest(player, arguments);
	}
	
}
