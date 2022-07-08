object Utils {

    val panggil1 = setOf("1")
    val panggil2 = setOf("2")
    val panggil3 = setOf("3")

    enum class Finger(val nama : String) {
        A("batu"),
        B("gunting"),
        C("kertas")
    }

    var handName = arrayOf(
        Finger.A.nama,
        Finger.B.nama,
        Finger.C.nama
    )

    private var handInMenu = listOf(
        "    ROCK   =>   batu",
        "    PAPER   =>   kertas",
        "   SCISSOR   =>   gunting")

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
            ?.replace("\t","")?.replace("rock","batu")
            ?.replace("scissor", "gunting")?.replace("paper","kertas")

        while (userKeyword !in handName){
            print("Hanya boleh pilih salah satu di atas : ")
            userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
                ?.replace("\t","")?.replace("rock","batu")
                ?.replace("scissor", "gunting")?.replace("paper","kertas")
        }
        return userKeyword!!
    }

    fun getHeaderGame(){
        println("|=========================|")
        println("|==Kertas--Gunting--Batu==|")
        println("|=========================|")
    }

    fun getMainMenu(){
        println("1. Pemain vs Pemain")
        println("2. Pemain vs Komputer")
        println("3. Exit")
        print("Choose menu : ")
    }


    fun getGameOver(){
        println("""                
          Game Berakhir""".trimIndent())
    }

    fun getSayGoodBye(){
        getHeaderGame()
        println("====== SAMPAI JUMPA LAGI ====")
    }

    fun getYorN(message : String) : Boolean{
        val yesWord = setOf("y", "Y")

        val noWord = setOf("n", "N")

        print("$message : ")
        var inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
            ?.replace("\t","")?.replace("-","")
        while (inputUser !in yesWord && inputUser !in noWord){
            inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
                ?.replace("\t","")?.replace("-","")
        }
        return inputUser in yesWord
    }

    private fun clearScreen(){
        val y = 16
        for (baris in 0..y){
            println()
        }
    }

}