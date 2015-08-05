package com.asc.utils;

import java.security.MessageDigest;

public class MD5Encrypter {

	public static String encrypt(String password) throws Exception {

		String hash = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(password.getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				if (tmp.length() == 1) {
					hash += "0" + tmp;
				} else {
					hash += tmp;
				}
			}
		} catch (Exception e) {
			throw new Exception("Error Encrypting password: " + password, e);
		}
		return hash;
	}
}
