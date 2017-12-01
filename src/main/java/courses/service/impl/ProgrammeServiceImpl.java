package courses.service.impl;

import courses.dao.ProgrammeRepository;
import courses.domain.dto.ProgrammeDTO;
import courses.domain.entity.ProgrammeEntity;
import courses.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProgrammeServiceImpl implements ProgrammeService {

    @Autowired
    private ProgrammeRepository programmeRepository;

    @Override
    public ProgrammeEntity saveProgramme(ProgrammeDTO programmeDTO) {
        final ProgrammeEntity programme = new ProgrammeEntity();

        programme.setNameDA(programmeDTO.getNameDA());
        programme.setNameEN(programmeDTO.getNameEN());

        return programmeRepository.save(programme);
    }
}
