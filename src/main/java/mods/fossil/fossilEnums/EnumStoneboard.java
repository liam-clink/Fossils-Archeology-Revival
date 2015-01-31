package mods.fossil.fossilEnums;

public enum EnumStoneboard
{
    Lighting("Lighting", 32, 16, 0, 0),
    Sociel("Sociel", 16, 16, 32, 0),
    Greatwar("Greatwar", 32, 32, 0, 16),
    Killboss("Killboss", 32, 16, 0, 48),
    Portol("Portol", 32, 32, 0, 64),
    Herobine("Herobine", 32, 32, 32, 32),
    FlatCreep("FlatCreep",  16, 16, 48, 0),
    annoyangry("annoyangry", 16, 16, 48, 16),
    Rex1("Rex1", 32, 32, 64, 0),
    Rex2("Rex2", 32, 16, 64, 32),
    Rex3("Rex3", 32, 16, 64, 48),
    Rex4("Rex4", 32, 32, 64, 64),
    Puzzle("Puzzle", 32, 32, 32, 64),
    GunFight("GunFight", 64, 32, 32, 96),
    Pricess("Pricess", 32, 32, 0, 96),
    Mosa("Mosa", 32, 16, 64, 128),
    HolyMosa("HolyMosa", 64, 32, 0, 128),
    AnciTM("AnciTM", 32, 32, 96, 0),
    ModTM("ModTM", 16, 32, 128, 0),
    VigTM("VigTM", 32, 32, 144, 0);

    public static final int maxArtTitleLength = "annoyangry".length();

    public final String title;
    public final int sizeX;
    public final int sizeY;
    public final int offsetX;
    public final int offsetY;
//   public static final EnumStoneboard[] allArt = new EnumStoneboard[]{Lighting, Sociel, Greatwar, Killboss, Portol, Herobine, FlatCreep, annoyangry, Rex1, Rex2, Rex3, Rex4, Puzzle, GunFight, Pricess, Mosa, HolyMosa, AnciTM, ModTM, VigTM};

    private EnumStoneboard(String par3Str, int par4, int par5, int par6, int par7)
    {
        this.title = par3Str;
        this.sizeX = par4;
        this.sizeY = par5;
        this.offsetX = par6;
        this.offsetY = par7;
    }
}