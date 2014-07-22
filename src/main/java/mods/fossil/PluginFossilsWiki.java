package mods.fossil;

//import wikilink.api.Plugin;

public class PluginFossilsWiki implements Plugin
{
    @Override
    public boolean isAvailable()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override   public String getModID()
    {
        // TODO Auto-generated method stub
        return "fossil";
    }

    @Override
    public String getWikiKey()
    {
        // TODO Auto-generated method stub
        return "fa";
    }

    @Override
    public String getWikiName()
    {
        // TODO Auto-generated method stub
        return "Fossils and Archeology Revival Mod Wiki";
    }

    @Override
    public String getWikiDomain()
    {
        // TODO Auto-generated method stub
        return "fossils-archeology.wikia.com";
    }

    @Override
    public String getWikiSoftware()
    {
        // TODO Auto-generated method stub
        return "WIKIA";
    }

    @Override
    public String getCustomWikiSearchFormat()
    {
        // TODO Auto-generated method stub
        return "/index.php?search=";
    }
}