package mobil.baz.tourism.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import mobil.baz.tourism.MainActivity;
import mobil.baz.tourism.R;
import mobil.baz.tourism.TurViewmodel;
import mobil.baz.tourism.databinding.ActivityMainBinding;
import mobil.baz.tourism.databinding.FragmentHomeBinding;

public class HomeFragment extends AppCompatActivity{

    private FragmentHomeBinding binding;
    public void mainbtn(View view) {
        Intent intent = new Intent(HomeFragment.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

    }




}