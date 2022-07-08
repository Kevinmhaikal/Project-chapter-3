abstract class Player {
    open lateinit var name : String
    open var score : Int = 0
    abstract fun playerHand() : String

    private var a = Utils.Finger.A.nama
    private var b = Utils.Finger.B.nama
    private var c = Utils.Finger.C.nama


    fun attack(opponent : Player){
        println("\n  Saatnya ${this.name} melawan ${opponent.name}\n")


        fun getLiveResult(){
            println(                       "\n Status Pemain"                                  )
            println("==========================================================================")
            print(String.format("| Nama   |  %-25s", this.name))
            print(String.format("||   %-25s", opponent.name))
            println("      |")
            print(String.format("| Win    |  %-25s", this.score))
            print(String.format("||   %-25s", opponent.score))
            println("      |")
            println("==========================================================================")
        }
        getLiveResult()

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        fun getHandResult(){
            Utils.getHeaderGame()
            println()

            println((playerOneHand))
            println("VS")
            println((playerTwoHand))

            print(String.format("             %-25s", "-> ${this.name} = ${playerOneHand.uppercase()}"))
            print(String.format("     %-25s", "-> ${opponent.name} = ${playerTwoHand.uppercase()}\n"))
        }



        if (playerOneHand==playerTwoHand){
            getHandResult()
            print("\n                   ||***************** DRAW      ******************||")
            getLiveResult()
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            getHandResult()
            print("SCORE\n")
            this.score++
            getLiveResult()
        } else {
            getHandResult()
            print("\n\n$                  ||****************** ${opponent.name} WIN ******************||")
            getLiveResult()
        }

        if (this.score <=0.0 || opponent.score <=0.0){
            Utils.getHeaderGame()
            Utils.getGameOver()
            if (this.score <=0){
                print("${opponent.name}\n" +
                        "MENANG \n"
                )
                getLiveResult()
            } else {
                print("""
                         ${this.name}
                          MENANG
                """.trimMargin())
                getLiveResult()
            }

            this.score = 0
            opponent.score = 0
        }
    }
}