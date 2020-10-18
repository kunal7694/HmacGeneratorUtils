package com.client;

import java.util.logging.Logger;

import com.util.HmacGeneratorUtils;

/**
 * A client program to test the hashing functionality.
 * 
 * @author kunal.kumbhar
 */
public class HmacGeneratorUtilsClientTest {

	private static final Logger logger = Logger.getLogger(HmacGeneratorUtilsClientTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String secerateKey = "0ea8d84f-fe73-4b2e-aaa3-f3f4063729e1-f4cf1c11-f044-4734-9052-a07811451964-b3dbc8a5-a548-4c46-a164-8c3b31c01b73-60fc36fd-a957-4986-a31e-c0071d34466d";
		String message = "secerateKey";
		String algorithm = "HmacSHA256";

		// Generate hash key based upon given message, secerateKey, algorithm
		String hashKey = HmacGeneratorUtils.generateHashKey(message, secerateKey, algorithm);
		if (hashKey == null) {
			logger.info("Hashkey Found As A Null");
		} else {
			logger.info("Generated Hash Key:- " + hashKey);
		}

	}
}
