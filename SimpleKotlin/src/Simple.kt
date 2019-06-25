fun main(){
    var list = LinkedList()
    list =insertNode(1,list)
    list = insertNode(2,list)
    list = insertNode(3,list)
    list = insertNode(4,list)
    list = insertNode(5,list)

    printList(list)
    print(findMax(list))


}

class LinkedList(var head : Node? = null){

}

class Node(val data: Int, var next: Node? = null){

}

fun insertNode (data: Int, list: LinkedList) : LinkedList{
    var newNode = Node(data)

    if (list.head == null){
        list.head = newNode
    }else{
        var currentNode = list.head
        while (currentNode!!.next != null){
            currentNode = currentNode.next!!
        }
        currentNode.next = newNode
    }

    return list
}

fun printList(list : LinkedList){
    if (list.head == null){
        print("the list is empty")
    }else{
        var currentNode = list.head
        while (currentNode != null){
            print(currentNode.data)
            print("\n")
            currentNode = currentNode.next
        }
    }
}

fun findMax(list : LinkedList) : Int? {
    var result : Int

    return if (list.head == null){
        null
    }else{
        result = list.head!!.data
        var currentNode = list.head
        while (currentNode!!.next != null){
            currentNode = currentNode.next
            if (currentNode!!.data > result)
                result = currentNode.data
        }
        result
    }
}

//fun deleteNode(data: Int, list: LinkedList) : LinkedList {
//    if (list.head == null){
//        println("List is empty")
//    }else{
//        var currentNode = list.head!!.next
//        var  beforeNode = list.head
//        if (list.head!!.data == data){
//            if (list.head!!.next == null){
//                return list
//            }else
//                list.head = list.head!!.next
//        }
//        while (currentNode?.next != null) {
//            if (currentNode.data == data) {
//                beforeNode!!.next = currentNode.next
//                break
//            }
//        }
//    }
//    return list
//
//}

