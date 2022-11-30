import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO JAVADOC
public class Train<T> implements List<T> {

    private TrainCar<T> engine;
    private int size;

    // TODO JAVADOC
    public Train() {
        engine = null;
        size = 0;
    }

    // TODO JAVADOC
    public Train(T[] cargoArray) {
        if (cargoArray == null) {
            throw new IllegalArgumentException("cargoArray cannot be null");
        }
        for (T cargo : cargoArray) {
            if (cargo == null) {
                throw new IllegalArgumentException("cargo cannot be null");
            }
            add(cargo); // keep adding to end
        }
    }

    // TODO JAVADOC
    public TrainCar<T> getEngine() {
        return engine;
    }

    // TODO JAVADOC
    public T[] toArray() {
        T[] t = (T[]) new Object[size];
        TrainIterator iterator = new TrainIterator<T>(this);
        int index = 0;
        while(iterator.hasNext()) {
            t[index] = (T) iterator.next();
        }
        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== TRAIN %d =====\nisEmpty: %s\nsize: %d\nengine: %s\nCHOO CHOO: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (engine == null ? "null" : engine.getCargo())));

        T[] cargo = toArray();
        if (cargo == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < cargo.length - 1; ++i) {
                sb.append(String.format("%s, ", cargo[i])); // append all but last value
            }
            if (cargo.length > 0) {
                sb.append(String.format("%s", cargo[cargo.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            engine = new TrainCar(element);
            size++;
            return;
        }
        TrainCar<T> current = engine;
        while(current.getNextCar() != null) {
            current = current.getNextCar();
        }
        current.setNextCar(new TrainCar(element));
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        } 
        if (size == index) {
            this.add(element);
            return;
        }
        if(index == 0) {
            TrainCar<T> car = new TrainCar(element);
            car.setNextCar(engine);
            engine = car;
            size++;
            return;
        }
        if (element == null) {
            throw new IllegalArgumentException();
        }
        TrainCar<T> current = engine;
        while(index != 1) {
            current = current.getNextCar();
            index--;
        }
        TrainCar<T> next = current.getNextCar();
        current.setNextCar(new TrainCar(element));
        current.getNextCar().setNextCar(next);
        size++;

    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        TrainCar<T> temp = engine;
        engine = engine.getNextCar();
        temp.setNextCar(null);
        size--;
        return temp.getCargo();

    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        TrainCar<T> current = engine;
        int loop = 0;
        while(loop != index - 1) {
            current = current.getNextCar();
            loop++;
        }
        if (index == size - 1) {
            TrainCar<T> temp = current.getNextCar();
            current.setNextCar(null);
            size--;
            return temp.getCargo();
        }
        TrainCar<T> temp = current.getNextCar();
        current.setNextCar(temp.getNextCar());
        temp.setNextCar(null);
        size--;
        return temp.getCargo();
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (engine.getCargo().equals(element)) {
            TrainCar<T> temp = engine;
            engine = null;
            temp.setNextCar(null);
            return temp.getCargo();
            
        }
        int index = 0;
        TrainCar<T> current = engine;
        while (index < size) {
            if(current.equals(element)) {

            }
            index++;
        }
        return null;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        return null; // FIXME
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null; // FIXME
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        return false; // FIXME
    }

    @Override
    public void clear() {
        // FIXME
    }

    @Override
    public boolean isEmpty() {
        return false; // FIXME
    }

    @Override
    public int size() {
        return 0; // FIXME
    }

    @Override
    public Iterator<T> iterator() {
        return null; // FIXME
    }
}
