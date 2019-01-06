object Chapter1{
    def abs(n : Int) : Int = {
        if(n < 0) -n
        else n
    }
    
    private def formatAbs(value : Int) = {
        val message = "The absolute value of %d is %d"
        message.format(value,abs(value)) 
    }

    def isSorted[A](array : Array[A], compare : (A, A) => Boolean) : Boolean = {
        @annotation.tailrec
        def loop(index : Int) : Boolean = {
            if(index == array.length-1) true
            else if(!compare(array(index),array(index + 1))) false
            else loop(index + 1)
        }
        loop(0)
    }

    def fibonacci(n : Int) : Int = {
        @annotation.tailrec
        def loop(n : Int, a : Int, b : Int) : Int = {
            if(n < 3) b
            else loop(n - 1, b, a + b)
        }
        loop(n, 0, 1)
    }

    def findFirst(array : Array[Int], key : Int) : Int = {
        @annotation.tailrec
        def loop(index : Int) : Int = {
            if(index >= array.length) -1
            else if(array(index) == key) index
            else loop(index + 1)
        }
        loop(0)
    }
    
    def findFirstHof[A](array : Array[A], f : A => Boolean) : Int = {
        @annotation.tailrec
        def loop(index : Int) : Int = {
            if(index >= array.length) -1
            else if(f(array(index))) index
            else loop(index + 1)
        }
        loop(0)
    }

    def factorial(n : Int) : Int = {
        @annotation.tailrec
        def loop(n : Int, acc : Int) : Int = {
            if(n <= 0) acc
            else loop(n - 1,acc*n)
        }
        loop(n, 1)
    }
    
    def main(args : Array[String]) : Unit  = {
        println(formatAbs(-42))
    }
}