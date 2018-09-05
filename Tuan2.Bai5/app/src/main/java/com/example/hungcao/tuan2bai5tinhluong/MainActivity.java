package com.example.hungcao.tuan2bai5tinhluong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hungcao.tuan2bai5tinhluong.Employee.Employee;
import com.example.hungcao.tuan2bai5tinhluong.Employee.EmployeeFullTime;
import com.example.hungcao.tuan2bai5tinhluong.Employee.EmployeePartTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView empId, empName;
    RadioGroup radioGroupShift;
    RadioButton fullTime, partTime;
    ListView listViewEmployee;
    Button enterEmp;
    List<Employee> listEmp;
    ArrayAdapter empAdapter;
    Toast toastTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listEmp = new ArrayList<>();
        Employee nv = new EmployeeFullTime();
        nv.setId("123");
        nv.setName("345");
        listEmp.add(nv);

        empId = findViewById(R.id.empId);
        empName = findViewById(R.id.empName);
        listViewEmployee = findViewById(R.id.listViewEmployee);
        radioGroupShift = findViewById(R.id.radioGroupShift);

        empAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                listEmp);
        listViewEmployee.setAdapter(empAdapter);

    }

    void addEmployee(View v) {

        Employee emp = new EmployeeFullTime();

        String id = empId.getText().toString();
        String name = empName.getText().toString();

        if(checkEmpty(R.id.empId) && checkEmpty(R.id.empName)) {
            emp = radioGroupShift.getCheckedRadioButtonId() == R.id.fulltime
                    ? new EmployeeFullTime()
                    : new EmployeePartTime();

            Log.i("Test",id + " " + name);

            emp.setId(id);
            emp.setName(name);

            listEmp.add(emp);

            empAdapter.notifyDataSetChanged();
        } else {
            Log.i("Test", "Empty");
        }
    }

    public boolean checkEmpty(int id) {
        EditText input = findViewById(id);
        String inputString = input.getText().toString();
        return !inputString.matches("");
    }
}
