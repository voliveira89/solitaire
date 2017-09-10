import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFondationPile() {
        var numGames = 0
        var maxGames = 10000

        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 1..100) {
                GameModel.onDeckTap()
                GameModel.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tablePile ->
                    GamePresenter.onTableauTap(index, tablePile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        GameModel.debugPrint()
        println("# Games: $numGames")
        assert(numGames < maxGames)
    }
}