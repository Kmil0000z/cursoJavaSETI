package co.com.crudtest.model.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

  private String id;
  private int numPatas;
  private String genero;
  private String especie;
  private String habitad;
  private boolean domestico;
}
