// Basci generic class

class Basic1 {}

class Basic2 extends Basic1 {}

class Basic3 extends Basic2 {}

class BasicGenericClass[-T](p: T) {

}

var listOfGnericValue = List[BasicGenericClass[Basic2]]()

listOfGnericValue = listOfGnericValue.:+(new BasicGenericClass[Any](new Basic3))
listOfGnericValue = listOfGnericValue.:+(new BasicGenericClass[Basic2](new Basic2))
