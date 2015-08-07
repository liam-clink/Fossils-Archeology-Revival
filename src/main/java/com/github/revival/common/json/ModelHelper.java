package com.github.revival.common.json;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.client.model.tabula.ModelJson;
import net.ilexiconn.llibrary.common.json.JsonFactory;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ModelHelper
{
    @SideOnly(Side.CLIENT)
    public static JsonTabulaModel parseModelFromJson(InputStream stream)
    {
        JsonTabulaModel tabulaModel = JsonFactory.getGson().fromJson(new InputStreamReader(stream), JsonTabulaModel.class);
        tabulaModel.modelJson = new ModelJson(tabulaModel);
        return tabulaModel;
    }
}
