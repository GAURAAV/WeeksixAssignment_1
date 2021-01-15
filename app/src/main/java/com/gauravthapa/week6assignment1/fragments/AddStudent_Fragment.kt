package com.nibriti.softuser_week6assignment.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.gauravthapa.week6assignment1.R
import com.gauravthapa.week6assignment1.Storage
import com.gauravthapa.week6assignment1.model.Student


class AddStudent_Fragment : Fragment() {

    private lateinit var btnSave: Button
    private lateinit var etFullname: EditText
    private lateinit var etAge: EditText
    private lateinit var etImageURL: EditText
    private lateinit var etAddress: EditText
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private var userImageURL = ""
    private var gender = "Not Specified"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student_, container, false)
        etFullname = view.findViewById(R.id.etFullname)
        etAge = view.findViewById(R.id.etAge)
        etImageURL = view.findViewById(R.id.etImageURL)
        etAddress = view.findViewById(R.id.etAddress)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)

        rbOthers = view.findViewById(R.id.rbOthers)
        btnSave = view.findViewById(R.id.btnSave)

        rbMale.setOnClickListener {
            gender = "Male"
        }
        rbFemale.setOnClickListener {
            gender = "Female"
        }
        rbOthers.setOnClickListener {
            gender = "Others"
        }

        btnSave.setOnClickListener {
            if(validateInput()) {
                var fullname = etFullname.text.toString()
                userImageURL = etImageURL.text.toString()
                var age = etAge.text.toString()
                var address = etAddress.text.toString()
                Storage().appendStudent(Student(fullname, userImageURL, age, address, gender))
                Toast.makeText(view?.context, "Student Added Sucessfully", Toast.LENGTH_LONG).show()
                etFullname.setText("")
                etImageURL.setText("")
                etAddress.setText("")
                etAge.setText("")
                etFullname.requestFocus()
            }else{
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
    private fun validateInput(): Boolean {
        var res : Boolean = true
        when {
            TextUtils.isEmpty(etFullname.text) -> {
                etFullname.error = "This field should not be empty"
                etFullname.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etImageURL.text) -> {
                etImageURL.error = "This field should not be empty"
                etImageURL.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "This field should not be empty"
                etAddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "This field should not be empty"
                etAge.requestFocus()
                res = false
            }
        }

        return res

    }
}