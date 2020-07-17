-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.9-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for dataaggregation
CREATE DATABASE IF NOT EXISTS `dataaggregation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dataaggregation`;


-- Dumping structure for table dataaggregation.chlogin
CREATE TABLE IF NOT EXISTS `chlogin` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table dataaggregation.chlogin: ~1 rows (approximately)
/*!40000 ALTER TABLE `chlogin` DISABLE KEYS */;
INSERT INTO `chlogin` (`username`, `password`) VALUES
	('s', 's');
/*!40000 ALTER TABLE `chlogin` ENABLE KEYS */;


-- Dumping structure for table dataaggregation.clusterfiles
CREATE TABLE IF NOT EXISTS `clusterfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `digest` varchar(200) DEFAULT NULL,
  `clustername` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Dumping data for table dataaggregation.clusterfiles: ~2 rows (approximately)
/*!40000 ALTER TABLE `clusterfiles` DISABLE KEYS */;
INSERT INTO `clusterfiles` (`id`, `filename`, `digest`, `clustername`) VALUES
	(33, 'w1w.txt', '3a7c3d6cff9b3242f6cbc25d8c8123c9', 'Master-PC'),
	(34, 't1.txt', 'aebe0c2f5a958dabe9ff5b36e9b199b5', 'Master-PC');
/*!40000 ALTER TABLE `clusterfiles` ENABLE KEYS */;


-- Dumping structure for table dataaggregation.dedup_notification
CREATE TABLE IF NOT EXISTS `dedup_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `notifyfrom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table dataaggregation.dedup_notification: ~1 rows (approximately)
/*!40000 ALTER TABLE `dedup_notification` DISABLE KEYS */;
INSERT INTO `dedup_notification` (`id`, `filename`, `notifyfrom`) VALUES
	(12, 'md5v2.txt', 'Master-PC');
/*!40000 ALTER TABLE `dedup_notification` ENABLE KEYS */;


-- Dumping structure for table dataaggregation.files
CREATE TABLE IF NOT EXISTS `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nodename` varchar(50) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  `file` text,
  `weightage` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT 'not compromised',
  `hweightage` varchar(50) DEFAULT NULL,
  `digest` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table dataaggregation.files: ~3 rows (approximately)
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` (`id`, `nodename`, `filename`, `file`, `weightage`, `status`, `hweightage`, `digest`) VALUES
	(1, 'node1', 'aa.txt', 'apackage com.secure;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.security.spec.KeySpec;import javax.crypto.Cipher;import javax.crypto.SecretKey;import javax.crypto.SecretKeyFactory;import javax.crypto.spec.IvParameterSpec;import javax.crypto.spec.PBEKeySpec;import javax.crypto.spec.SecretKeySpec;import javax.servlet.ServletException;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;import com.sun.org.apache.regexp.internal.recompile;public class AESFileDecryption extends HttpServlet {	private static final long serialVersionUID = 1L;               public AESFileDecryption() {        super();            }		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			}		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			}	public static String filedecrypt(String salt1,String iv1,String original,HttpServletRequest request)	{		try 		{			HttpSession session=request.getSession();						String filename=(String) session.getAttribute("filename");						String password = "javapapers";						// reading the salt			// user should have secure mechanism to transfer the			// salt, iv and password to the recipient			FileInputStream saltFis = new FileInputStream("E:/encrypt/"+filename+"salt.enc");			byte[] salt = new byte[8];			saltFis.read(salt);			saltFis.close();			// reading the iv			FileInputStream ivFis = new FileInputStream("E:/encrypt/"+filename+"iv.enc");			byte[] iv = new byte[16];			ivFis.read(iv);			ivFis.close();			SecretKeyFactory factory = SecretKeyFactory					.getInstance("PBKDF2WithHmacSHA1");			KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536,					128);			SecretKey tmp = factory.generateSecret(keySpec);			SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");			// file decryption			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");			cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));			FileInputStream fis = new FileInputStream("E:/encrypt/"+filename+".des");			FileOutputStream fos = new FileOutputStream("E:/"+filename+"_decrypted.txt");			byte[] in = new byte[64];			int read;			while ((read = fis.read(in)) != -1) {				byte[] output = cipher.update(in, 0, read);				if (output != null)					fos.write(output);			}			byte[] output = cipher.doFinal();			if (output != null)				fos.write(output);			fis.close();			fos.flush();			fos.close();			System.out.println("File Decrypted.");							} catch (Exception e) {			e.printStackTrace();		}		return original;	}}', '20', 'not compromised', '20', 'fd1g65df1g65d1g'),
	(2, 'node2', 'amey.txt', '12345malicious dns glhkjh67890', '20', 'compromised', '15', 'f54d5f465dd5165d'),
	(3, 'node3', 'md5v2.txt', 'we used DIGEST-MD5 and on goole CRAM-MD5((Challenge Response Authentication Mechanism) ) is present.The DIGEST-MD5 is more secure than the CRAM-MD5 because it prevents chosen plaintext password attacks. During a DIGEST-MD5 authentication exchange between a client and the server, there is additional information passed which is used to construct a more robust hashing algorithm when compared against a CRAM-MD5 authentication making it more difficult to decipher.', '20', 'not compromised', '21', 'b4b558ff999a0c29a0cdac3a73216649');
/*!40000 ALTER TABLE `files` ENABLE KEYS */;


-- Dumping structure for table dataaggregation.node_info
CREATE TABLE IF NOT EXISTS `node_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table dataaggregation.node_info: ~2 rows (approximately)
/*!40000 ALTER TABLE `node_info` DISABLE KEYS */;
INSERT INTO `node_info` (`id`, `node`, `password`) VALUES
	(2, 'node1', 'node1'),
	(3, 'node2', 'node2'),
	(4, 'node3', 'node3');
/*!40000 ALTER TABLE `node_info` ENABLE KEYS */;


