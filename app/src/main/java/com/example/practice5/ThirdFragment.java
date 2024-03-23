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
import com.example.practice5.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(getLayoutInflater());
        String data = getArguments().getString("dataFromMainFragment");
        binding.textViewLastDataFromMainFragment.setText("От первого: " + data);
        binding.buttonSendDataToMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromThirdFragment", binding.editTextDataToMainFragment.getText().toString());
                Navigation.findNavController(v).getPreviousBackStackEntry().getSavedStateHandle().set("dataFromThirdFragment", bundle);
                Navigation.findNavController(v).popBackStack(R.id.mainFragment, false);
            }
        });


        String data1 = getArguments().getString("dataFromSecondFragment");
        binding.textViewLastDataFromSecondFragment.setText("От второго: " + data1);
        binding.buttonSendDataToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromThirdFragment", binding.editTextDataToSecondFragment.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_third_to_second, bundle);
            }
        });
        return binding.getRoot();
    }
}
