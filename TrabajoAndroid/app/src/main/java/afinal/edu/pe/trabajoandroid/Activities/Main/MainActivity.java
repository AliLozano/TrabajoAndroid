package afinal.edu.pe.trabajoandroid.Activities.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

import afinal.edu.pe.trabajoandroid.Activities.Clients.ClientsActivity;
import afinal.edu.pe.trabajoandroid.Activities.ServiceOrder.ServiceOrdersActivity;
import afinal.edu.pe.trabajoandroid.Activities.Services.ServicesActivity;
import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.Util.FinalSharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FinalSharedPreferences prefs;
    Button _btnlogout;
    Button _btnclients;
    Button _btnos;
    Button _btnservices;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=new FinalSharedPreferences(this);

        _btnclients=findViewById(R.id.btnclients);
        _btnos=findViewById(R.id.btnos);
        _btnservices=findViewById(R.id.btnservices);
        _btnlogout=findViewById(R.id.btnLogout);

        _btnlogout.setOnClickListener(this);
        _btnclients.setOnClickListener(this);
        _btnos.setOnClickListener(this);
        _btnservices.setOnClickListener(this);

        auth = auth.getInstance();
        user=auth.getCurrentUser();

    }

    @Override
    public void onBackPressed() {
        //no hace nada cuando presiona el boton de atras
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (user==null) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnLogout:
                auth.getInstance().signOut();
                abrirlogin();
                break;
            case R.id.btnclients:
                intent=new Intent(this,ClientsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnservices:
                intent=new Intent(this,ServicesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnos:
                intent=new Intent(this,ServiceOrdersActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void abrirlogin(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
