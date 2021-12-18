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
        binding.etRegisterFirst.hint = "Birthday(생년월일)"

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
                showToast("정보를 모두 입력해주세요!")
            }
        }

        binding.btnNation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvNation.setText(parent!!.getItemAtPosition(position).toString())

                when(parent.getItemAtPosition(position)) {
                    "남자" -> gender = "MALE"
                    "여자" -> gender = "FEMALE"
                    else -> gender = "MALE"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }


        binding.btnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvSpinner.setText(parent!!.getItemAtPosition(position).toString())

                when(parent.getItemAtPosition(position)) {
                    "내국인" -> nationality = "LOCAL"
                    "외국인" -> nationality = "FOREIGN"
                    else -> nationality = "LOCAL"
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
            detailAddress = binding.etRegisterThird.text.toString()
            if(!(address.isNullOrBlank() || roadName.isNullOrEmpty() || detailAddress.isNullOrEmpty())) {
                location = Location(roadName!!.toInt(), detailAddress!!, address!!)
                movePage(++page)
            } else {
                showToast("정보를 모두 입력해주세요!")
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
            password = binding.etRegisterFourth.text.toString()

            if(uid.isNullOrEmpty()) {
                showToast("아이디 중복 확인을 해주세요.")
                return@setOnClickListener
            }

            password = binding.etRegisterThird.text.toString()
            val passwordCheck = binding.etRegisterFourth.text.toString()

            if(password.isNullOrEmpty() || passwordCheck.isNullOrEmpty()) {
                showToast("비밀번호를 입력해주세요.")
                return@setOnClickListener
            } else {
                if(password != passwordCheck) {
                    showToast("비밀번호가 일치하지 않습니다.")
                    return@setOnClickListener
                }
            }

            if(!(name.isNullOrBlank())) {
                movePage(++page)
            } else {
                showToast("이름을 입력해주세요.")
            }

        }

        binding.btnRegisterSecond.setOnClickListener {
            val tempUid = binding.etRegisterSecond.text.toString()
            vm.idCheck(tempUid)
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

        binding.btnRegisterSecond.setOnClickListener {
            phone_number = binding.etRegisterSecond.text.toString()
            if(!(phone_number.isNullOrEmpty())) {
                vm.phoneCheck(phone_number!!)
            } else {
                showToast("핸드폰 번호를 입력해주세요!")
            }
        }

        binding.btnRegisterThird.setOnClickListener {
            code = binding.btnRegisterThird.text.toString()
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
                    // 주소를 가져와서 보여주는 부분
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
                showToast("사용가능한 아이디입니다!")
            })
            idCheckFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
            })

            phoneCheckSuccess.observe(this@RegisterActivity, {
                showToast("인증번호를 발송했습니다.")
            })
            phoneCheckFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
            })

            registerSuccess.observe(this@RegisterActivity, {
                showToast("회원가입을 완료했습니다.")
                finish()
            })
            registerFailed.observe(this@RegisterActivity, {
                showToast(it.toString())
                finish()
            })
        }
    }
}