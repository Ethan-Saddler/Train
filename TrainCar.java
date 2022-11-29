public class TrainCar<T> {
    private T cargo;
    private T nextCar;

    public TrainCar(T cargo) {
        if(cargo == null) {
            throw new IllegalArgumentException();
        }
        this.cargo = cargo;
        this.nextCar = null;
    }

    public TrainCar(T cargo, T nextCar) {
        this(cargo);
        this.nextCar = nextCar;
    }

    public T getCargo() {
        return this.cargo;
    }
    public T getCar() {
        return this.nextCar;
    }
    public void setCargo(T cargo) {
        this.cargo = cargo;
    }
    public void setCar(T nextCar) {
        this.nextCar = nextCar;
    }
}