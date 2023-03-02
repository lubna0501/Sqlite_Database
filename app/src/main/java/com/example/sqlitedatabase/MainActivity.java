package com.example.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,surname,marks,id;
Button insert,show,update,delete;

    SqliteClass sqliteClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();

sqliteClass= new SqliteClass(getApplicationContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametext=name.getText().toString();
                String surnametext=surname.getText().toString();
                String markstext=marks.getText().toString();

                insertvalues(nametext,surnametext,markstext);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametext=name.getText().toString();
                String surnametext=surname.getText().toString();
                String markstext=marks.getText().toString();
                String idtext=id.getText().toString();
                updatevalue(nametext,surnametext,markstext,idtext);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext=id.getText().toString();
                deletecall(idtext);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
//                ModelClass model=new ModelClass();
//                intent.putExtra("profile",model.getName());
//                intent.putExtra("profilesurname",model.getSurname());
//                intent.putExtra("profilemarks",model.getMarks());
//                intent.putExtra("profileid",model.getId());
                startActivity(intent);

               // showdata();
            }
        });
    }

    private void deletecall(String idtext) {
        int res = sqliteClass.delete(idtext);
        if(res >0)
        {
            Toast.makeText(getApplicationContext(), " successfully saved", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), " failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatevalue(String nametext, String surnametext, String markstext, String idtext) {
        boolean res = sqliteClass.updatevalue(nametext,surnametext,markstext,idtext);
        if(res)
        {
            Toast.makeText(getApplicationContext(), " successfully saved", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), " failed", Toast.LENGTH_SHORT).show();
        }
    }

//    private void showdata() {
//        Cursor cursor=sqliteClass.showdata();
//        if (cursor.getCount()==0){
//            showmessage("error","Nothing is persent");
//        }else {
//            StringBuffer stringBuffer =new StringBuffer();
//            while (cursor.moveToNext()){
//                stringBuffer.append("ID:"+cursor.getString(0)+"\n");
//                stringBuffer.append("NAME:"+cursor.getString(1)+"\n");
//                stringBuffer.append("SERNAME:"+cursor.getString(2)+"\n");
//                stringBuffer.append("MARKS:"+cursor.getString(3)+"\n\n");
//            }
//            textView.setText(stringBuffer.toString());
//        }
//    }
//    public void showmessage(String tittle,String body)
//    {
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle(tittle);
//        builder.setMessage(body);
//        builder.setCancelable(true);
//        builder.show();
//    }

    private void insertvalues(String nametext, String surnametext, String markstext) {
        boolean res = sqliteClass.insertvalue(nametext,surnametext,markstext);
        if(res)
        {
            Toast.makeText(getApplicationContext(), " successfully saved", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), " failed", Toast.LENGTH_SHORT).show();
        }

    }

    private void bindview() {
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        marks=findViewById(R.id.marks);
        id=findViewById(R.id.id);
        insert=findViewById(R.id.insert);
        show=findViewById(R.id.show);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
       // textView =findViewById(R.id.textview);
    }
}