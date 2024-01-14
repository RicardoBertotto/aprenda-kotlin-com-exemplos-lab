enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(var nomeUsuario: String, val ID: Int){
    override fun equals(other: Any?) =
        other is Usuario && other.ID == this.ID
}
data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel)

val inscritos = mutableListOf<Usuario>()
val K1 = ConteudoEducacional("IntroKotlin",1)
val K2 = ConteudoEducacional("KotlinFunctions",2)
val K3 = ConteudoEducacional("KotlinClasses",2)
val ConteudosPrimeiroCurso: MutableList<ConteudoEducacional> = mutableListOf()
val IntroKotlin = Formacao("Introdução ao Kotlin", ConteudosPrimeiroCurso, Nivel.BASICO)
fun matricular(usuario: Usuario) {
    //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    inscritos.add(usuario)
}
fun cadastrar(conteudo: ConteudoEducacional){
    ConteudosPrimeiroCurso.add(conteudo)
}
fun printMessage(message: String): Unit {
    println(message)
}

fun getinscritos(): List<Usuario> {
    return inscritos
}
fun getconteudos(): List<ConteudoEducacional> {
    return IntroKotlin.conteudos
}
fun main() {
    val um = Usuario("nome",1)
    printMessage(um.nomeUsuario)
    matricular(um)
    getinscritos().forEach {
            i -> println("O usuario ${i.nomeUsuario} está inscrito.")
    }


//TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")


    cadastrar(K1)
    cadastrar(K2)
    cadastrar(K3)

    println("O curso ${IntroKotlin.nome} conta com os seguintes conteúdos:")
    getconteudos().forEach {
            i -> println("-${i.nome}")
    }
}