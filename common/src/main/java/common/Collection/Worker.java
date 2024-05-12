package common.Collection;

import common.utils.CommonConstants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

/**
 *
 */
public class Worker implements Comparable<Worker>, Serializable {
    /**
     * Worker's id,
     * <p>Must be greater than zero,
     * <p>Must be unique,
     * <p>Value is generated automatically
     */
    private long id;

    /**
     * Worker's name,
     * <p>Can't be null,
     * <p>Can't be empty
     */
    private String name;

    /**
     * Worker's coordinates,
     * <p>Can't be null
     */
    private Coordinates coordinates;

    /**
     * Creation date of object,
     * <p>Can't be null,
     * <p>Value is generated automatically
     */
    private java.time.ZonedDateTime creationDate;

    /**
     * Worker's salary,
     * <p>Can't be null,
     * <p>Must be greater than zero
     */
    private Integer salary;

    /**
     * Start day of work,
     * <p>Can't be null
     */
    private java.time.LocalDateTime startDate;

    /**
     * End day of work,
     * <p>Can't be null
     */
    private java.time.LocalDateTime endDate;

    /**
     * Worker's status,
     * <p>Can't be null
     */
    private Status status;

    /**
     * Person of worker,
     * <p>Can't be null
     */
    private Person person;

    public Worker(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer salary, LocalDateTime startDate, LocalDateTime endDate, Status status, Person person) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.person = person;
    }

    /**
     * Method to get id
     * @return id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Method to set id
     * @param id new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Method to get salary
     * @return salary
     */
    public Integer getSalary() {
        return this.salary;
    }

    /**
     * Method to get end date
     * @return end date
     */
    public LocalDateTime getEndDate(){
        return this.endDate;
    }

    /**
     * Method to get name of worker
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get coordinates of worker
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Method to get creation date of worker object
     * @return ZonedDateTime creationDate
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Method to get start date of worker
     * @return LocalDateTime workers start day
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Method to get status of worker
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Method to get worker Person
     * @return Person
     */
    public Person getPerson() {
        return person;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Method to compare to workers
     * <p>Elements are compared by their name, or id if name is equal
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Worker o) {
        if(this.name.equals(o.getName())){
            return (int) (this.id - o.getId());
        }
        return this.name.compareTo(o.getName());
    }

    /**
     * Method to get formatted String representation of worker
     * @return Formatted String with structured info about element
     */
    @Override
    public String toString() {
        return "Worker [id = " + id + "]:\n" +
                "\tname: '" + name + "\'\n" +

                "\tcoordinates:\n" +
                (Objects.isNull(coordinates) ? "\t\tnull" :
                "\t\tx: " + coordinates.getX() + "\n" +
                "\t\ty: " + coordinates.getY()) + "\n" +

                "\tcreationDate: " + creationDate.format(CommonConstants.formatter) + "\n" +
                "\tsalary: " + salary + "\n" +
                "\tstartDate: " + startDate.toLocalDate().format(CommonConstants.formatter) + "\n" +
                "\tendDate: " + (!Objects.isNull(endDate) ? endDate.toLocalDate().format(CommonConstants.formatter) : null) + "\n" +
                "\tstatus: " + status + "\n" +

                "\tperson:\n" +
                (Objects.isNull(person) ? "\t\tnull" :
                "\t\theight: " + person.getHeight() + "\n" +
                "\t\teyeColor: " + person.getEyeColor() + "\n" +
                "\t\tnationality: " + person.getNationality());
    }

    public LinkedHashMap<String, String> getAsStringMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("id", String.valueOf(id));
        map.put("name", name);
        map.put("x", String.valueOf(coordinates.getX()));
        map.put("y", String.valueOf(coordinates.getY()));
        map.put("creationDate", creationDate.format(CommonConstants.formatter));
        map.put("salary", String.valueOf(salary));
        map.put("startDate", startDate.toLocalDate().format(CommonConstants.formatter));
        map.put("endDate", !Objects.isNull(endDate) ? endDate.toLocalDate().format(CommonConstants.formatter) : "");
        map.put("status", String.valueOf(status));
        if(person == null){
            map.put("height", ""); map.put("eyeColor", ""); map.put("nationality", "");
        }
        else{
            map.put("height", String.valueOf(person.getHeight()));
            map.put("eyeColor", person.getEyeColor() == null ? "" : String.valueOf(person.getEyeColor()));
            map.put("nationality", person.getNationality() == null ? "" : String.valueOf(person.getNationality()));
        }
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return id == worker.id && Objects.equals(name, worker.name) && Objects.equals(coordinates, worker.coordinates) && Objects.equals(creationDate, worker.creationDate) && Objects.equals(salary, worker.salary) && Objects.equals(startDate, worker.startDate) && Objects.equals(endDate, worker.endDate) && status == worker.status && Objects.equals(person, worker.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary, startDate, endDate, status, person);
    }
}

