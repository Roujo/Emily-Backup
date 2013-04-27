package roujo.emily.commands;

import roujo.emily.Context;
import roujo.emily.Emily;
import roujo.emily.util.StringValidator;

public class PartCommand extends Command {

	protected PartCommand() {
		super("part", "Parts with the given channel", "part #channel reason", true);
	}

	@Override
	public boolean execute(Context context) {
		if(!isValidSender(context.getSender()))
			return false;
		
		String message = context.getMessage();
		if(message.equals(""))
			sendUsageBack(context);
		
		String[] args = context.getMessage().split(" ");
		if(!StringValidator.isChannel(args[0]))
			logError(context, "I'm sorry, but \"" + args[0] + "\" doesn't look like a channel name.");
		
		Emily emily = context.getEmily();
		sendMessageBack(context, "Alright!");
		emily.sendMessage(args[0], "See you later!");
		emily.partChannel(args[0], "Off and away...");
		return true;
	}

	
}
