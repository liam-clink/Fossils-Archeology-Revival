package com.github.revival.server.enums;

public enum EnumStoneboard {
    //Remember: divide the x and y offsets and sizes by 2
    Lighting("Lighting", 32, 16, 0, 0),
    Sociel("Sociel", 16, 16, 32, 0),
    Greatwar("Greatwar", 32, 32, 0, 16),
    clock("clock", 32, 16, 0, 48),
    Portol("Portol", 32, 32, 0, 64),
    Herobine("Herobine", 32, 32, 32, 32),
    FlatCreep("FlatCreep", 16, 16, 48, 0),
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
    VigTM("VigTM", 32, 32, 144, 0),
    SaberHunt("SaberHunt", 32, 16, 96, 32),
    AnuPortal("AnuPortal", 32, 32, 96, 48),
    Anubite1("Anubite1", 16, 16, 128, 32),
    Anubite2("Anubite2", 16, 16, 144, 32),
    Anubite3("Anubite3", 16, 16, 160, 32),
    Anubite4("Anubite4", 16, 16, 176, 32),
    sarcophagus_open("sarcophagus_open", 32, 32, 128, 48),
    sarcophagus_kill("sarcophagus_kill", 32, 32, 96, 80),
    deadAnu("deadAnu", 32, 32, 128, 80);

    public final String title;
    public final int sizeX;
    public final int sizeY;
    public final int offsetX;
    public final int offsetY;
    //   public static final EnumStoneboard[] allArt = new EnumStoneboard[]{Lighting, Sociel, Greatwar, Killboss, Portol, Herobine, FlatCreep, annoyangry, Rex1, Rex2, Rex3, Rex4, Puzzle, GunFight, Pricess, Mosa, HolyMosa, AnciTM, ModTM, VigTM};

    EnumStoneboard(String title, int xSize, int ySize, int textureX, int textureY) {
        this.title = title;
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.offsetX = textureX;
        this.offsetY = textureY;
    }
}