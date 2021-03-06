package com.edinsson.tarea3_4.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import com.edinsson.tarea3_4.modelo.CardViewMain;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructorCardViewMain {

    private Context context;

    public ConstructorCardViewMain(Context context) {
        this.context = context;
    }

    public ArrayList<CardViewMain> obtenerDatos(){
        SharedPreferences version = context.getSharedPreferences("PrimeraVez", context.MODE_PRIVATE);
        BaseDatos db = new BaseDatos(context);
        if(version.getString("version", "") == ""){
            insertarPublishers(db);
            SharedPreferences.Editor editor = version.edit();
            editor.putString("version", "1.0.0");
            editor.commit();
        }
        return db.obtenerPublishers();
    }

    public void darLikePublisher(CardViewMain cardViewMain){
        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_NUMBER_ID_PUBLISHER, cardViewMain.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_NUMBER_NUMBER, 1);
        baseDatos.insertarLikePublisher(contentValues);
    }

    public int obtenerLikePublisher(CardViewMain cardViewMain){
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikePublisher(cardViewMain);
    }

    public void insertFiveFavorite(CardViewMain cardViewMain){
        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_ID, cardViewMain.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, cardViewMain.getPicture());
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, cardViewMain.getName());

        baseDatos.insertarFiveFavorite(cardViewMain, contentValues);
    }

    public ArrayList<CardViewMain> getFiveFavorite(){
        ArrayList<CardViewMain> cardViewMains;
        BaseDatos baseDatos = new BaseDatos(context);
        return selectFiveFavorite(baseDatos.getFiveFavorite());
    }

    public ArrayList<CardViewMain> selectFiveFavorite(ArrayList<CardViewMain> cardViewMains){

        for(int i = 0; i < cardViewMains.size()-5; i++){
            cardViewMains.remove(i);
        }
        return reverseList(cardViewMains);
    }

    public ArrayList<CardViewMain> reverseList(ArrayList<CardViewMain> cardViewMains){
        ArrayList<CardViewMain> cardViewMains1 = new ArrayList<>();

        for(int i = cardViewMains.size(); i > 0; i--){
            cardViewMains1.add(cardViewMains.get(i-1));
        }

        return cardViewMains1;
    }

    public void insertarPublishers(BaseDatos bd){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/22c25b0c-a2e2-4140-a38b-010b64" +
                "97b70f/ddqdgld-50c92e92-3d9a-4284-b30c-7efb7354e8dc.png/v1/fill/w_1024,h_640,q_80,strp/metro_ranger_by_2078_ddqdgld-fu" +
                "llview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVp" +
                "Z2h0IjoiPD02NDAiLCJwYXRoIjoiXC9mXC8yMmMyNWIwYy1hMmUyLTQxNDAtYTM4Yi0wMTBiNjQ5N2I3MGZcL2RkcWRnbGQtNTBjOTJlOTItM2Q5YS00Mj" +
                "g0LWIzMGMtN2VmYjczNTRlOGRjLnBuZyIsIndpZHRoIjoiPD0xMDI0In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.OyFs" +
                "Q1eCAMxykiJDavJip_Y70FECXzrrk0XefBT15go");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/2e2ca105-22d3-44e7-ad36-b1ef4ac17cf7" +
                "/ddslm39-f9a668d4-7553-499f-807a-469f5be1c618.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsI" +
                "mlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMmUyY2ExMDUtMjJkMy00NGU3LWFkMzYtYjFlZjRhYzE3Y2Y3XC9kZHNsbTM5LWY5YTY" +
                "2OGQ0LTc1NTMtNDk5Zi04MDdhLTQ2OWY1YmUxYzYxOC5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.uXJeTAxD7zfcTI" +
                "cHxUZ869tg10aKVt8cqGfEiZi_-Mw");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/839ad802-cfe4-4f36-9be7-6a6d5d6c7302" +
                "/de0znre-d33c3d62-b361-4c63-aec8-b5b390e20a26.jpg/v1/fill/w_1264,h_632,q_70,strp/the_witcher_3_wild_hunt_priscilla_and" +
                "_dandelion_by_agussw_de0znre-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybj" +
                "phcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0xNTAwIiwicGF0aCI6IlwvZlwvODM5YWQ4MDItY2ZlNC00ZjM2LTliZTctNmE2ZDVkNmM3MzAyXC9kZTB6" +
                "bnJlLWQzM2MzZDYyLWIzNjEtNGM2My1hZWM4LWI1YjM5MGUyMGEyNi5qcGciLCJ3aWR0aCI6Ijw9MzAwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbW" +
                "FnZS5vcGVyYXRpb25zIl19.aL1NVpFRuB85b1eBRqQRcmhX2SnKveMA8QbbbmogqWk");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/93aac52b-ed16-4e2d-b102-d27b478ea440" +
                "/de0vnj2-7e7294d4-30ea-4dd5-87d0-ce5da1ab0453.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsIm" +
                "lzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvOTNhYWM1MmItZWQxNi00ZTJkLWIxMDItZDI3YjQ3OGVhNDQwXC9kZTB2bmoyLTdlNzI5N" +
                "GQ0LTMwZWEtNGRkNS04N2QwLWNlNWRhMWFiMDQ1My5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.l_fyNd--SkavSB_5x" +
                "j0nk2IJ8okctP1V2I9SgfXi9sA");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/538984eb-ab47-4c13-bfa8-b4f1aea20e2d/" +
                "de0cgfd-625b3978-8a04-4331-bd5b-f47077aac42b.jpg/v1/crop/w_237,h_350,x_0,y_0,scl_0.1239539748954,q_70,strp/ellie_fanart" +
                "_by_conluoi_de0cgfd-350t.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwi" +
                "b2JqIjpbW3siaGVpZ2h0IjoiPD0xNTE2IiwicGF0aCI6IlwvZlwvNTM4OTg0ZWItYWI0Ny00YzEzLWJmYTgtYjRmMWFlYTIwZTJkXC9kZTBjZ2ZkLTYyNWI" +
                "zOTc4LThhMDQtNDMzMS1iZDViLWY0NzA3N2FhYzQyYi5qcGciLCJ3aWR0aCI6Ijw9MTAyNCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXR" +
                "pb25zIl19.3Cw6XyxaFd5Cy_3-LCK_IzBEz12-HfRTE8w3MZqlM4Q");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/55aa2227-af96-4658-b918-97008446d62d/" +
                "de0nmti-159e0034-8b2b-445e-9d1d-bbd9854b1600.jpg/v1/fill/w_280,h_350,q_70,strp/joel_from_the_last_of_us_part_2_by_alboos" +
                "t_de0nmti-350t.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3" +
                "siaGVpZ2h0IjoiPD0yNDAxIiwicGF0aCI6IlwvZlwvNTVhYTIyMjctYWY5Ni00NjU4LWI5MTgtOTcwMDg0NDZkNjJkXC9kZTBubXRpLTE1OWUwMDM0LThiMm" +
                "ItNDQ1ZS05ZDFkLWJiZDk4NTRiMTYwMC5qcGciLCJ3aWR0aCI6Ijw9MTkyMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.G" +
                "toBC09ebyimR1goPWczqC0_aOXA1m0Bz6KlAhDWAlc");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4a510700-d63e-449c-82b7-525f770c9f14/" +
                "ddxh8kv-c5e1667e-0b77-4b4d-a47a-92de52e2f17b.jpg/v1/fill/w_375,h_250,q_70,strp/follow_the_leader_by_eriyal_ddxh8kv-250t." +
                "jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiP" +
                "D02ODMiLCJwYXRoIjoiXC9mXC80YTUxMDcwMC1kNjNlLTQ0OWMtODJiNy01MjVmNzcwYzlmMTRcL2RkeGg4a3YtYzVlMTY2N2UtMGI3Ny00YjRkLWE0N2EtO" +
                "TJkZTUyZTJmMTdiLmpwZyIsIndpZHRoIjoiPD0xMDI0In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.h1Fjh4TYcPt-Rgwlt7" +
                "mwqeQ4nt7RNugeEQGS4TSb1Og");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/abbe2a1f-5e26-4c10-b33b-68fb1ed57785/dd" +
                "ydst7-6a16685f-f533-4e60-b319-c943d546209d.jpg/v1/fill/w_432,h_250,q_70,strp/ruin_by_giannacroft_ddydst7-250t.jpg?token=e" +
                "yJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD01OTIiLCJwY" +
                "XRoIjoiXC9mXC9hYmJlMmExZi01ZTI2LTRjMTAtYjMzYi02OGZiMWVkNTc3ODVcL2RkeWRzdDctNmExNjY4NWYtZjUzMy00ZTYwLWIzMTktYzk0M2Q1NDYyMD" +
                "lkLmpwZyIsIndpZHRoIjoiPD0xMDI0In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.dlVk73Ts0KX8l4GiP8t7qgAj9JkN13s" +
                "Fesx1DBU8oBI");
        contentValues.put(ConstantesBaseDatos.TABLE_PUBLISHER_NAME, "Yolo");

        bd.insertarPublishers(contentValues);
    }

}
