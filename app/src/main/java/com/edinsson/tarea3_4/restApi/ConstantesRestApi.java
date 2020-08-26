package com.edinsson.tarea3_4.restApi;

public final class ConstantesRestApi {

    //GENERAL
    public final static String HOST_INSTAGRAM = "https://graph.instagram.com/";
    public final static String ACCESS_TOKEN= "access_token=";
    public final static String FIELDS = "?fields=";
    public final static String KEY_ACCESS_TOKEN= "IGQVJYbU1EUnMwQTFiY3dMY0lGSTN4d2JWVlJfTXF4ekxPUEZA6SDZA5Y25MU1lueVd2LTg1ZATZAHVGtSRXp4aFo3X1ZAvZAUxJRnNKYXJ6TVpXUzlyOEEyTldEWEFUZAXFTNW02ZAllFNUZAn";

    //USER INFO
    public final static String USER_ID = "17841440561779422";
    public final static String ACCOUNT_TYPE = "account_type";
    public final static String ID = "id";
    public final static String MEDIA_COUNT = "media_count";
    public final static String USERNAME = "username";
    public final static String MEDIA_USER = "me/media";

    //MEDIA INFO
    public final static String CAPTION= "caption";
    public final static String MEDIA_ID= "id";
    public final static String MEDIA_TYPE= "media_type";
    public final static String MEDIA_URL= "media_url";
    public final static String MEDIA_PERMALINK= "permalink";
    public final static String MEDIA_THUMBNAIL_URL= "thumbnail_url";
    public final static String MEDIA_TIMESTAMP= "timestamp";
    public final static String MEDIA_USERNAME= "username";

    //QUERY
    public final static String GET_USER_DATA = HOST_INSTAGRAM + USER_ID + FIELDS + ACCOUNT_TYPE + "," + ID + "," + MEDIA_COUNT + "," + USERNAME + "&" + ACCESS_TOKEN + KEY_ACCESS_TOKEN;
    public final static String GET_ALL_MEDIA_INFO = HOST_INSTAGRAM + MEDIA_USER + FIELDS + MEDIA_ID + "," + MEDIA_TYPE + "," + MEDIA_URL + ","
            + MEDIA_USERNAME + "&" + ACCESS_TOKEN + KEY_ACCESS_TOKEN;

}
