package courses.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ProgrammeDTO {
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String nameDA;

    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String nameEN;

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
