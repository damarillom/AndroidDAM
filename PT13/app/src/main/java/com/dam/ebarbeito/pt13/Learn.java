package com.dam.ebarbeito.pt13;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ausias.pt13.R;

import java.util.Arrays;
import java.util.List;


public class Learn extends AppCompatActivity implements View.OnClickListener {

    //TODO
    //In Android you frequently add the implementing class as callback class. This can be useful if you have lots of buttons.
    //For example, to register your activity as callback for the view, you can use the following snippet.

    int skillLevel;
    private    List<Integer> buttons;
    private int intValue;
    List<Integer> buttons2 = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_learn);
        // TODO: 3/11/18
        //plurals   vogella

        List<Integer> buttons= Arrays.asList(R.id.one, R.id.two, R.id.three,
                R.id.four, R.id.five, R.id.six, R.id.seven,
                R.id.eight, R.id.nine, R.id.zero, R.id.delete  );
        for(Integer i: buttons) {
            View b = findViewById(i);
            b.setOnClickListener(this); // calling onClick() method

        }
        try {
            // aquesta linea de sota és per la següent sub-activity, la tercera, MATHS, pq li passem aquest paràmetre
            skillLevel = getIntent().getExtras().getInt("skillLevel");
            //Toast.makeText(this, "skillLevel a onCreate és:"+ skillLevel, Toast.LENGTH_SHORT).show();
            TextView txtV=(TextView) findViewById(R.id.textViewP);
            txtV.setText(String.valueOf(skillLevel));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onCreate: ",e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {

        try {
            //Toast.makeText(this, " inici:"+ String.valueOf(v.getId()), Toast.LENGTH_SHORT).show();
            Integer e;
            e=v.getId();
            Button but = (Button) findViewById(e);
            String a=  but.getText().toString();
            String s=  but.getHint().toString();
            Integer i=Integer.valueOf(s);

            //Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
/*            if (buttons== null) {
                buttons2= Arrays.asList(R.id.one, R.id.two, R.id.three,
                        R.id.four, R.id.five, R.id.six, R.id.seven,
                        R.id.eight, R.id.nine, R.id.zero, R.id.delete  );

            }
            if (buttons2!=null) {
                for (Integer i : buttons2) {
                    intValue = buttons2.get(i).intValue();
                    if (intValue == v.getId())
                        Toast.makeText(this, String.valueOf(i), Toast.LENGTH_SHORT).show();
                    if (i < 10) skillLevel += i;
                    if (i == 11) skillLevel = 0;
                }
            }
  */
            if (i < 10) skillLevel += i;
            if (i == 10) skillLevel = 0;

            Toast.makeText(this, String.valueOf(skillLevel), Toast.LENGTH_SHORT).show();
            TextView txtView=(TextView) findViewById(R.id.textViewP);
            txtView.setText(String.valueOf(skillLevel));
//        skillLevel+=  5;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onClick: ",e.getMessage()+ ", ");
        }
    }


    public void onClickBack(View v){

        try {

            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "finish: ",e.getMessage());

        }
    }

    @Override
    public void finish(){
        try {
            Intent intent=new Intent();

            intent.putExtra("skillLevel",skillLevel);
            setResult(RESULT_OK,intent);
            // TODO: 3/11/18
            // provocar error per veure que result not ok

            super.finish();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "finish: ",e.getMessage());
        }
    }
}
