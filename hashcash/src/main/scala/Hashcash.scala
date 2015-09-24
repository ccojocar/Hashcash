package org.cosmin

import java.math.BigInteger
import java.security.MessageDigest

trait Hashcash {
  def work(message: String, zeroes: Byte): Int = {
    Stream.from(0).dropWhile(nonce =>
      verify(message, zeroes, nonce) == false
    ).head
  }

  def verify(message: String, zeros: Byte, nonce: Int): Boolean = {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val digest = messageDigest.digest((message + nonce.toString).getBytes("UTF-8"))
    val digestHex = new BigInteger(digest)
    0 until zeros forall (i => digestHex.testBit(i) == false)
  }
}
