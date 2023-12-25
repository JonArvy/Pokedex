package sz.sapphirex.pokedex.core.logger

interface Logger {
    fun database(tag: String, message: String, nested: Boolean = false,severity: Int = 3)
    fun api(tag: String, message: String, nested: Boolean = false, severity: Int = 3)
    fun model(tag: String, message: String, nested: Boolean = false, severity: Int = 3)
    fun serialization(tag: String, message: String, nested: Boolean = false, severity: Int = 3)
    fun generic(tag: String, message: String, nested: Boolean = false, severity: Int = 3)
}