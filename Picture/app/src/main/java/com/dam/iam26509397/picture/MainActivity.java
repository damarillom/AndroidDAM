package com.dam.iam26509397.picture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    boolean male = true;
    private static final int REQUEST_IMAGE_PICK = 1;
    private Bitmap bitmap;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profilePicture = findViewById(R.id.userpicture);
        final ImageView imageView = findViewById(R.id.userimage);
        final RadioGroup group1 = (RadioGroup) findViewById(R.id.gender);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        imageView.setImageResource(R.drawable.maleprofile);
                        male = true;
                        break;
                    case R.id.female:
                        imageView.setImageResource(R.drawable.femaleprofile);
                        male = true;
                        break;
                }
            }
        });
    }

    public void onClick(View view) {
        EditText input = (EditText) findViewById(R.id.username);
        String string = input.getText().toString();
        Intent intent = new Intent(this, OverviewActivity.class);
        intent.putExtra("username", string);
        startActivity(intent);
    }

    public void pickImage(View View) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK)
            try (InputStream stream = getContentResolver().openInputStream(data.getData());) {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }

                bitmap = BitmapFactory.decodeStream(stream);

                profilePicture.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}