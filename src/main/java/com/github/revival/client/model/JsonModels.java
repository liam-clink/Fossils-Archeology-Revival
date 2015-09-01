package com.github.revival.client.model;

import com.github.revival.Revival;
import com.github.revival.common.json.JsonTabulaModel;
import com.github.revival.common.json.ModelHelper;

public class JsonModels {
    public static JsonTabulaModel velociraptor = ModelHelper.parseModelFromJson(Revival.class.getResourceAsStream("/assets/fossil/models/Velociraptor.json"));

}
