package usecases.changespeed;

public interface ChangeSpeedViewMessages {

	static final String CHANGE_SPEED_NO_PERMISSION = "Du hast keine Berechtigung deine Geschwindigkeit zu verändern.";
	
	static final String CHANGE_SPEED_VALUE_NOT_VALID = "Es ist ein Fehler aufgetreten. '$value$' ist keine gültige Zahl.";
	
	static final String CHANGE_SPEED_VALUE_OUT_OF_RANGE = "Der angegebene Wert '$value$' liegt außerhalb des gültigen Bereichs: [$min$,$max$]";
	
	static final String CHANGE_SPEED_FLY_SPEED_CHANGED = "Die Fluggeschwindigkeit wurde auf '$value$' gesetzt.";
	
	static final String CHANGE_SPEED_WALK_SPEED_CHANGED = "Die Gehgeschwindigkeit wurde auf '$value$' gesetzt.";
	
	static final String CHANGE_SPEED_RESET_FLY_SPEED = "Die Fluggeschwindigkeit wurde auf den Standardwert zurückgesetzt.";
	
	static final String CHANGE_SPEED_RESET_WALK_SPEED = "Die Gehgeschwindigkeit wurde auf den Standardwert zurückgesetzt.";
	
}
