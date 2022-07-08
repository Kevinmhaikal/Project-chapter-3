class People(name : String) : Player() {

    override var score : Int = 0

    @Override
    override fun playerHand(): String {
        return Utils.getResult("Pilih yang mana ${this.name} : ")
    }

    init {
        super.name = name
        super.score = score

    }
}