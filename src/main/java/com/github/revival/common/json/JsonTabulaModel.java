package com.github.revival.common.json;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.client.model.tabula.ModelJson;

@SideOnly(Side.CLIENT)
public class JsonTabulaModel extends net.ilexiconn.llibrary.common.json.container.JsonTabulaModel
{
    private String modelName;
    private String authorName;

    public ModelJson modelJson;

    public String getModelName()
    {
        return modelName;
    }

    public String getAuthorName()
    {
        return authorName;
    }
}
