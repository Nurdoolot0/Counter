package com.example.counter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private TextView counterText;
    private int counterValue = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        counterText = view.findViewById(R.id.counter_text);
        Button increaseButton = view.findViewById(R.id.button_increase);
        Button decreaseButton = view.findViewById(R.id.button_decrease);
        Button sendButton = view.findViewById(R.id.button_send);

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue++;
                counterText.setText(String.valueOf(counterValue));
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue--;
                counterText.setText(String.valueOf(counterValue));
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("result", counterValue);

                com.example.counter.ResultFragment resultFragment = new com.example.counter.ResultFragment();
                resultFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, resultFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
