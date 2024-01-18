package sz.sapphirex.pokedex.data.local.entity

interface EntityInterface {
    fun toBase(): Any
    fun toDto(): Any
}