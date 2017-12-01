package courses.service;

import courses.domain.dto.ProgrammeDTO;
import courses.domain.entity.ProgrammeEntity;

public interface ProgrammeService {
    ProgrammeEntity saveProgramme(ProgrammeDTO programmeDTO);
}
