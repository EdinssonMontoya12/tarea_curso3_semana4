package com.edinsson.tarea3_4.restApi.deserializador;

import androidx.cardview.widget.CardView;

import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.edinsson.tarea3_4.restApi.JsonKeys;
import com.edinsson.tarea3_4.restApi.modelo.CardViewReply;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CardViewMainDeserializador implements JsonDeserializer {
    @Override
    public CardViewReply deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        CardViewReply cardViewReply = gson.fromJson(json, CardViewReply.class);
        JsonArray cardViewReplyData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_REPLY_ARRAY);
        cardViewReply.setCardViews(deserializarContactoJson(cardViewReplyData));
        return cardViewReply;
    }

    private ArrayList<CardViewMain> deserializarContactoJson(JsonArray cardView){
        ArrayList<CardViewMain> cardViewMains = new ArrayList<>();
        for(int i = 0; i < cardView.size(); i++) {
            JsonObject jsonObject = cardView.get(i).getAsJsonObject();
            String id = jsonObject.get(JsonKeys.MEDIA_ID).getAsString();
            String picture = jsonObject.get(JsonKeys.MEDIA_URL).getAsString();
            String username = jsonObject.get(JsonKeys.MEDIA_USERNAME).getAsString();

            CardViewMain cardViewMain = new CardViewMain(picture, username);

            cardViewMains.add(cardViewMain);
        }

        return cardViewMains;
    }
}
