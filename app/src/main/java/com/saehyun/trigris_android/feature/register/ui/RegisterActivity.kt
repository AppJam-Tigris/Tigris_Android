package com.saehyun.trigris_android.feature.register.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityRegisterBinding
import com.saehyun.trigris_android.feature.register.model.Location
import com.saehyun.trigris_android.feature.register.model.RegisterRequest
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

    var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movePage(++page)
    }

    override fun observeEvent() {}

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
        }
    }

    private fun firstPage() {
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "Birthday(생년월일)"

        binding.spinnerGender.visibility = View.VISIBLE
        binding.tvSpinner.visibility = View.VISIBLE
        binding.vSpinner.visibility = View.VISIBLE
        binding.btnGender.visibility = View.VISIBLE

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "Nationality(국적)"
        binding.btnLocal.visibility = View.VISIBLE

        binding.stvRegister.setOnClickListener {
            birth_day = binding.etRegisterFirst.text.toString()
            nationality = binding.etRegisterThird.text.toString()

            if(!(birth_day.isNullOrEmpty() || nationality.isNullOrEmpty() || gender.isNullOrEmpty())) {
                movePage(++page)
            } else {
                showToast("모두 입력해주세요!")
            }
        }

        binding.btnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvSpinner.setText(parent!!.getItemAtPosition(position).toString())

                when(parent.getItemAtPosition(position)) {
                    "내국인" -> gender = "LOCAL"
                    "외국인" -> gender = "FOREIGN"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

    }

    private fun secondPage() { // 주소
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "우편번호(Postal code)"
        binding.btnRegisterFirst.visibility = View.VISIBLE

        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "주소지(Address)"

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "상세주소 (Detailed address)"

        binding.stvRegister.setOnClickListener {
            movePage(++page)
        }

    }

    private fun thirdPage() {
        binding.etRegisterFirst.visibility = View.VISIBLE
        binding.etRegisterFirst.hint = "Name(이름)"

        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "ID(아이디)"
        binding.btnRegisterSecond.visibility = View.VISIBLE
        binding.btnRegisterSecond.text = "중복 확인"

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "PASSWORD(비밀번호)"
        binding.ivSeeFirst.visibility = View.VISIBLE

        binding.etRegisterFourth.visibility = View.VISIBLE
        binding.etRegisterFourth.hint = "PASSWORD CHECK(비밀번호 확인)"
        binding.ivSeeFirst.visibility = View.VISIBLE

        binding.stvRegister.setOnClickListener {
            name = binding.etRegisterFirst.text.toString()
            uid = binding.etRegisterSecond.text.toString()
            password = binding.etRegisterFourth.text.toString()

            movePage(++page)
        }
    }

    private fun fourthPage() {
        binding.etRegisterSecond.visibility = View.VISIBLE
        binding.etRegisterSecond.hint = "Phone Number(핸드폰 번호)"
        binding.btnRegisterSecond.visibility = View.VISIBLE
        binding.btnRegisterSecond.text = "인증 하기"

        binding.etRegisterThird.visibility = View.VISIBLE
        binding.etRegisterThird.hint = "인증 번호"
        binding.btnRegisterThird.visibility = View.VISIBLE
        binding.btnRegisterThird.text = "인증 확인"

        binding.stvRegister.setOnClickListener {
            showToast("success")
        }
    }

    private fun register() {
//        vm.register(RegisterRequest)
    }
}