package com.grizzlybear;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Andrew on 1/31/2018.
 */

public class GuideSerializer implements JsonDeserializer<List<Guide>>{
    @Override
    public List<Guide> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Gson().fromJson(json.getAsJsonObject().get("data"), new TypeToken<List<Guide>>(){}.getType());
    }
}
