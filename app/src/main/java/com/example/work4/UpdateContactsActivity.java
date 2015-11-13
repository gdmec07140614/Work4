package com.example.work4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContactsActivity extends Activity {
    private EditText nameET,moblieET,qqET,danweiET,addressET;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nameET= (EditText) findViewById(R.id.name);
        moblieET= (EditText) findViewById(R.id.mobile);
        qqET= (EditText) findViewById(R.id.qq);
        danweiET= (EditText) findViewById(R.id.danwei);
        addressET= (EditText) findViewById(R.id.address);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        nameET.setText(user.getName());
        moblieET.setText(user.getMobile());
        qqET.setText(user.getQq());
        danweiET.setText(user.getDanwei());
        addressET.setText(user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_contacts, menu);
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case 1:
               if(!nameET.getText().toString().equals("")){
                   user.setName(nameET.getText().toString());
                   user.setName(moblieET.getText().toString());
                   user.setName(qqET.getText().toString());
                   user.setName(danweiET.getText().toString());
                   user.setName(addressET.getText().toString());
                   ContactsTable ct=new ContactsTable(UpdateContactsActivity.this);

                   if(ct.updateUser(user)){
                       Toast.makeText(UpdateContactsActivity.this,"修改成功！",Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(UpdateContactsActivity.this,"修改失败！",Toast.LENGTH_SHORT).show();
                   }
               }else {
                   Toast.makeText(UpdateContactsActivity.this,"数据不能为空！",Toast.LENGTH_SHORT).show();
               }
               break;
           case 2:
               finish();
               default:
                   break;
       }
        return super.onOptionsItemSelected(item);
    }
}
