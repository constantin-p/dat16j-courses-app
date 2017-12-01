package courses.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "usertypes")
public class UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    public UserTypeEntity() {
        super();
    }

    public UserTypeEntity(String name) {
        super();
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
