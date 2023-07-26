class Hobby {
    fun agregarHobby(perfiles: MutableList<PerfilUsuario>) {
        println("---------- AGREGAR HOBBY ----------")
        print("Ingresa el ID o Nombres y/o Apellidos del perfil: ")
        val query = readLine()

        val perfilEncontrado = perfiles.find { perfil ->
            perfil.ID.toString() == query || perfil.nombres.contains(query!!, ignoreCase = true) || perfil.apellidos.contains(
                query,
                ignoreCase = true
            )
        }

        if (perfilEncontrado != null) {
            println("Perfil encontrado:")
            println("ID: ${perfilEncontrado.ID}")
            println("Nombres: ${perfilEncontrado.nombres}")
            println("Apellidos: ${perfilEncontrado.apellidos}")

            println("---------- HOBBIES DISPONIBLES ----------")
            val hobbiesDisponibles = listOf(
                Hobby("Fotografía", "Me encanta capturar momentos especiales.", null),
                Hobby("Cocina", "Disfruto preparando deliciosas comidas.", null),
                Hobby("Yoga", "Me relaja y me mantiene en forma.", null),
                Hobby("Guitarra", "Toco la guitarra en mi tiempo libre.", null),
                // Puedes agregar más hobbies aquí si lo deseas
            )

            for ((index, hobby) in hobbiesDisponibles.withIndex()) {
                println("${index + 1}. ${hobby.título}")
                println("   Descripción: ${hobby.descripción}")
                println("   URL de la foto: ${hobby.urlPhoto ?: "No disponible"}")
            }

            print("Selecciona el número del hobby que deseas agregar: ")
            val hobbySeleccionado = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Número inválido.")

            if (hobbySeleccionado in 1..hobbiesDisponibles.size) {
                val hobby = hobbiesDisponibles[hobbySeleccionado - 1]
                perfilEncontrado.agregarHobby(hobby)
                println("Hobby '${hobby.título}' agregado exitosamente al perfil.")
            } else {
                println("Número de hobby inválido. No se agregó ningún hobby.")
            }
        } else {
            println("No se encontró ningún perfil con la información ingresada.")
        }
    }
}