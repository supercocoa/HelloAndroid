package com.helloandroid.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;

import java.util.Date;

/**
 * Created by scott on 16/1/6.
 */
public class GreenDaoActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private UserDao userDao;

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(imageView);
        ButterKnife.bind(this);


        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();

        adduser();

        String nameColum = UserDao.Properties.Name.columnName;
        String orderBy = nameColum + " COLLATE LOCALIZED ASC";
        cursor = db.query(userDao.getTablename(), userDao.getAllColumns(), null, null, null, null, orderBy);
    }

    private void adduser() {
        User user = new User(null, "tom", 22, new Date());
        userDao.insert(user);
    }


}
