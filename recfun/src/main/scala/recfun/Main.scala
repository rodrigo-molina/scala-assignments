package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) {
      return 1;
    }
    return pascal(c - 1, r - 1) + pascal(c, r - 1);
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(chars: List[Char], openParentheses: Int): Boolean = {
      if (chars.isEmpty)
        openParentheses == 0
      else
        chars.head match {
          case '(' => checkBalance(chars.tail, openParentheses + 1)
          case ')' => if (openParentheses == 0) false else checkBalance(chars.tail, openParentheses - 1)
          case _ => checkBalance(chars.tail, openParentheses)
        }
    }

    checkBalance(chars, 0);
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int], current: Int = 0): Int = {
      if (money == 0) return 1;
      if (money < 0) return 0;

      var count = 0

      coins
        .filter(coin => current == 0 || coin <= current) // Fist time all, then all less or equal
        .foreach(coin => count += countChange(money - coin, coins, coin))

      return count;
  }
}
