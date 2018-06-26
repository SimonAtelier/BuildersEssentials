package usecases.changespeed;

public interface ChangeSpeedView {
	
	void displayNoPermission();
	
	void displayValueNotValid(String value);
	
	void displayValueOutOfRange(int value, int minValue, int maxValue);
	
	void displayFlySpeedChanged(int value);
	
	void displayWalkSpeedChanged(int value);
	
	void displayResetFlySpeed();
	
	void displayResetWalkSpeed();

}
