import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface UniversityCampus { // Component,Abstract Aggregate
    void add(UniversityCampus universityCampus);

    void remove(UniversityCampus universityCampus);

    void Display(int indent);

    String getName();

    UniversityCampusIterator createIterator();

}

interface UniversityCampusIterator {//Abstract Iterator

    boolean hasNext();
    UniversityCampus next();
}

class CompositeIterator implements UniversityCampusIterator {// Aggregate Iterator
    private Iterator<UniversityCampus> iterator;
    private UniversityCampus current;

    public CompositeIterator(Iterator<UniversityCampus> iterator) {
        this.iterator = iterator;
        this.current = null;
    }

    @Override
    public boolean hasNext() {
        if (current != null) {// if the current item is not null it will returns true
            return true;
        }

        if (iterator.hasNext()) {//ittarates to find other elements
            current = iterator.next();// shows the next element and assign it to the current
            return true;
        }

        return false;// if current item is false
    }

    @Override
    public UniversityCampus next() {
        if (hasNext()) {// checks if there is a next item
            UniversityCampus universityCampus = current;//current used as a temp
            current = null;//sets the current to null
            return universityCampus;// return universitycampus which represent the next item
        }

        return null;
    }
}


class Test {


    public static void main(String[] args) {
        ClassroomAllocator classroomAllocator=new ClassroomAllocator();
        classroomAllocator.allocateClassroom();







    }
}
