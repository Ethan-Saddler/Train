public class TrainCar<T> {
    private T cargo;
    private TrainCar<T> nextCar;

    public TrainCar(T cargo) {
        if(cargo == null) {
            throw new IllegalArgumentException();
        }
        this.cargo = cargo;
        this.nextCar = null;
    }

    public TrainCar(T cargo, TrainCar<T> nextCar) {
        this(cargo);
        this.nextCar = nextCar;
    }

    public T getCargo() {
        return this.cargo;
    }
    public TrainCar<T> getNextCar() {
        return this.nextCar;
    }
    public void setCargo(T cargo) {
        this.cargo = cargo;
    }
    public void setNextCar(TrainCar<T> nextCar) {
        this.nextCar = nextCar;
    }
}