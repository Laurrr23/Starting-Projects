package ro.jlg.train.api.domain.passanger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Document
public class Passanger {
    @Id
    private String id;
   private String name;
   private String trainId;

   public void update(
       final String newName
    ){
       this.name = newName;
   }
}
