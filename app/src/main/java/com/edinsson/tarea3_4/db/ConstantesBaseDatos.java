package com.edinsson.tarea3_4.db;

import com.sun.mail.imap.AppendUID;

public  final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "publishsers";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PUBLISHER          = "publishser";
    public static final String TABLE_PUBLISHER_ID       = "id";
    public static final String TABLE_PUBLISHER_PICTURE  = "picture";
    public static final String TABLE_PUBLISHER_NAME     = "name";

    public static final String TABLE_LIKE_NUMBER                = "contacto_likes";
    public static final String TABLE_LIKE_NUMBER_ID             = "id";
    public static final String TABLE_LIKE_NUMBER_ID_PUBLISHER   = "id_publisher";
    public static final String TABLE_LIKE_NUMBER_NUMBER         = "likes_number";

    public static final String TABLE_FIVE_FAVORITE = "five_favorite";

}
