package context;

import gateways.CommandGateway;
import gateways.PermissionGateway;
import gateways.PlayerGateway;
import view.MessageView;

public class Context {

	public static PermissionGateway permissionGateway;
	
	public static PlayerGateway playerGateway;
	
	public static MessageView messageView;
	
	public static CommandGateway commandGateway;
	
}
