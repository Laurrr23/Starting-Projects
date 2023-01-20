package ro.jlg.train.api.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.train.api.application.DTO.Train.CreateTrainDto;
import ro.jlg.train.api.application.DTO.Train.EditTrainDto;
import ro.jlg.train.api.application.TrainService;
import ro.jlg.train.api.domain.train.Train;

import java.util.List;

@RestController
@RequestMapping("/train")
@AllArgsConstructor
public class TrainRestController {
   private TrainService trainService;

    @PostMapping
    public ResponseEntity<Void> create(final  @RequestBody CreateTrainDto dto){
            this.trainService.create(dto);


            return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Train>> readAll(){
        return ResponseEntity.ok(this.trainService.getAll());

    }
    @DeleteMapping("/{trainId}")
    public ResponseEntity<Void> deleteTrainById(final @PathVariable String trainId){
        this.trainService.deleteTrainById(trainId);
        return ResponseEntity.ok().build();
    }
    @PatchMapping
    public ResponseEntity<Void>edit(final @RequestBody  EditTrainDto dto){
        this.trainService.edit(dto);
        return ResponseEntity.ok().build();


    }

}
