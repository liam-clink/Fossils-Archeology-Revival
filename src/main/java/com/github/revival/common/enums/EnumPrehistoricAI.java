package com.github.revival.common.enums;

public class EnumPrehistoricAI {
	public enum Moving{
		WALK, FLIGHT, AQUATIC, SEMIAQUATIC, WALKANDGLIDE;
	}
	public enum Response{
		NONE, SCARED, TERRITORIAL, AGRESSIVE, WATERAGRESSIVE, WATERCALM;
	}
	public enum Following{
		NONE, NORMAL, SKITTISH, AGRESSIVE;
	}
	public enum Taming{
		IMPRINTING, FEEDING, GEM, BLUEGEM, NONE;
	}
	public enum Untaming{
		NONE, ATTACK, STARVE;
	}
	public enum Climbing{
		NONE, ARTHROPOD;
	}
	public enum Jumping{
		BASIC, TWOBLOCKS;
	}
	public enum Stalking{
		NONE, STEALTH;
	}
	public enum Activity{
		DURINAL, NOCTURNAL, BOTH, NOSLEEP;
	}
	public enum Attacking{
		BASIC, KNOCKUP, GRAB, TAILSWING, CHARGE, DROWN, DROP, STOMP, JUMP;
	}
	public enum WaterAbility{
		NONE, FLEE, ATTACK, IGNOREANDFISH;
	}
}
