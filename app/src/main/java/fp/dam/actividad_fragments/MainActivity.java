package fp.dam.actividad_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
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
        /*
        //Añadir un fragmento
        FragmentManager fm= getSupportFragmentManager();
        //iniciar transaccion
        FragmentTransaction ft = fm.beginTransaction(); //Operaciones atómicas, se indica primero que quiero realizar y luego un commit
        ft.add(R.id.fragment, f1);
        //puede haber más operaciones desde el beginTransaccion hasta el commit
        ft.commit();
        //Ya estaria el fragmento añadido
        */

        //DE FOMA SIMPLIFICCADA
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, f1)
                .commit();
    }

    public void onButtonClick(View v){
            Fragment f= v.getId()== R.id.buttonFragmentoUno ? f1 : f2 ;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, f)
                        .commit();
    }
}