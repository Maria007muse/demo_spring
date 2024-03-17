package stores;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient implements Persistable<String>{
@Id
private String id;
private String name;
private Type type;
public enum Type {
WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
}
@Override
public boolean isNew() {
return true;
}
}