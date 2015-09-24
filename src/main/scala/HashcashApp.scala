import org.cosmin.Hashcash

object HashcashApp extends App with Hashcash {
  val zeroes: Byte = 20
  val message = "Test hash-cash"

  val nonce = work(message, zeroes)
  println(s"Nonce = $nonce for message = '$message' with zeroes = $zeroes")

  val verified = verify(message, zeroes, nonce)
  println(s"Verify hash-cash: $verified")
}