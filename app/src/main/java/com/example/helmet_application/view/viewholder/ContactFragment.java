package com.example.helmet_application.view.viewholder;

import static com.example.helmet_application.utilities.ApiClient.contactInfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helmet_application.R;
import com.example.helmet_application.model.ContactInfo;
import com.example.helmet_application.model.User;
import com.example.helmet_application.utilities.ApiClient;

public class ContactFragment extends Fragment {

    private EditText fullNameEtTxt;
    private EditText emailEtTxt;
    private EditText descEtTxt;
    private Button submitButton;
public ContactFragment(){

}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);


        fullNameEtTxt = view.findViewById(R.id.etName);
        emailEtTxt = view.findViewById(R.id.etMail);
        descEtTxt = view.findViewById(R.id.etDesc);
        submitButton = view.findViewById(R.id.submitBtn);



        submitButton.setOnClickListener(v -> {
            String fullName = fullNameEtTxt.getText().toString();
            String email = emailEtTxt.getText().toString();
            String description = descEtTxt.getText().toString();


            if (fullName.isEmpty() ||  email.isEmpty() || description.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                ContactInfo contact = new ContactInfo(fullName, email, description);
                System.out.println(contact.getUser_FullName());
                contactInfo(contact);
            }
        });
        return view;
    }

    private void contactInfo(ContactInfo contact) {
        ApiClient.contactInfo(contact,getContext());
    }
}
