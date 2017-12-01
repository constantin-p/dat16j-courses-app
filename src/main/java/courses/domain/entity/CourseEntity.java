package courses.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String nameDA;
    private String nameEN;
    private boolean isMandatory;
    private int ectsPoints;
    private String language;
    private int minStudents;
    private int expStudents;
    private int maxStudents;
    private String prerequisites;
    private String outcome;
    private String activities;
    private String examForm;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "course_programme",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "programme_id")
    )
    private List<ProgrammeEntity> programmes = new ArrayList<>();


    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "course_teacher",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> teachers = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> students = new ArrayList<>();

    public CourseEntity() { }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNameDA() {
        return nameDA;
    }

    public void setNameDA(String nameDA) {
        this.nameDA = nameDA;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMinStudents() {
        return minStudents;
    }

    public void setMinStudents(int minStudents) {
        this.minStudents = minStudents;
    }

    public int getExpStudents() {
        return expStudents;
    }

    public void setExpStudents(int expStudents) {
        this.expStudents = expStudents;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public List<ProgrammeEntity> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<ProgrammeEntity> programmes) {
        this.programmes = programmes;
    }

    public List<UserEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<UserEntity> teachers) {
        this.teachers = teachers;
    }

    public List<UserEntity> getStudents() {
        return students;
    }

    public void setStudents(List<UserEntity> students) {
        this.students = students;
    }
}
