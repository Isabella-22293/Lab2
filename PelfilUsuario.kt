class PelfilUsuario {
    import java.util.*

    // Definición de la clase Hobby
    data class Hobby(val título: String, val descripción: String, val urlPhoto: String?)

    // Definición de la clase PerfilUsuario
    class perfilUsuario(
        val ID: Int,
        val nombres: String,
        val apellidos: String,
        val urlPhoto: String?,
        val edad: Int,
        val correo: String,
        val biografía: String?,
        estado: String
    ) {
        var estado: String = "Activo"
            set(value) {
                if (value in listOf("Activo", "Pendiente", "Inactivo")) {
                    field = value
                } else {
                    throw IllegalArgumentException("El estado debe ser 'Activo', 'Pendiente' o 'Inactivo'.")
                }
            }

        val hobbies = mutableListOf<Hobby>()

        // Función para agregar un Hobby al perfil
        fun agregarHobby(hobby: Hobby) {
            hobbies.add(hobby)
        }
    }
}