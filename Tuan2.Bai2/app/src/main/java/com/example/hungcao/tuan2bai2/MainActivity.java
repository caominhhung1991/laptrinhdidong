package com.example.hungcao.tuan2bai2;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    int LONG = Toast.LENGTH_LONG;
    int SHORT = Toast.LENGTH_SHORT;
    CheckBox luuThongTin;
    String tag = "TAG";

    Toast createToast(String text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        return toast;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        Toast welcomeToast = createToast("Chào mừng đến android tutorial!", LONG);
        welcomeToast.show();

        luuThongTin = findViewById(R.id.luuThongTin);
    }

    AlertDialog createDialogSignUp(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đăng nhập");
        builder.setMessage(message);
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Dialog", "--- positive ---");
            }
        });
//
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Log.d("Dialog", "--- negative ---");
//            }
//        });
        return builder.create();
    }

    public void thoat(View v) {
        AlertDialog dialog = createDialogExit();
        dialog.show();
    }

    AlertDialog createDialogExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bạn có muốn thoát khỏi chương trình?");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Dialog", "--- negative ---");
            }
        });

        return builder.create();
    }

    public void signUp(View v) {
        String message = luuThongTin.isChecked()
                ? "Chào mừng bạn đã đăng hệ thống, thông tin của bạn đã được lưu"
                : "Chào mừng bạn đã đăng hệ thống, thông tin của bạn không được lưu";

        AlertDialog dialog = createDialogSignUp(message);
        dialog.show();
    }




}
