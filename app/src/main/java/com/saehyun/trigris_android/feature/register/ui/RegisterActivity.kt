package com.saehyun.trigris_android.feature.register.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityRegisterBinding
import com.saehyun.trigris_android.feature.register.model.Location
import com.saehyun.trigris_android.feature.register.model.RegisterRequest
import com.saehyun.trigris_android.feature.register.ui.AddressActivity.Companion.ADDRESS_REQUEST_CODE
import com.saehyun.trigris_android.feature.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding> (
    R.layout.activity_register
) {

    private val vm: RegisterViewModel by viewModel()

    private var name: String ?= null
    private var phone_number: String ?= null
    private var birth_day: String ?= null
    private var gender: String ?= null
    private var nationality: String ?= null
    private var location: Location ?= null
    private var uid: String ?= null
    private var password: String ?= null
    private var code: String ?= null

    // location
    private var address: String ?= null
    private var roadName: String ?= null
    private var detailAddress: String ?= null

    var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movePage(++page)
    }

    private fun movePage(page: Int) {
        viewGone()

        when(page) {
            1 -> {
                firstPage()
            }
            2 -> {
                secondPage()
            }
            3 -> {
                thirdPage()
            }
            4 -> {
                fourthPage()
            }
            else -> {
                firstPage()
            }
        }
    }

    private fun viewGone() {
        binding.run {
            etRegisterFirst.text = null
            etRegisterSecond.text = null
            etRegisterThird.text = null
            etRegisterFourth.text = null

            etRegisterFirst.visibility = View.GONE
            btnRegisterFirst.visibility = View.GONE

            etRegisterSecond.visibility = View.GONE
            btnGender.visibility = View.GONE
            btnRegisterSecond.visibility = View.GONE

            etRegisterThird.visibility = View.GONE
            btnRegisterThird.visibility = View.GONE
            ivSeeFirst.visibility = View.GONE
            btnLocal.visibility = View.GONE

            etRegisterFourth.visibility = View.GONE
            ivSeeSecond.visibility = View.GONE
            btnRegisterFourth.visibility = View.GONE

            spinnerGender.visibility = View.GONE
            spinnerNationality.visibility = View.GONE
            spinnerNationality.visibility = View.GONE
        }
    }

    private fun firstPage() {
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "Birthday(????????????)"

        binding.spinnerGender.visibility = View.VISIBLE
        binding.tvSpinner.visibility = View.VISIBLE
        binding.vSpinner.visibility = View.VISIBLE
        binding.btnGender.visibility = View.VISIBLE

        binding.spinnerNationality.visibility = View.VISIBLE

        binding.stvRegister.setOnClickListener {
            birth_day = binding.etRegisterFirst.text.toString()

            if(!(birth_day.isNullOrEmpty() || nationality.isNullOrEmpty() || gender.isNullOrEmpty())) {
                movePage(++page)
            } else {
                showToast("????????? ?????? ??????????????????!")
            }
        }

        binding.btnNation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvNation.setText(parent!!.getItemAtPosition(position).toString())

                when(parent.getItemAtPosition(position)) {
                    "??????" -> gender = "MALE"
                    "??????" -> gender = "FEMALE"
                    else -> gender = "MALE"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }


        binding.btnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvSpinner.setText(parent!!.getItemAtPosition(position).toString())

                when(parent.getItemAtPosition(position)) {
                    "?????????" -> nationality = "LOCAL"
                    "?????????" -> nationality = "FOREIGN"
                    else -> nationality = "LOCAL"
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }


    }

    private fun secondPage() { // ??????
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "????????????(Postal code)"
        binding.btnRegisterFirst.visibility = View.VISIBLE

        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "?????????(Address)"

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "???????????? (Detailed address)"

        binding.stvRegister.setOnClickListener {
            detailAddress = binding.etRegisterThird.text.toString()
            if(!(address.isNullOrBlank() || roadName.isNullOrEmpty() || detailAddress.isNullOrEmpty())) {
                location = Location(roadName!!.toInt(), detailAddress!!, address!!)
                movePage(++page)
            } else {
                showToast("????????? ?????? ??????????????????!")
            }
        }

        binding.btnRegisterFirst.setOnClickListener {
            Intent(this, AddressActivity::class.java).apply {
                startActivityForResult(this, ADDRESS_REQUEST_CODE)
            }
        }

    }

    private fun thirdPage() {
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "Name(??????)"

        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "ID(?????????)"
        binding.btnRegisterSecond.visibility = View.VISIBLE
        binding.btnRegisterSecond.text = "?????? ??????"


        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "PASSWORD(????????????)"
        binding.ivSeeFirst.visibility = View.VISIBLE

        binding.etRegisterFourth.visibility = View.VISIBLE
        binding.etRegisterFourth.hint = "PASSWORD CHECK(???????????? ??????)"
        binding.ivSeeFirst.visibility = View.VISIBLE

        binding.stvRegister.setOnClickListener {
            name = binding.etRegisterFirst.text.toString()
            password = binding.etRegisterFourth.text.toString()

            if(uid.isNullOrEmpty()) {
                showToast("????????? ?????? ????????? ????????????.")
                return@setOnClickListener
            }

            password = binding.etRegisterThird.text.toString()
            val passwordCheck = binding.etRegisterFourth.text.toString()

            if(password.isNullOrEmpty() || passwordCheck.isNullOrEmpty()) {
                showToast("??????????????? ??????????????????.")
                return@setOnClickListener
            } else {
                if(password != passwordCheck) {
                    showToast("??????????????? ???????????? ????????????.")
                    return@setOnClickListener
                }
            }

            if(!(name.isNullOrBlank())) {
                movePage(++page)
            } else {
                showToast("????????? ??????????????????.")
            }

        }

        binding.btnRegisterSecond.setOnClickListener {
            val tempUid = binding.etRegisterSecond.text.toString()
            vm.idCheck(tempUid)
        }
    }

    private fun fourthPage() {
        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "Phone Number(????????? ??????)"
        binding.btnRegisterSecond.visibility = View.VISIBLE
        binding.btnRegisterSecond.text = "?????? ??????"

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "?????? ??????"
        binding.btnRegisterThird.visibility = View.VISIBLE
        binding.btnRegisterThird.text = "?????? ??????"

        binding.stvRegister.setOnClickListener {
            showToast("success")
        }

        binding.btnRegisterSecond.setOnClickListener {
            phone_number = binding.etRegisterSecond.text.toString()
            if(!(phone_number.isNullOrEmpty())) {
                vm.phoneCheck(phone_number!!)
            } else {
                showToast("????????? ????????? ??????????????????!")
            }
        }

        binding.btnRegisterThird.setOnClickListener {
            code = binding.etRegisterThird.text.toString()
            if(!(phone_number.isNullOrEmpty() || code.isNullOrEmpty())) {
                register()
            }
        }
    }

    private fun register() {
        vm.register(RegisterRequest(name!!, phone_number!!, code!!, birth_day!!, gender!!, nationality!!, location!!, uid!!, password!!))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            ADDRESS_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    // ????????? ???????????? ???????????? ??????
                    val addressData = data?.extras?.getString("address").toString()

                    roadName = addressData.substring(0, 5)
                    address = addressData.substring(7)
                    address = address!!.replace("\"", "")
                    binding.etRegisterFirst.setText(roadName)
                    binding.etRegisterSecond.setText(address)
                }
            }
        }
    }

    override fun observeEvent() {
        vm.run {
            idCheckSuccess.observe(this@RegisterActivity, {
                uid = binding.etRegisterSecond.text.toString()
                showToast("??????????????? ??????????????????!")
            })
            idCheckFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
            })

            phoneCheckSuccess.observe(this@RegisterActivity, {
                showToast("??????????????? ??????????????????.")
            })
            phoneCheckFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
            })

            registerSuccess.observe(this@RegisterActivity, {
                showToast("??????????????? ??????????????????.")
                finish()
            })
            registerFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
                finish()
            })
        }
    }
}