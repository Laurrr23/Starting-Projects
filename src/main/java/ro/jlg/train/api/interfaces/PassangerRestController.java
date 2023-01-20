package ro.jlg.train.api.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.train.api.application.DTO.Passanger.CreatePassangerDto;
import ro.jlg.train.api.application.DTO.Passanger.EditPassangerDto;
import ro.jlg.train.api.application.PassangerService;
import ro.jlg.train.api.domain.passanger.Passanger;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/passanger")
public class PassangerRestController {
    private PassangerService passangerService;

    @PostMapping
    public ResponseEntity<Void> create(final @RequestBody CreatePassangerDto dto) throws Exception {
        this.passangerService.create(dto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Passanger>> readAll() {
        return ResponseEntity.ok(this.passangerService.getAll());
    }
    @DeleteMapping("/{passangerId}")
    public ResponseEntity<Void>deleteById(final @PathVariable String  passangerId){
        this.passangerService.deleteById(passangerId);
        return ResponseEntity.ok().build();
    }
    @PatchMapping
    public ResponseEntity<Void>edit(final @RequestBody EditPassangerDto dto){
        this.passangerService.edit(dto);
        return ResponseEntity.ok().build();
    }

}
