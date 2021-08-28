package com.chanaka.usa_assign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nic_input;
    TextView details;
    Button sumbitbttn;
    RelativeLayout popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nic_input =(EditText)findViewById(R.id.nic);
        sumbitbttn=(Button)findViewById(R.id.submitbtn);
        popup=(RelativeLayout)findViewById(R.id.popup);
        details=(TextView)findViewById(R.id.details);
    }

    public void sumbit(View view) {



        String nic=nic_input.getText().toString();
        char[] nicarray =nic.toCharArray();

        if(nic.equals("")){
            nic_input.setError("Enter NIC");
        }
        //!(nic_input.getText().trim().matches("^[0-9]{9}[vVxX]$"))
        else if(nic.matches("^[0-9]{9}[vVxX]$")){

            String year=nic.substring(0,2);
            year="19"+year;
            String days=nic.substring(2,5);

            int[] months={31,29,31,30,31,30,31,31,30,31,30,31};
            int day=Integer.parseInt(days);

            String Gender;
            if(day>500)
            {
                Gender="Female";
                day=day-500;
            }
            else
                Gender="Male";

            int i=0;
            while(day>months[i])
            {
                day=day-months[i];
                i++;
            }

            sumbitbttn.setVisibility(View.INVISIBLE);
            nic_input.setVisibility(View.INVISIBLE);
            popup.setVisibility(View.VISIBLE);

            details.setText("\nYear  \t:"+year+"\nMonth \t:"+(i+1)+"\nDay   \t:"+day+"\nGender\t:"+Gender);
            System.out.println("Year : "+(year)+"\nMonth : "+(i+1)+"\nDay : "+day+"\nGender : "+Gender+"Details of your NIC");
            System.out.println("Year : "+(year)+"\nMonth : "+(i+1)+"\nDay : "+day+"\nGender : "+Gender+"Details of your NIC");

        }
        else if(nic.matches("[0-9]+") && nic.length()==12){

            String year=nic.substring(0,4);
            String days=nic.substring(4,7);

            int[] months={31,29,31,30,31,30,31,31,30,31,30,31};
            int day=Integer.parseInt(days);

            String Gender;
            if(day>500) {
                Gender="Female";
                day=day-500;
            }
            else {
                Gender = "Male";
            }

            int i=0;
            while(day>months[i])
            {
                day=day-months[i];
                i++;
            }

            sumbitbttn.setVisibility(View.INVISIBLE);
            nic_input.setVisibility(View.INVISIBLE);
            popup.setVisibility(View.VISIBLE);
            details.setText("\nYear  \t:"+year+"\nMonth \t:"+(i+1)+"\nDay   \t:"+day+"\nGender\t:"+Gender);
            System.out.println("Year : "+(year)+"\nMonth : "+(i+1)+"\nDay : "+day+"\nGender : "+Gender+"Details of your NIC");

        }

        else{
            nic_input.setError("Invalid nic number");
        }


        nic_input.setText("");

    }

    public void closepopup(View view) {

        sumbitbttn.setVisibility(View.VISIBLE);
        nic_input.setVisibility(View.VISIBLE);
        popup.setVisibility(View.INVISIBLE);
    }
}