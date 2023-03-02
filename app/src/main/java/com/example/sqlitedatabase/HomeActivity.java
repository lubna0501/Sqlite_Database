package com.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelClass> userlist;
    SqliteClass sqliteClass;
//    StringBuffer name;
//    StringBuffer surname;
//    StringBuffer id;
//    StringBuffer marks;
    String nametxt,surnametxt,markstxt,idtxt;
    TextView nametext,surnametext,markstext,idtext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userlist = new ArrayList<>();

        sqliteClass= new SqliteClass(getApplicationContext());

        recyclerView=findViewById(R.id.recycle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        showdata();
        nametext=findViewById(R.id.nameadapter);
        surnametext=findViewById(R.id.surnameadapter);
        markstext=findViewById(R.id.marksadapter);
        idtext=findViewById(R.id.idadapter);



    }

    private void showdata() {
        Cursor cursor=sqliteClass.showdata();
        if (cursor.getCount()==0){
            showmessage("error","Nothing is persent");
        }else {
            userlist=new ArrayList<>();
           // StringBuffer stringBuffer =new StringBuffer();
            while (cursor.moveToNext()){

                ModelClass model=new ModelClass();
                model.setId(cursor.getString(0));
                model.setName(cursor.getString(1));
                model.setSurname(cursor.getString(2));
                model.setMarks(cursor.getString(3));
                userlist.add(model);
//               id= stringBuffer.append("ID:"+cursor.getString(0)+"\n");
//                name=stringBuffer.append("NAME:"+cursor.getString(1)+"\n");
//               surname= stringBuffer.append("SERNAME:"+cursor.getString(2)+"\n");
//               marks= stringBuffer.append("MARKS:"+cursor.getString(3)+"\n\n");
            }
            SQLAdapter adapter=new SQLAdapter(userlist,getApplicationContext());
            recyclerView.setAdapter(adapter);

        }
    }

    private void showmessage(String tittle, String body) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(tittle);
        builder.setMessage(body);
        builder.setCancelable(true);
        builder.show();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

}