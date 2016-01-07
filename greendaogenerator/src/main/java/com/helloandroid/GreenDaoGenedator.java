package com.helloandroid;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;


public class GreenDaoGenedator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(123, "com.helloandroid.db.greendao");
        addUser(schema);

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }

    private static void addUser(Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty();
        user.addStringProperty("name").notNull();
        user.addIntProperty("age");
        user.addDateProperty("update_time");
    }
}
