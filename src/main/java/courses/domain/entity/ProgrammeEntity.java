package courses.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "programmes")
public class ProgrammeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String nameDA;
    private String nameEN;

    public ProgrammeEntity() { }

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

}
