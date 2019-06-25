fun main() {

    val child = ChildClass("Lohot",15)
    println(child.printName())
    child.showParentFunction()
    child.grow()
    child.play()

    println(ChildClass.createInstance().printName())
    println(ChildClass.TAG)
}

abstract class ParentClass (open var name: String, open val umur : Int){
    abstract fun grow()
    fun showParentFunction(){
        println("you call parent Function")
    }
}

//Inheritance di kotlin, dengan menambahkan keyword 'override' sebelum variable dari child class,
//implementasi interface atau extends parentclass diletakkan setelah ':', untuk extends menggunakan '()' utk melewati parameter super.
//utk interface tanpa menggunakan '()'
class ChildClass (override var name : String,override val umur: Int) : ParentClass(name, umur), Children{

    companion object{
        fun createInstance() = ChildClass("Default", 10)
        var TAG = "Ini Companion Object (Static pada Java)"
    }

    override fun play() {
        println("Implements interface method")
    }

    override fun grow() {
        println("Implements parents method")
        super.showParentFunction()
    }

    //inline function
    fun printName() = "Hi there, my name is $name and i'm $umur years old"
}

interface Children{
    fun play()
}

