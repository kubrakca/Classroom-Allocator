import java.util.*;
abstract class Subject {
    private List<TestSchedulerObserver> observers = new ArrayList<>();

    public void registerObserver(TestSchedulerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TestSchedulerObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String day) {
        for (TestSchedulerObserver observer : observers) {
            observer.notifyTestScheduled(day);
        }
    }
}

class Classroom extends Subject implements UniversityCampus,TestSchedulerObserver {
    private boolean available;// Leaf
    private String classroomName;
    private int capacity;
    private List<ReservationTimes> reservationTimesList=new ArrayList<>();



    public Classroom(String classroomName, int capacity) {
        this.classroomName = classroomName;
        this.capacity=capacity;
        available=true;

    }

    public boolean isAvailable(int beginTime, int endTime) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the date: ");
        String date= scan.nextLine();
        if(date.equals("June 24")||date.equals("June 16")||date.equals("October 3")){
            notifyTestScheduled(date);
        }
        for (ReservationTimes reservationTimes : reservationTimesList) {
            if (beginTime < reservationTimes.getEndTime() && endTime > reservationTimes.getBeginTime()) {
                return available=false;
            }
        }

        return available;
    }



    public void Reservation(int beginTime,int endTime){
        reservationTimesList.add(new ReservationTimes(beginTime,endTime));
    }



    @Override
    public void add(UniversityCampus universityCampus) {
        // Leaf node, no child elements to add
    }


    @Override
    public void remove(UniversityCampus universityCampus) {
        // Leaf node, no child elements to remove
    }

    @Override
    public void Display(int indent) {
        for (int i = 1; i <= indent; i++) {
            System.out.print("-");
        }
        System.out.println("+ " + getName() + " -- Capacity:" + getCapacity());
    }


    @Override
    public String getName() {
        return classroomName;
    }

    public int getCapacity(){
        return capacity;
    }



    @Override
    public UniversityCampusIterator createIterator() {
        return null;
    }

    @Override
    public void notifyTestScheduled(String day) {// notifies all observers
        available = false;
        System.out.println("Classroom " + classroomName + " is not available on " + day);


    }

}

class ReservationTimes{
    private int beginTime;
    private int endTime;

    public ReservationTimes(int beginTime,int endTime) {
        this.beginTime = beginTime;
        this.endTime=endTime;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getEndTime() {
        return endTime;
    }


}
interface TestSchedulerObserver {// Observer
    void notifyTestScheduled(String day);
}






