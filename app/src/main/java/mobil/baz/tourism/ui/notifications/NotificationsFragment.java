package mobil.baz.tourism.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import mobil.baz.tourism.R;
import mobil.baz.tourism.View.TurViewmodel;
import mobil.baz.tourism.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    EditText Turname;
    EditText Recepttur;
    EditText Name;
    Button button;
    TurViewmodel model;
    private FragmentNotificationsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        return rootView;

    }


    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}