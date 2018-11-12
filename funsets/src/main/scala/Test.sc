type Set = Int => Boolean

def func(x: Int) : Boolean = x < 0

val func2: Set = func

func(1)
func(0)
func2(-1)