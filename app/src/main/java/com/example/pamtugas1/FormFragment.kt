package com.example.pamtugas1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.pamtugas1.R

class FormFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var radioGroupStatus: RadioGroup
    private lateinit var checkBoxTos: CheckBox
    private lateinit var checkBoxNewsletter: CheckBox
    private lateinit var checkBoxAgree: CheckBox
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPhone = view.findViewById(R.id.editTextPhone)
        spinnerGender = view.findViewById(R.id.spinnerGender)
        radioGroupStatus = view.findViewById(R.id.radioGroupStatus)
        checkBoxTos = view.findViewById(R.id.checkBoxTos)
        checkBoxNewsletter = view.findViewById(R.id.checkBoxNewsletter)
        checkBoxAgree = view.findViewById(R.id.checkBoxAgree)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            // Panggil metode untuk menangani submit form di sini
            handleSubmitForm()
        }
        val genderOptions = arrayOf("Male", "Female", "Other")
        // Menyiapkan adapter untuk spinner jenis kelamin
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genderOptions)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = genderAdapter

        return view
    }

    private fun handleSubmitForm() {
        // Mendapatkan nilai dari input pengguna
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val phone = editTextPhone.text.toString()
        val gender = spinnerGender.selectedItem.toString()

        val radioButtonId = radioGroupStatus.checkedRadioButtonId
        val radioButton: RadioButton = radioGroupStatus.findViewById(radioButtonId)
        val status = radioButton.text.toString()

        val tosChecked = checkBoxTos.isChecked
        val newsletterChecked = checkBoxNewsletter.isChecked
        val agreeChecked = checkBoxAgree.isChecked

        // Lakukan validasi form di sini jika diperlukan

        // Jika semua valid, lakukan tindakan berikutnya, seperti menyimpan data atau mengirim ke server
        // Misalnya, Anda dapat menggunakan Toast untuk menampilkan pesan bahwa data telah berhasil disimpan
        Toast.makeText(requireContext(), "Data submitted successfully!", Toast.LENGTH_SHORT).show()

        // Start the DisplayDataActivity with the form data as extras
        startDisplayDataActivity(name, email, phone, gender, status, tosChecked, newsletterChecked, agreeChecked)
    }

    private fun startDisplayDataActivity(name: String, email: String, phone: String, gender: String, status: String, tosChecked: Boolean, newsletterChecked: Boolean, agreeChecked: Boolean) {
        // Create an intent to start the DisplayDataActivity
        val intent = Intent(requireContext(), DisplayDataActivity::class.java)

        // Add the form data as extras
        intent.putExtra("name", name)
        intent.putExtra("email", email)
        intent.putExtra("phone", phone)
        intent.putExtra("gender", gender)
        intent.putExtra("status", status)
        intent.putExtra("tos_checked", tosChecked)
        intent.putExtra("newsletter_checked", newsletterChecked)
        intent.putExtra("agree_checked", agreeChecked)

        // Start the DisplayDataActivity
        startActivity(intent)
    }
}