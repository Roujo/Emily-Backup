package roujo.emily.commands;

import roujo.emily.Context;

public class HatsCommand extends Command {

	protected HatsCommand() {
		super("hats", "Who knows?", "hats", false);
	}

	@Override
	public boolean execute(Context context, String arguments) {
		sendMessageBack(context, "no u");
		return true;
	}
	
	
}
