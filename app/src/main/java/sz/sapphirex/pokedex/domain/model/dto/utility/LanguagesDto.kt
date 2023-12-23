package sz.sapphirex.pokedex.domain.model.dto.utility

import sz.sapphirex.pokedex.domain.model.base.utility.Name

data class LanguageDto(
    val id: Int,
    val name: String,
    val official: Boolean,
    val iso639: String,
    val iso3166: String,
    val names: List<Name>
)