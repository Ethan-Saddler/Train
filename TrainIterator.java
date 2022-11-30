import java.lang.Iterable;
import java.util.Iterator;

public class TrainIterator<T> implements Iterator {
    private TrainCar<T> nextCar;

    public TrainIterator(Train train) {
        if(train == null) {
            throw new IllegalArgumentException();
        }
        this.nextCar = train.getEngine();
    }
    
    public boolean hasNext() {
        return nextCar != null; 
    }
    public T next() {
        T next = nextCar.getCargo();
        nextCar = nextCar.getNextCar();
        return next;
    }
}
