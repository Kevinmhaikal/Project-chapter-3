
// Inisialisasi pilihan
// Menangkap pilihan player
// Menangkap pilihan komputer
// Random pilihan komputer
// Tampilkan hasil


import Main.Companion.twoPlayer
import Main.Companion.vsBot



fun main() {

    var isMenu = true

    loop@ while (isMenu){
        Utils.getHeaderGame()
        Utils.getMainMenu()
        val userKeyword = readLine()?.lowercase()?.trim()?.replace("\t","")
            ?.replace(" ","")
        println()
        when(userKeyword){
            in Utils.panggil1 -> twoPlayer()
            in Utils.panggil2 -> vsBot()
            in Utils.panggil3 -> break@loop
            else -> println("Pilihan hanya ada (1 - 3) ")
        }
        isMenu = Utils.getYorN("Mau balik ke menu? (y/n)")
    }
    Utils.getSayGoodBye()
}

class Main {

    companion object{

        private lateinit var playerSatu : People
        private lateinit var playerDua : People
        private lateinit var playerComputer : Computer

        private fun inputNamePlayerOne(){
            print("\"Kenalan dulu ya... Siapa nama kamu? P1 : ")
            var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ","")
                .replace("\t","")
            if (namaPlayerSatu.isBlank()){
                namaPlayerSatu = "Anonymous_1"
            }
            playerSatu = People(namaPlayerSatu)
        }

        fun twoPlayer(){
            inputNamePlayerOne()
            print("Kalo Kamu siapa namanya? P2 : ")
            var namaPlayerDua = readLine()!!.uppercase().trim().replace(" ","")
                .replace("\t","")
            if (namaPlayerDua.isBlank()){
                namaPlayerDua = "Anonymous_2"
            }
            playerDua = People(namaPlayerDua)

            var isKeepPlaying = true
            while (isKeepPlaying){
                playerSatu.attack(playerDua)
                isKeepPlaying = Utils.getYorN("Main lagi tidak? (y/n)")
            }
        }

        fun vsBot(){
            inputNamePlayerOne()
            playerComputer = Computer("Bot")
            playerComputer.name = "Computer"

            var isKeepPlaying = true
            while (isKeepPlaying){
                playerSatu.attack(playerComputer)
                isKeepPlaying = Utils.getYorN("Main lagi tidak? (y/n)")
            }
        }
    }
}