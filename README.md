# HmacGeneratorUtils


Utility internally usage the functionality of a "Message Authentication Code" (MAC) algorithm provided by javax.crypto.Mac java Class.

A general purpose of the  Message Authentication Code(MAC) is to provides a way to check the integrity of information transmitted over or stored in an unreliable medium, based on a secret key.

Typically, message authentication codes are used between two parties that share a similar secret key in order to validate information transmitted between both the parties.

Utility Supports below listed Mac algorithms:
HmacMD5
HmacSHA1
HmacSHA256

//Below is the use case to consume this utility
String secerateKey = "0ea8d84f-fe73-4b2e-aaa3-f3f4063729e1-f4cf1c11-f044-4734-9052-a07811451964-b3dbc8a5-a548-4c46-a164-8c3b31c01b73-60fc36fd-a957-4986-a31e-c0071d34466d";
String message = "secerateKey";
String algorithm = "HmacSHA256";

// Generate hash key based upon the given message, secerateKey, algorithm
String hashKey = HmacGeneratorUtils.generateHashKey(message, secerateKey, algorithm);

//Gives the Resulted hash key
Generated Hash Key:- 7c43782a1b052f825cde27a9bb60d76a3f41c75986474530ac2640d13825a401

Console Output:
Oct 18, 2020 5:25:36 PM com.util.HmacGeneratorUtils generateHashKey
INFO: Inside generateHashKey Method
Oct 18, 2020 5:25:36 PM com.util.HmacGeneratorUtils getInstanceOfSecretKeySpec
INFO: Inside getSecretKeySpec Method to get SecretKeySpec for provide message
Oct 18, 2020 5:25:36 PM com.util.HmacGeneratorUtils getHashForMessageAndAlgorithm
INFO: Inside getHash Method
Oct 18, 2020 5:25:36 PM com.util.HmacGeneratorUtils generateHashKey
INFO: HashKey Generated Sucessfully:- 7c43782a1b052f825cde27a9bb60d76a3f41c75986474530ac2640d13825a401
Oct 18, 2020 5:25:36 PM com.client.HmacGeneratorUtilsClientTest main
INFO: Generated Hash Key:- 7c43782a1b052f825cde27a9bb60d76a3f41c75986474530ac2640d13825a401
