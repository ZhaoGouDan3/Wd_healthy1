package com.wd.wd_healthy.view.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.wd_healthy.R;

public class InviteActivity extends AppCompatActivity {

    private EditText invite;
    private Button copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        initView();
        ClipboardManager cm =(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData mClipData=ClipData.newPlainText("Label",invite.getText().toString());
                cm.setPrimaryClip(mClipData);
                Toast.makeText(InviteActivity.this, "邀请码已复制", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        invite = (EditText) findViewById(R.id.invite);
        copy = (Button) findViewById(R.id.copy);
    }
}