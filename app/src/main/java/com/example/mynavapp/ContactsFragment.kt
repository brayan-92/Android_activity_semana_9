package com.example.mynavapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        val inputName = view.findViewById<EditText>(R.id.input_name)
        val inputPhone = view.findViewById<EditText>(R.id.input_phone)
        val inputEmail = view.findViewById<EditText>(R.id.input_email)
        val inputAddress = view.findViewById<EditText>(R.id.input_address)
        val btnSave = view.findViewById<Button>(R.id.btn_save_contact)

        btnSave.setOnClickListener {
            val name = inputName.text.toString().trim()
            val phone = inputPhone.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val address = inputAddress.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val message = "Contacto guardado:\n$name\n$phone\n$email\n$address"
                Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()

                inputName.text.clear()
                inputPhone.text.clear()
                inputEmail.text.clear()
                inputAddress.text.clear()
            }
        }

        return view
    }
}
