package courses.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CourseDTO {
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String nameDA;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String nameEN;
    @NotNull(message = "error.auth.emptyField")
    private boolean isMandatory;
    @NotNull(message = "error.auth.emptyField")
    private int ectsPoints;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String language;
    @NotNull(message = "error.auth.emptyField")
    private int minStudents;
    @NotNull(message = "error.auth.emptyField")
    private int expStudents;
    @NotNull(message = "error.auth.emptyField")
    private int maxStudents;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String prerequisites;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String content;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String outcome;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String activities;
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String examForm;

    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private List<Long> programmes = new ArrayList<>();
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private List<Long> teachers = new ArrayList<>();
    private List<Long> students = new ArrayList<>();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<Long> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Long> programmes) {
        this.programmes = programmes;
    }

    public List<Long> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Long> teachers) {
        this.teachers = teachers;
    }

    public List<Long> getStudents() {
        return students;
    }

    public void setStudents(List<Long> students) {
        this.students = students;
    }
}
