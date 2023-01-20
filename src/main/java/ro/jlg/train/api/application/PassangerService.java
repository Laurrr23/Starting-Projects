package ro.jlg.train.api.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.jlg.train.api.application.DTO.Passanger.CreatePassangerDto;
import ro.jlg.train.api.application.DTO.Passanger.EditPassangerDto;
import ro.jlg.train.api.domain.passanger.Passanger;
import ro.jlg.train.api.domain.passanger.PassangerRepository;
import ro.jlg.train.api.domain.train.Train;
import ro.jlg.train.api.domain.train.TrainRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PassangerService {
    private PassangerRepository passangerRepository;
    private TrainRepository trainRepository;

    @Transactional
    public void create(final CreatePassangerDto dto) throws Exception {


        final Train passangerTrain = this.trainRepository.getById(dto.getTrainId());
        passangerTrain.reservedSeat();

        final Passanger passanger = new Passanger(UUID.randomUUID().toString(), dto.getName(), dto.getTrainId());


        this.passangerRepository.save(passanger);
        this.trainRepository.save(passangerTrain);

    }

    public List<Passanger> getAll() {
        return this.passangerRepository.getAll();
    }

    public void deleteById(final String passangerId) {
        this.passangerRepository.remove(passangerId);
    }

    public void edit(final EditPassangerDto dto) {

        final Passanger existingPassanger = this.passangerRepository.getById(dto.getId());

        existingPassanger.update(dto.getName());
        this.passangerRepository.save(existingPassanger);
    }
}
