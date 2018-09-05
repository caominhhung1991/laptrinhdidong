package com.example.hungcao.tuan2bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvNhanVien;
    private EditText etEmpName;
    private List<String> listNhanVien;
    private ArrayAdapter<String> adapter;
    private TextView tvTenNhanVien, result;
    private Button btnNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNhanVien = new ArrayList<>();
        listNhanVien.add("Minh Hưng");
        listNhanVien.add("Phương Linh");


        lvNhanVien = findViewById(R.id.lvNhanVien);
        btnNhap = findViewById(R.id.btnNhap);
        result = findViewById(R.id.result);
        etEmpName = findViewById(R.id.etEmpName);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                listNhanVien
        );

        lvNhanVien.setAdapter(adapter);

        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ItemClicked item = adapter.
            }
        });

        Log.i("Info", "Hello");

        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Info", "Hello - " + listNhanVien.get(i));
                result.setText(String.format("position = %d, value = %s", i, listNhanVien.get(i)));
            }
        });
    }

    void addNhanVien(View v) {
        Log.i("Info", "Button Clicked!");
        String empName = etEmpName.getText().toString();
        listNhanVien.add(empName);
        adapter.notifyDataSetChanged();
    }


}
