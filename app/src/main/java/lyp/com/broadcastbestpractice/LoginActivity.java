package lyp.com.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit= findViewById(R.id.account);
        passwordEdit= findViewById(R.id.password);
        login=findViewById(R.id.login);
        rememberPass=findViewById(R.id.remember_pass);

        Boolean isRemember=preUtils.getBoolean(this,"remember_pass",false);
        if(isRemember){
            //将账号和密码都设置到文本框中
            String account=preUtils.getString(this,"account","");
            String password=preUtils.getString(this,"password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password= passwordEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123456"))
                {

                    if(rememberPass.isChecked()){
                        preUtils.setBoolean(LoginActivity.this,"remember_pass",true);
                        preUtils.setString(LoginActivity.this,"account",account);
                        preUtils.setString(LoginActivity.this,"password",password);
                    }else {
                        preUtils.clear(LoginActivity.this);
                    }
                    Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
