package roujo.emily.commands;

import roujo.emily.Context;

public class TimeCommand extends Command {

	protected TimeCommand() {
		super("time", "Gives the current time.", "time", false);
	}
	
	@Override
	public boolean execute(Context context, String arguments) {
		String time = new java.util.Date().toString();
		sendMessageBack(context, "The time is now " + time);
		return true;
	}

}
