package lk.ijse.railway.dao.custom.impl;

import lk.ijse.railway.dto.OTP;

public class OtpDAOImpl {

    static OTP ootp;

    public static OTP setValues(OTP otp) {
        ootp=otp;

        return ootp;

    }
    public static OTP getValue(){
        return ootp;
    }
}
