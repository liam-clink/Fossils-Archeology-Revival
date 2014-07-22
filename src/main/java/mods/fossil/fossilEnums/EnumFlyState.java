package mods.fossil.fossilEnums;

public enum EnumFlyState
{
	Grounded,
    Lifting,
    Landing,
    Flying;

    public final EnumFlyState Next()
    {
        return this.values()[(this.ordinal() + 1) % this.values().length];
    }
}
