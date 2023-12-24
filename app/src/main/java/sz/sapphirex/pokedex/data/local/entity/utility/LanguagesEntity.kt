package sz.sapphirex.pokedex.data.local.entity.utility

data class LanguageEntity(
    val id: Int,
    val name: String,
    val official: Boolean,
    val iso639: String,
    val iso3166: String,
    val names: List<NameEntity>
)