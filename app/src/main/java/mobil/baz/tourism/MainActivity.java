package mobil.baz.tourism;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import mobil.baz.tourism.View.TurViewmodel;
import mobil.baz.tourism.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText Turname;
    EditText Travel;
    TurViewmodel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceLocator.init(getApplicationContext());

    }

}
