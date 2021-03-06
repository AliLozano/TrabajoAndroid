package afinal.edu.pe.trabajoandroid.activities.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.models.Service;

public class ServiceRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnservicesave;
    TextView txtservicenameadd;
    TextView txtservicepriceadd;
    TextView txtservicedescadd;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_register);

        btnservicesave=findViewById(R.id.btnservicesave);
        txtservicenameadd=findViewById(R.id.txtservicenameadd);
        txtservicepriceadd=findViewById(R.id.txtservicepriceadd);
        txtservicedescadd=findViewById(R.id.txtservicedescadd);
        btnservicesave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnservicesave){
            database = FirebaseDatabase.getInstance();
            DatabaseReference serviceRef = database.getReference("servicios");
            DatabaseReference serviceActualRef = serviceRef.push();

            Service servicio=new Service();
            servicio.setIdservicio(serviceActualRef.getKey());
            servicio.setNombre(txtservicenameadd.getText().toString());
            servicio.setPrecio(Float.valueOf(txtservicepriceadd.getText().toString()));
            servicio.setDescripcion(txtservicedescadd.getText().toString());

            serviceRef.child(serviceActualRef.getKey()).setValue(servicio);
            this.finish();
        }
    }

    public void limpiar(){
        txtservicenameadd.setText("");
        txtservicepriceadd.setText("");
    }



}
