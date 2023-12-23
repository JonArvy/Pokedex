package sz.sapphirex.pokedex.domain.model.dto.utility

data class LanguageDto(
    val id: Int,
    val name: String,
    val official: Boolean,
    val iso639: String,
    val iso3166: String,
    val names: List<NameDto>
)