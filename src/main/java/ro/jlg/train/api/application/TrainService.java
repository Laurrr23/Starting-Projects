package ro.jlg.train.api.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.jlg.train.api.application.DTO.Train.CreateTrainDto;
import ro.jlg.train.api.application.DTO.Train.EditTrainDto;
import ro.jlg.train.api.domain.train.Train;
import ro.jlg.train.api.domain.train.TrainRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service

public class TrainService {
    private TrainRepository repository;


    public void create(final CreateTrainDto dto){
        final Train train = new Train(UUID.randomUUID().toString(),
                dto.getDeparture(),
                dto.getDestination(),
                LocalDateTime.parse(dto.getDepartureTime()),
                dto.getNumberOfSeats());


        this.repository.save(train);


}
    public List<Train> getAll(){

        return this.repository.getAll();
    }
    public void deleteTrainById(final String trainId){

        this.repository.remove(trainId);
    }

    public void edit(final EditTrainDto dto){
        //1.find the train in DB.
        final Train existingTrain = this.repository.getById(dto.getId());

        //2.Edit the fields of existing train.
        existingTrain.update(dto.getDeparture(),
                dto.getDestination(),
                LocalDateTime.parse(dto.getDepartureTime()),
                        dto.getNumberOfSeats());
        //3.Save the new train after edit.
        this.repository.save(existingTrain);
    }

}
