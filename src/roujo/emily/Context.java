package roujo.emily;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import roujo.emily.util.InternalUser;
import roujo.emily.util.UserHelper;

public class Context {
	private final State state;
	private final PircBotX bot;
	private final Channel channel;
	private final User user;
	private final InternalUser internalUser;
	private final String message;

	public Context(State state, MessageEvent<PircBotX> event) {
		this(state, event.getBot(), event.getChannel(), event.getUser(), event.getMessage());
	}

	public Context(State state, PrivateMessageEvent<PircBotX> event) {
		this(state, event.getBot(), null, event.getUser(), event.getMessage());
	}
	
	public Context(State state, PircBotX bot, Channel channel, User user, String message) {
		this.state = state;
		this.bot = bot;
		this.channel = channel;
		this.user = user;
		this.internalUser = UserHelper.getUserByNick(user.getNick());
		this.message = message;
	}
	
	public State getState() {
		return state;
	}
	
	public PircBotX getBot() {
		return bot;
	}

	public Channel getChannel() {
		return channel;
	}

	public User getUser() {
		return user;
	}
	
	public InternalUser getInternalUser() {
		return internalUser;
	}

	public String getMessage() {
		return message;
	}
	
	public boolean isPrivateMessage() {
		return channel == null;
	}
}
