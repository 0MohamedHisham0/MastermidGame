package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var rightGuess = 0
    var newSecret = secret
    var newGuess = guess

    if (If_Repeted(guess)) {
        for (i in newSecret.indices) {
            for (g in newGuess.indices) {
                if (newSecret[i] != newGuess[i]) {
                    if (newSecret[g] != newGuess[g]) {
                        if (newSecret[i] == newGuess[g]) {
                            if (i == g)
                                rightPosition++
                            rightGuess++
                            newSecret = newSecret.removeChar(i, 'g')
                            newGuess = newGuess.removeChar(g, 's')


                            break
                        }
                    } else {

                        print("$g $i  ")
                        rightPosition++
                        rightGuess++
                        newSecret = newSecret.removeChar(g, 'g')
                        newGuess = newGuess.removeChar(g, 's')
                        println("$newSecret  $newGuess")
                        break
                    }
                } else {
                    rightPosition++
                    rightGuess++
                    newSecret = newSecret.removeChar(i, 'g')
                    newGuess = newGuess.removeChar(i, 's')
                    break
                }
            }
        }
    } else {
        for (i in secret.indices) {
            if (secret.contains(guess[i])) {
                rightGuess++
                if (secret[i] == guess[i]) {

                    rightPosition++
                }

            }
        }
    }
    return Evaluation(rightPosition, rightGuess - rightPosition)
}

fun If_Repeted(secret: String): Boolean {
    var B = false
    for (i in secret.indices) {
        for (j in i + 1 until secret.length) {
            if (j < 5) {
                if (secret[i] == secret[j]) {
                    B = true
                }
            }
        }
    }
    return B
}

fun String.removeChar(index: Int, char: Char): String {
    var string = ""
    if (index == this.length)
        string = this.substring(0, index) + char + this.substring(index, this.length)
    else
        string = this.substring(0, index) + char + this.substring(index + 1, this.length)

    return string
}
