package fp.dam.actividad_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//----TRABAJAR CON FRAGMENTS-----

// Tener diferentes fragments y asignarlos a un determiada activity
//Otra forma tener un sola activity que se muestren varios fragments

// ESTE EJEMPLO ES LA SEGUNDA OPCIÓN -- Una activty con dos fragments
//Es más laborioso pero más eficiente

public class MainActivity extends AppCompatActivity {

    //Instanciar os fragmentos -- una vez se crea la acitvity
    private FragmentoUno f1 = new FragmentoUno();
    private FragmentoDos f2 = new FragmentoDos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FORMA LARGA de HACERLO
        //Añadir un fragmento
        FragmentManager fm = getSupportFragmentManager();
        //iniciar transaccion
        // FragmentTransaction ft = fm.beginTransaction(); //Operaciones atómicas, se indica primero que quiero realizar y luego un commit
        // ft.add(R.id.fragment, f1);
        //puede haber más operaciones desde el beginTransaccion hasta el commit
        // ft.commit();
        //Ya estaria el fragmento añadido

        /*
        //DE FOMA SIMPLIFICCADA
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, f1)
                .commit();
                */

        //LA FORMA MÁS CORRECTA -- NO SE APIÑAN LOS FRAGEMTNTOS AL ROTAR LA PANTALLA
        //Comprobar que el fragmento no está asignado ya
        if (fm.findFragmentById(R.id.fragment == null)) {
            fm.beginTransaction()
                    .add(R.id.fragment, f1)
                    .commit();
            Toast.makeText(getApplicationContext(), "Añadiendo fragment", Toast.LENGTH_SHORT).show();
        } else { //Cuando le doy a rotar la patalla se invoca al método onCreate y los distribuye, saltaría este cartel porque ya está añadido el fragmento
            Toast.makeText(getApplicationContext(), "No fragment AÑADIDO", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonClick(View v) {
       /* Fragment f = v.getId() == R.id.buttonFragmentoUno ? f1 : f2;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, f)
                .addToBackStack(null) // cuando le doy para atrás lo que hace es ir todo para atrás del camino que se ha hecho
                .commit();

        */

        //PASAR DATOS a un fragmentos parametros
        if (v.getId() == R.id.buttonFragmentoDos)
            String s = ((EditText) findViewById(R.id.TextoUno)).getText().toString();
            //Se necesita un objeto de tipo Bundle
            Bundle bundle;


            Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();

            Fragment f = v.getId() == R.id.buttonFragmentoUno ? f1 : f2;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, f)
                .addToBackStack(null) // cuando le doy para atrás lo que hace es ir todo para atrás del camino que se ha hecho
                .commit();
    }
}