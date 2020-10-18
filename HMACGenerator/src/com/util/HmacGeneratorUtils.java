package com.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author kunal.kumbhar
 */
public class HmacGeneratorUtils {

	private static final Logger logger = Logger.getLogger(HmacGeneratorUtils.class.getName());

	/**
	 * Generate a hash key based upon a given parameter.
	 * 
	 * @param message
	 * @param secerateKey
	 * @param algorithm
	 * @return String
	 */
	public static String generateHashKey(String message, String secerateKey, String algorithm) {
		String hashKey = null;
		try {
			logger.info("Inside generateHashKey Method");
			hashKey = getHashForMessageAndAlgorithm(message, algorithm, getInstanceOfSecretKeySpec(message, algorithm));
			logger.info("HashKey Generated Sucessfully:- " + hashKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		return hashKey;
	}

	/**
	 * Method Internally usages Message Authentication Code" (MAC) algorithm to
	 * convert a message into the hash key.
	 * 
	 * @param message
	 * @param algorithm
	 * @param secretKeySpec
	 * @return String
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	private static String getHashForMessageAndAlgorithm(String message, String algorithm, SecretKeySpec secretKeySpec)
			throws NoSuchAlgorithmException, InvalidKeyException {
		logger.info("Inside getHash Method");
		Mac mac = Mac.getInstance(algorithm);
		mac.init(secretKeySpec);
		byte[] bytes = mac.doFinal(message.getBytes(StandardCharsets.US_ASCII));
		StringBuilder stringBuilder = new StringBuilder();
		int counter = 0;
		while (counter < bytes.length) {
			String hex = Integer.toHexString(0xFF & bytes[counter]);
			if (hex.length() == 1) {
				stringBuilder.append('0');
			}
			stringBuilder.append(hex);
			counter++;
		}
		return stringBuilder.toString();
	}

	/**
	 * Encodes given message String into a sequence of bytes using the given charset
	 * and algorithm, storing the result into a new byte array and returns an instance of SecretKeySpec.
	 * @param message
	 * @param algorithm
	 * @return SecretKeySpec
	 */
	private static SecretKeySpec getInstanceOfSecretKeySpec(String message, String algorithm) {
		logger.info("Inside getSecretKeySpec Method to get SecretKeySpec for provide message");
		return new SecretKeySpec((message).getBytes(StandardCharsets.UTF_8), algorithm);
	}

}
