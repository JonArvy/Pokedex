package sz.sapphirex.pokedex.domain.model.base

interface BaseInterface {
    fun toDto(): Any
    fun toEntity(): Any
}