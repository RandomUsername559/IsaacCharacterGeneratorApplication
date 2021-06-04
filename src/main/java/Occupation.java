public class Occupation {
    String jobName;
    Float salary;

    public Occupation(String jobName, Float salary) {
        this.jobName = jobName;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "Occupation{" +
                "jobName='" + jobName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
