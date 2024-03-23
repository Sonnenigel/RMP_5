
package com.example.practice5;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.Navigation;

        import com.example.practice5.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(inflater, container, false);

        String data = getArguments().getString("dataFromMainFragment");
        binding.textViewLastDataFromMainFragment.setText("От первого: " + data);

        binding.buttonSendDataToMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromSecondFragment", binding.editTextDataToMainFragment.getText().toString());
                Navigation.findNavController(v).getPreviousBackStackEntry().getSavedStateHandle().set("dataFromSecondFragment", bundle);
                Navigation.findNavController(v).popBackStack(R.id.mainFragment, false);
            }
        });

        String data1 = getArguments().getString("dataFromThirdFragment");
        binding.textViewLastDataFromThirdFragment.setText("От третьего: " + data1);

        binding.buttonSendDataToThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromSecondFragment", binding.editTextDataToThirdFragment.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_second_to_third, bundle);
            }
        });

        return binding.getRoot();
    }
}
